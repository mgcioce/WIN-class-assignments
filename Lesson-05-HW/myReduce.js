//create a reduce function that accepts an array, a function , and an initial value, and implement it
//using recursion
// init will hold the sum, function will be used to calculate
//and return the next sum, and array holds the values to add
function myReduce(array, func, init) {
    if (arguments[3] == 0) {
        return func(init,array[arguments[3]],arguments[3],array);
    } else {
        return myReduce(array,func,func(init,array[arguments[3]],arguments[3],array),arguments[3]-1);
    }     
}

let a = [1,2,3,4,5];

console.log(myReduce(a,(a,c,i,arr) => {
    return a + c;
},0,a.length-1));