class BackButton extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({ mode: 'open' });
        this.shadowRoot.innerHTML = `
            <style>
                button {
                    display: block;
                    margin: 8px 2px;
                    padding: 5px 10px;
                    font-size: 16px;
                    cursor: pointer;
                    background-color: #DDDDDD;
                    border: none;
                    border-radius: 7px;
                }
                button:hover {
                    background-color: #CCCCCC;
            </style>
            <button>뒤로가기</button>
        `;
    }

    connectedCallback() {
        this.shadowRoot.querySelector('button').addEventListener('click', () => {
            window.history.back();
        });
    }

    disconnectedCallback() {
        this.shadowRoot.querySelector('button').removeEventListener('click', this.goBack);
    }
}

customElements.define('back-button', BackButton);
