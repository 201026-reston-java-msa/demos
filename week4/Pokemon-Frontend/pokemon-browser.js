`use strict`

let spriteElements = [
    document.getElementById('sprite1'),
    document.getElementById('sprite2'),
    document.getElementById('sprite3'),
    document.getElementById('sprite4'),
    document.getElementById('sprite5'),
    document.getElementById('sprite6')
]

let scrollLeft = document.querySelector('#scroll-left');
let scrollRight = document.querySelector('#scroll-right');
let pokemonInfo = document.querySelector('#pokemon-info')

let startingDisplayIndex = 1;

let baseUri = 'https://pokeapi.co/api/v2/pokemon'

async function getSprites() {
    let windowIndex =0;
    for(let element of spriteElements) { // this is a for...of statement
        let pokemonNumber = startingDisplayIndex + windowIndex;
        let response = await fetch(`${baseUri}/${pokemonNumber}`) // the feth() method (from the Fetch API an easy logical way to fetch resources aynchronously across a network)
        let pokemon = await response.json();
        element.src = pokemon.sprites.front_default;
        // let's create a method to populate INFO about the pokememon
        element.addEventListener('click', () => {
            createPokemonInfoPopulator(pokemon)();
        })
        windowIndex++
    }
}

scrollLeft.addEventListener('click', () => {
    if (startingDisplayIndex <=6) {
        startingDisplayIndex = 1;
    } else {
        startingDisplayIndex -= 6;
    }
    getSprites();
})

scrollRight.addEventListener('click', () => {
        startingDisplayIndex += 6;
    
    getSprites();
})

getSprites();

function createPokemonInfoPopulator(pokemon) {
    console.log('This will return an asynchornous anonumous function')
    return async ()=> {
        pokemonInfo.innerHTML = '';
        let infoList = document.createElement('ul');

        console.log('appendings infoList to pokemonInfo');
        pokemonInfo.appendChild(infoList);

        let locationResponse = await fetch(pokemon.location_area_encounters);
        let locationsArray = await locationResponse.json();

        for (let key in pokemon) {
            if(['id', 'name', 'height', 'weight'].includes(key)) {
                let listItem = document.createElement('li');
                listItem.innerText = `${key}: ${pokemon[key]}`;
                infoList.appendChild(listItem);
            }
        }
        let listItem = document.createElement('li');
        if(locationsArray.length===0) {
            listItem.innerText = 'location: Not found in Wild';
        } else {
            listItem.innerText = `location: ${locationsArray[0].location_area.name}`;
        }
        infoList.appendChild(listItem);
    }
}