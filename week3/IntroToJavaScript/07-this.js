/*
We use the this keyword to refer to different things in different places

* When used alone, this refers to the global window object
* When used inside a function it also refers to the global window object
* When used inside event handlers it refers to the HTML element that is 
the recipient of the event
*/

// var theWindowObject = this;
var bigFoot = "Bigfoot lives!"

// console.log(bigFoot)
// console.log(theWindowObject.bigFoot) 
console.log(this.bigFoot) // <--- this is referring to the bigFoot var

function func() {
   var bigFoot = "Bigfoot is definitely a myth"

    console.log(bigFoot) // this is referring to the variable declared in fucntional scope
    console.log(this.bigFoot) // this is reffering to the variable declared in global scope
}
func()

console.log(this)

// In HTML
/*

<button onclick"this.style.display='none'">Some Label</button>

When you do this, it refers to the actual object - in this case the button 

*/
