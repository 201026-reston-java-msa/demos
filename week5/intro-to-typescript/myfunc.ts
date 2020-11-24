function doSomething() {
    // let is a way to restrcit access to variables
    // (this was introduced in ES6 (EcmaScript 6 - 2015 release of JS))
    for (let i=0; i<5; i++) {
        console.log(i)
    }
    // The typeScript compiler is warning me about the reachability of my code (declared iwth the let variable)
    console.log('Finally the number is ' + i)
}

doSomething()