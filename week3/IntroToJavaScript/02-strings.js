a = 'hello' // by default if we don't declare with var, it is var 
console.log(a)

let b = 'somethingelse'
// The let keyword allows this variable to be modified

b = "somethingdifferent"
console.log(b)

b = "somethingelseentirelydifferent" // this variable is not HOISTED --> we'll talk about this later

// ES6 (ECMA Script 6) was introduced in 2015 and introduced let and const
const unchangeableWord = "Never" // we cannot modify this variable

let templateLiteral = ``
// template literals allows for String Interpolation
// String Interpolation allows use to insert placeholders for variables
// and the template literal will use the value of the variable when used

templateLiteral = `
You can declare mulitple lines as well
as use it for string interpolation`

var person = 'Bob'
var age = 30

templateLiteral = `Five plus five is equal to ${5+5}`
templateLiteral = `Today I met ${person} and he is ${age} years old`
console.log(templateLiteral)

var sentance = 'Hello, my name is ' + person
console.log(sentance)

var food = 'Hamburger'
let aNewSentance = `I would like 1 ${food}, please`
food = "Salad" // if we change the value of a specific variable AFTER the declaration of template literal, it will not update
console.log(aNewSentance)
// TL's only ise the values at creation

console.log(aNewSentance)

