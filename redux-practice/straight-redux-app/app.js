// import {express} from 'express';
const express = require('express');


let app = express();
app.use(express.static('static'));
app.listen(3000,'localhost', () => {
    console.log('blah');
})
// app.get('/',(req,res) => {
//     res.sendFile('/home/mike/Documents/WIN/github/WIN-class-assignments/redux-practice/straight-redux-app/index.html');
// })