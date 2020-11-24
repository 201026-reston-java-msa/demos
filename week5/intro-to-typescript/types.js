var count = 5;
// TypeScript is strictly types! We cannot reassign a variable
// that we've already defined as a number type
// count = 'a'; // This will make the coimpiler angry...
var a;
var b;
var c;
var d; // The any type in TypeScript is used to represent ANY JS value.
var f = [1, true, 'apple', false];
var ColorRed = 0;
var ColorBlue = 1;
var ColorGreen = 2;
// An easier way to do the above would be to create an enum
// Enums allow us to define named constants
// Enums can be string or numeric values
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Blue"] = 1] = "Blue";
    Color[Color["Green"] = 2] = "Green";
})(Color || (Color = {}));
var backgroundColor = Color.Red;
