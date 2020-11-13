/*
    JavaScript has a way of coercing all different values into booleans
    in different ways - this is called truthy/falsey
*/

/* Falsey Values are: 
- false
- 0
- '' or " " (empty strings)
- null
- undefined
- NaN
*/

// !! (double bang) will return an objects truthy value 
// !! returns true i
function checkTruthy(input) {
    console.log(`
    input = ${input} and is of type ${typeof(input)}
    It has a truthy value of ${!!input}
    `)
}

checkTruthy(true)
checkTruthy('This is a String')
checkTruthy(0) // falsey
const x = 0
checkTruthy(x)
const y = '0' 
checkTruthy(y) // truthy

var username = ''

// Say you have a program in which you're retireving a parameter
// and then storing it to the value of username

if(true) {
    console.log("truthy!")
}
username = "Bob"

// if(username) {
//     console.log("usernmae is truthy")
// } else {
//     console.log("username is falsy")
// }

// Ternary Operators -- only works with 3 parts
username ? console.log(`username is truthy`) : console.log(`username is falsey`)

console.log("This is my double bang test")
console.log(!!0)
console.log(!!'my string')