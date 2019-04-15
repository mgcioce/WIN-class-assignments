//create a reduce function that accepts an array, a function , and an initial value, and implement it
//using recursion
// init will hold the sum, function will be used to calculate
//and return the next sum, and array holds the values to add
function myReduce(array, func, init) {
    return (function innerReduce(array,func,init,index) {
        if (index == 0) {
            return func(init,array[index],index,array); 
        } else {
            return innerReduce(array,func,func(init,array[index-1],index-1,array),index-1);
        }
    })(array,func,init,0);    
}

let a = [1,2,3,4,5];

console.log(myReduce(a,(a,c,i,arr) => {
    return a + c;
},0));