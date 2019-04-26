function asyncOperation() {
    return new Promise( (resolve,reject) => {
        setTimeout( () => {
            resolve('this is async');
        }, 2000);
    });
}

async function asyncCalls() {
    let resolveValue = await asyncOperation();
    console.log(resolveValue);
}

asyncCalls();