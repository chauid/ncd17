const searchValue = { words: '' };

class SearchInput extends HTMLElement {
    constructor() {
        super();
        this.innerHTML = `
            <style>
                #search {
                    position: fixed;
                    width: 100%;
                    padding: 10px;
                    font-family: 'Pretendard Variable', sans-serif;
                    font-size: 16px;
                    border: 1px solid #d4d4d4;
                }

                .autocomplete-items {
                    position: fixed;
                    border: 1px solid #d4d4d4;
                    border-bottom: none;
                    border-top: none;
                    z-index: 99;
                }
                .autocomplete-item {
                    padding: 5px;
                    min-width: 200px;
                    cursor: pointer;
                    background-color: #fff;
                    border-bottom: 1px solid #d4d4d4;
                }
                .autocomplete-item:hover {
                    background-color: #e9e9e9;
                }
            </style>
            <input type="text" id="search" placeholder="날짜, 이름 검색..." autocomplete="off">
        `;

        this.input = this.querySelector('#search');

        this.input.addEventListener('input', this.onInput.bind(this));
    }

    onInput() {
        searchValue.words = this.input.value;
        const url = new URL(window.location);
        url.searchParams.set('search', searchValue.words);
        window.history.pushState({}, '', url);
    }
}

customElements.define('search-input', SearchInput);

export const value = searchValue;
