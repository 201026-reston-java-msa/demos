'use strict' 
// Strict mode enforces strict variable declaration

/*
Otherwise an variable that was not previously declared will default to var (outside of Strict Mode)
*/
//name = 'Harry' // this isn't possible with strict mode
var name = 'Harry' // now it works since we're in strict mode
console.log(name)

/*
Two Main scopes in JS:
1. Global - variables declared here are accessible from anywhere, publicly, outermost scope
    - * varibales declared outside of the function scope with var will be declared with global scope
2. Functional - variables declared within a funciont's block
*/

function funScope() {
    var a = 'hello'

    if (true) {
        var b = 'goodbye';
    }

    console.log(b)
}
//console.log(a) // this won't work outside of function scope
funScope()

// Lexical/Block Scoping was introduced in 2015 by ES 6 (Ecma Script 6)

function blockScope() {
    let a = 'hello'

    if (true) {
        let b = 'goodbye'
        console.log(b) // This will only run within the statement due to the LET keyword which is enforcing a Lexical/Block Scope
    }   
}

blockScope()

// The const keyword works similarly to the final keyword in Java
// You cannot modify the value after you declare

function constFun() {
    const a = 'temp';
   // a = 'notTemp' you cannot reassign constant variable!
    console.log(a)
}


constFun();