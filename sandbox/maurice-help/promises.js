var isMomHappy = true;

var willIGetNewPhone = new Promise(
    function (resolve, reject) {
        if (isMomHappy) {
            var phone = {
                brand: 'iPhone',
                color: 'Rose'
            };
            resolve(phone);
        } else {
            var reason = 'mom is not happy';
            reject(reason);
        }
    }
);

// var askMom = function () {
//     willIGetNewPhone
//     .then(function (fulfilled) {
//         console.log(fulfilled);
//     })
//     .catch(function (error) {
//         console.log(error)
//     })
// }

// function success(s) {
//     console.log(s);
// }

// function error(f) {
//     console.log(f);
// }

// function askMom(promise) {
//     promise.then( (success) => {
//         console.log(success);
//     }, (error) => {
//         console.log(error);
//     });
// }

let anotherPromise = willIGetNewPhone.then( (success) => {
    let newPromise = new Promise( (resolve,reject) => {
        resolve('yay i did it');
    });
    return newPromise;
}, (failure) => {
    console.log(failure);
})

anotherPromise.then( (success) => {
    console.log(success);
})

// a = [1,2,3]

// a.forEach(success);