//Using the API at http://jsonplaceholder.typicode.com/ create an app with the following functionality. 
//Use Promises for everything.

// 1. **Login page** - Display a login form asking user for a username.
// 	- On Submit, look up the username entered by the user.
// 	- If no user is found, display a detailed error message.
// 	- If the user is found, store user object and render User's homepage
// 2. **User's homepage** displays:
// 	- User's name
// 	- User's post titles
// 	- User's albums
// 3. **Post View** - Clicking on a post renders a post view, including:
// 	- Post title
// 	- Post text
// 	- A list of comments on the post
// 	- A back link to the user homepage
// 4. **Album View** - Clicking on an album renders the album page, including:
// 	- Thumbnails of all the photos and the photo's title
// 	- A search box that filters the photos by title as the user types
// 	- A back link to the user homepage

function createHTMLStrings(array) {
    let returnString = '';
    array.forEach( (element) => {
        HTMLStrings = Object.keys(element).map( (key) => {
            if (typeof element[key] == 'object' && !Array.isArray(element[key])) {
                 return `<li>${createHTMLStrings([element[key]])}</li>`;
            } else {
                return `<li>${key}: ${element[key]}</li>`;
            }
        })
        HTMLStrings = `<ul>${HTMLStrings.join('')}</ul>`;
        returnString 
    });
    return returnString;
}

new Promise( (resolve,reject) => {
    $.get('http://jsonplaceholder.typicode.com/users', (data,status,xhr) => {
        if (data.length > 0) {
            resolve(data);
        } else {
            reject('we got a problem here');
        }
    }).then( (success) => {
        let HTMLStrings = createHTMLStrings([success[0]]);
        console.log(HTMLStrings);
    }, (failure) => {
        console.log(failure);
    })
})






// let submitButton = document.querySelector('input[value="Submit"]');
// submitButton.addEventListener('click',(event) => {
//     let username = document.querySelector('input[placeholder="username"]').value;
//     let myPromise = new Promise((resolve,reject) => {
//         $.get(`http://jsonplaceholder.typicode.com/users?username=${username}`, (data,status,xhr) => {
//             if (data.length > 0) {
//                 resolve(data);
//             } else {
//                 reject('you done messed up A A Ron');
//             }
//         });
//     });
//     myPromise.then((data) => {
//         document.querySelector('div.login').setAttribute('display', 'none');
//         let userPage = document.createElement('div');
//         userPage.className = 'user-page';
//         document.querySelector('body').append(userPage);
//         let id = null;
//         let HTMLElements = Object.keys(data).map( (key) => {
//             if (key == 'id'){
//                 id = data[key];
//             }
//             return `<li>${key}: ${data[key]}</li>`;
//         });
//         let ul = document.createElement('ul');
//         ul.innerHTML = HTMLElements.join('');
//         document.querySelector('div[class="user-page"]').append(ul);
//         return new Promise((resolve,reject) => {
//             //do another get request for the post data for the user.
//             $.get(`http://jsonplaceholder.typicode.com/posts?userId=${id}`, (data,status,xhr) => {
//                 if (data.length > 0){
//                     resolve(data);
//                 } else {
//                     reject('That fucked up');
//                 }
//             });
//         });
//     },(err) => {
//         let errorText = document.createElement('p');
//         errorText.textContent = err + "\nNo user found: please try again";
//         document.querySelector('div.login').append(errorText);
//     }).then( (success) => {
//         console.log(success);
//         createHTMLStrings(success);
//     }, (failure) => {
//         console.log(failure);
//     }); 
// });

