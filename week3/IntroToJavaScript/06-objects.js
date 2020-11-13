/*
JavaScript allows to define Object literals - this is an obj
that cosists of key-pairs and is surrounded by curly brackets
*/

let personLiteral = 
{
    name: 'Wilson',
    hairColor: 'brown',
    favoriteFood: 'tacos'
}

console.log(personLiteral);
console.log(personLiteral.favoriteFood)
console.log(personLiteral["favoriteFood"]) // accessing the value with sqaure brackets around the key as a String

let key = "favoriteFood"
console.log(personLiteral[key])
// bracket notation is useful when we don't remember the name of the key when accessing the code

personLiteral.age = 35;
console.log(personLiteral)

//----- another way to create objects ----------//

function Person(name, hairColor, favoriteFood) {
    this.name = name; // semicolon not necessary
    this.hairColor = hairColor
    this.favoriteFood
    this.sayHello = function () {
        console.log(`Hello, my name is ${this.name}`)
    }
}

let larry = new Person('Larry', 'red', 'sushi')
larry.sayHello();
console.log(larry)

// Classes were introduced in ES6
class PersonClass {
    constructor(name, hairColor, favoriteFood) {
        this.name = name
        this.hairColor = hairColor
        this.favoriteFood = favoriteFood
    }

    sayHello() {
        console.log(`Hello from ${this.name}`)
    }
}

console.log(new PersonClass('Harry', 'hot pink', 'bbq'));

const person2 = new PersonClass('Sally', 'green', 'green beans')
console.log(person2.favoriteFood)