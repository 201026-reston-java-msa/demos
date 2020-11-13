/*
JavaScript is the programming language of HTML and the web.
It's used to achieve dynamic behavior on a webpage.
You can place any number of <script> tags within an html document,
they will execute sequentially as encountered.

They can be placed in body or head and linked externally.

JavaScript is to hamster as Java is to ham.
*/

// JS is a DYNAMICALLY TYPED LANGUAGE! -- Java is Strongly/Statically typed 

/*
  There are several datatypes in JS - know these!
  number
  string
  boolean
  null*
  undefined
  object
  function*
*/

// A JS function:
function logType(input) {
    console.log('input is ' + input + ' and is of type: ' + typeof(input));
} 

// In JS, what you'd refer to as an INTEGER is a NUMBER
logType(5);

// We can declare variables in JS in a few ways
// the oldest and simplest way is with the var keyword:
var a = 'hello';


// the arrow notation was introduced in ES6 ECMA Script in 2015
// along with const and let 
const turnRed = () => {
    console.log("this is now red")
} 

/*
Node.js is an open-source, cross-platform, back-end, JavaScript 
runtime environment that executes JavaScript code outside a web browser.
*/