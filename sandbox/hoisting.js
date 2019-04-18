function boo() {
    let x = usingVar;
    
    var usingVar = "I'm using var";
    
    console.log(x);
}

var b = a;
var a = 6;

boo();
