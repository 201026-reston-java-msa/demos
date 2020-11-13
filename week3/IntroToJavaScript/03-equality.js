/*
JS has TWO equality operators: == and ===

They both perform equality in the same sense that it does in Java,
however == will be used in what is called 'Type Coercion' which means that JS
will attempt to convert types to match and then compare values

For example:    '5' == 5 is true (because == used type coercion)
            but '5' === 5 is false (because === is strict and checks types)
*/

function compare(first, second) {
    console.log(`
    first = ${first}, and is of type ${typeof(first)}
    second = ${second}, and is of type ${typeof(second)}
    first == second evaluates to ${first == second}
    first === second evaluates to ${first === second}`)
}

compare('5', 5)
compare(null, undefined) // null is an object and undefined is a type
var c = 5 / 'hello' // this returns NaN
compare(c, NaN) // NaN is never equal to itself
compare("true", true)
compare("false", false)