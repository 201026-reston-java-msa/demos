/*
What are closures?
They allow for:
1.) allows for an inner function to access an enclosing function's variables.
2.) allows for an innter function to preserve (closure) an enclosing function's scope chain when executing the function.
*/

// Example:
var x = function cake() {
    var flour = true;
    var cornMill = false;
    var cupsSugar = 1;

    function bake() {
        var heat = 350;
        console.log("Baking the cake at " + heat + "!");
        console.log("flour: " + flour);
        console.log("cornMill: " + cornMill);
        console.log("Cups of Sugar: " + cupsSugar);

        heat++;
        flour = !flour;
        cornMill = !cornMill; 
        cupsSugar++;

        /*
        The bake() function has the following scope chains:
        - 1. It has access to its own scope
        - 2. it has access to cake()'s scope
        - 3. It has access to the outer scope
        */
    }

    return bake;
}

x = x() // This will invoke cake - by invoking cake, we are really calling bake()

// techincally we are executing the inner function

for (let i=0; i<5; i++) {
    x()
}


/*
The bake function has access to the variables that are scoped to the cake() function. Cake() encloses bake().  Closure allows indirect access to the cake function (the enclosing function) by calling the enclosed function. 

The particular access tot
*/
