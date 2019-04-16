function myPromise() {
    
}

//myPromise();
function fibonacci(iteration) {
    if (iteration > 2) {
        return fibonacci(iteration - 1) + fibonacci (iteration - 2);
    } else {
        return 1;
    }
}

setTimeout( () => {
    console.log("This is a message");
},10);

console.log(fibonacci(43))
