class CardContainer extends HTMLElement {
    constructor() {
        super();
        const type = this.getAttribute('type');

        if (type !== 'hiragana' && type !== 'katakana') {
            throw new Error('Invalid type attribute. Expected "hiragana" or "katakana".');
        }

        this.innerHTML = `
            <div id="card-container">
                <div id="card-content">
                    <p>Loading...</p>
                </div>
                <div id="card-controls">
                    <div>
                        <button id="correct-button" class="control-button blue">Correct</button>
                        <button id="failed-button" class="control-button red">Failed</button>
                    </div>
                    <div>
                        <button id="show-meaning" class="control-button gray">Show Meaning</button>
                    </div>
                </div>
            </div>
        `;

        this.correctButton = this.querySelector('#correct-button');
        this.failedButton = this.querySelector('#failed-button');
        this.showMeaningButton = this.querySelector('#show-meaning');
        this.excludedCharacters = new Set();
    }

    async connectedCallback() {
        const random = await fetch(`/api/v1/${this.getAttribute('type')}/random`);
        if (!random.ok) {
            console.error('Failed to fetch random card:', random.statusText);
            return;
        }
        const card = await random.json();

        this.currentCharacter = card.character;
        this.querySelector('#card-content').innerHTML = `
            <div class="card">
                <h2>${card.character}</h2>
                <p id="meaning" style="visibility: hidden">${card.meaning}</p>
            </div>
        `;

        // events
        this.correctButton.addEventListener('click', async () => await this.clickNext(true));
        this.failedButton.addEventListener('click', async () => await this.clickNext(false));

        this.showMeaningButton.addEventListener('click', () => {
            const meaningElement = this.querySelector('#meaning');
            if (meaningElement.style.visibility === 'hidden') {
                meaningElement.style.visibility = 'visible';
                this.showMeaningButton.textContent = 'Hide Meaning';
            } else {
                meaningElement.style.visibility = 'hidden';
                this.showMeaningButton.textContent = 'Show Meaning';
            }
        });
    }

    disconnectedCallback() {
        this.correctButton.removeEventListener('click', this.handleNextButtonClick);
        this.showMeaningButton.removeEventListener('click', this.handleShowMeaningButtonClick);
    }

    /**
     * 
     * @param {boolean} exclude 
     */
    async clickNext(exclude) {
        if (exclude) {
            this.excludedCharacters.add(this.currentCharacter);
        }
        this.showMeaningButton.textContent = 'Show Meaning';
        this.correctButton.disabled = true;
        this.failedButton.disabled = true;
        const alreadyShownCharacters = Array.from(this.excludedCharacters).join(',');
        const next = await fetch(`/api/v1/${this.getAttribute('type')}/random?exclude=${alreadyShownCharacters}`);
        if (!next.ok) {
            console.error('Failed to fetch next card:', next.statusText);
            this.disabled = false;
            return;
        }
        if (next.status === 204) {
            this.querySelector('#card-content').innerHTML = `
                    <div class="card">
                        <h2>No more characters available</h2>
                    </div>
                `;
            this.correctButton.disabled = true;
            return;
        }
        const nextCard = await next.json();
        this.currentCharacter = nextCard.character;
        this.querySelector('#card-content').innerHTML = `
                <div class="card">
                    <h2>${nextCard.character}</h2>
                    <p id="meaning" style="visibility: hidden">${nextCard.meaning}</p>
                </div>
            `;

        this.correctButton.disabled = false;
        this.failedButton.disabled = false;
    }
}

customElements.define('card-container', CardContainer);