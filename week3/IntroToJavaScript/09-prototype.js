var car = {
    wheels: 3,
    engine: 5,
    getStats: function() {
        return this.wheels + ' ' + this.engine;
    }
}

// When 'this' keyword is used within an object's function, it
// refers to the owner of the function.
// In this case it refers to the car object.

var mustang = {
    wheels: 8,
    engine: 12,
    color: 'hot-red with yellow stripes'
}

/*
All objects have a hidden property called prototype.  If you attempt to access a function 
or property on an object in which it doesn't exist, JS will loks for it in the prototype
You can access the prototype in the following way:

A prototype is a mechanism by which JS objects can inherit features from one another
*/

// The below example demonstrated prototypal inheritance
mustang.__proto__= car;
console.log(mustang.getStats()); // now mustang can inherit car proerties and functions
console.log(mustang.color);
console.log(car.getStats());
