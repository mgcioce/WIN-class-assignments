// 1. Install the 'request-promise' package
// 2. Install the 'moment' package
// 4. Examine the directory structures and effects on package.json
// 5. Delete node_modules folder and run npm install again
// 6. Create an index.js file and update package.json so that `npm start` will run it
// 7. Require the 'request' and 'moment' modules in your application.
// 8. Use 'request-promise' to get data from http://jsonplaceholder.typicode.com/posts/1. Log the response
// 9. Use 'moment' to output a timestamp for when response arrives using the format `h:mm:ss a`.
// 10. Have your application fetch data every 3 seconds.
const Moment = require('moment');
const Request = require('request');
console.log('I exist');
let options = {
    uri: 'http://jsonplaceholder.typicode.com/posts/1',
    headers: {
        'User-Agent': 'Request-Promise'
    },
}
rp(options).then( (success) => {
    console.log(success);
}, (failure) => {
    console.log(failure);
})

