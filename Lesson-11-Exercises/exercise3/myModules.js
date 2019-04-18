function dopeAssFunction() {
    console.log("This function is the bees knees");
}

function wackAssFunction() {
    console.log("This function is wack");
}

// module.exports

fetch(`https://jsonplaceholder.typicode.com/posts/1`,{method:"GET"})
    .then( (success) => {
        return success.text();
    }, (failure) => {
        console.log(failure);
    } )
    .then( (success) => {
        console.log(success);
    }, (failure) => {
        console.log(failure);
    });