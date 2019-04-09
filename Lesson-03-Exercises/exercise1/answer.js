const bill = Math.random() * 100;

function gratuity(a) {
    return a * 0.2;
}

function totalWithGrat(b,gratFunk) {
    return b + gratFunk(bill);
}

let fuckface = "Mike";

console.log(gratuity("fuckface"));
// console.log(bill);
// console.log(gratuity(bill));
// console.log(`Your total with gratuity is: ${totalWithGrat(bill,gratuity).toFixed(2)}`);




