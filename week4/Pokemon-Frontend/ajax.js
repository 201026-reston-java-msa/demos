'use strict'

let xhr = XMLHttpRequest();

xhr.open('GET', 'https://pokeapi.co/api/v2/pokemon/130');

xhr.send();

setTimeout(() => {
    console.log(xhr.status)

    console.log(xhr.response);

    document.querySelector('h1').innerText = JSON.parse(xhr.response) 
}