function doSomething() {
    // EcmaScript 5 (also called ES5 is read by every single browser on the web)
    for (var i = 0; i < 5; i++) {
        console.log(i);
    }
    console.log('Finally the number is ' + i);
}
doSomething();
