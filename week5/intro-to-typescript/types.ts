var count = 5;
// TypeScript is strictly types! We cannot reassign a variable
// that we've already defined as a number type
// count = 'a'; // This will make the coimpiler angry...

let a: number;
let b: boolean;
let c: string;
let d: any; // The any type in TypeScript is used to represent ANY JS value.
let f: any[] = [1, true, 'apple', false];

const ColorRed = 0;
const ColorBlue = 1;
const ColorGreen = 2;

// An easier way to do the above would be to create an enum
// Enums allow us to define named constants
// Enums can be string or numeric values
enum Color {Red, Blue, Green}
let backgroundColor = Color.Red
