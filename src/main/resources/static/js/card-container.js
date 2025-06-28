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

                }
            </style>
            <div id="card-container">
                <div id="card-content">
                    <p>Loading...</p>
                </div>
                <div id="card-controls">
                    <button id="next-button">Next</button>
                </div>
            </div>
        `;

        this.button = this.shadowRoot.querySelector('#next-button');
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
                <p>${card.meaning}</p>
            </div>
        `;

        this.button.addEventListener('click', async () => {
            const next = await fetch(`/api/v1/${this.getAttribute('type')}/random`);
            if (!next.ok) {
                console.error('Failed to fetch next card:', next.statusText);
                return;
            }
            const nextCard = await next.json();
            this.shadowRoot.querySelector('#card-content').innerHTML = `
                <div class="card">
                    <h2>${nextCard.character}</h2>
                    <p>${nextCard.meaning}</p>
                </div>
            `;
        });
    }
}

customElements.define('card-container', CardContainer);