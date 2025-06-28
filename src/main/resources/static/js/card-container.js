class CardContainer extends HTMLElement {
    constructor() {
        super();
        const type = this.getAttribute('type');

        if (type !== 'hiragana' && type !== 'katakana') {
            throw new Error('Invalid type attribute. Expected "hiragana" or "katakana".');
        }

        this.attachShadow({ mode: 'open' });
        this.shadowRoot.innerHTML = `
            <style>
                #card-container {
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    justify-content: center;
                }
                #card-content {
                    background-color: #f0f0f0;
                    border: 1px solid #ccc;
                    padding: 20px;
                    border-radius: 8px;
                    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                    text-align: center;
                    font-size: 2.0em;
                }
                #card-controls {
                    height: 20vh;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    gap: 20px;

                }
            </style>
            <div id="card-container">
                <div id="card-content">
                    <p>Loading...</p>
                </div>
                <div id="card-controls">
                    <button id="next-button">Next</button>
                    <button id="show-meaning">Show Meaning</button>
                </div>
            </div>
        `;

        this.nextButton = this.shadowRoot.querySelector('#next-button');
        this.showMeaningButton = this.shadowRoot.querySelector('#show-meaning');
        this.shownCharacters = new Set();
    }

    async connectedCallback() {
        const random = await fetch(`/api/v1/${this.getAttribute('type')}/random`);
        if (!random.ok) {
            console.error('Failed to fetch random card:', random.statusText);
            return;
        }
        const card = await random.json();
        this.shadowRoot.querySelector('#card-content').innerHTML = `
            <div class="card">
                <h2>${card.character}</h2>
                <p id="meaning" style="display: none">${card.meaning}</p>
            </div>
        `;
        this.shownCharacters.add(card.character);

        // events
        this.nextButton.addEventListener('click', async () => {
            this.showMeaningButton.textContent = 'Show Meaning';
            this.nextButton.disabled = true;
            const alreadyShownCharacters = Array.from(this.shownCharacters).join(',');

            const next = await fetch(`/api/v1/${this.getAttribute('type')}/random?exclude=${alreadyShownCharacters}`);
            if (!next.ok) {
                console.error('Failed to fetch next card:', next.statusText);
                this.disabled = false;
                return;
            }
            if (next.status === 204) {
                this.shadowRoot.querySelector('#card-content').innerHTML = `
                    <div class="card">
                        <h2>No more characters available</h2>
                    </div>
                `;
                this.nextButton.disabled = true;
                return;
            }

            const nextCard = await next.json();
            this.shadowRoot.querySelector('#card-content').innerHTML = `
                <div class="card">
                    <h2>${nextCard.character}</h2>
                    <p id="meaning" style="display: none">${nextCard.meaning}</p>
                </div>
            `;
            this.shownCharacters.add(nextCard.character);
            this.nextButton.disabled = false;
        });

        this.showMeaningButton.addEventListener('click', () => {
            const meaningElement = this.shadowRoot.querySelector('#meaning');
            if (meaningElement.style.display === 'none') {
                meaningElement.style.display = 'block';
                this.showMeaningButton.textContent = 'Hide Meaning';
            } else {
                meaningElement.style.display = 'none';
                this.showMeaningButton.textContent = 'Show Meaning';
            }
        });
    }

    disconnectedCallback() {
        this.nextButton.removeEventListener('click', this.handleNextButtonClick);
        this.showMeaningButton.removeEventListener('click', this.handleShowMeaningButtonClick);
    }
}

customElements.define('card-container', CardContainer);