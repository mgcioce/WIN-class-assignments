let a = {
    state: 'hello',
}

function pure(obj) {
    let copy = JSON.parse(JSON.stringify(obj));
    copy.state = 'goodbye';
    console.log(obj,copy);
    return copy;
}

a = pure(a);
console.log(a);