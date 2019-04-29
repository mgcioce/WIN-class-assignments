import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Spinny from './components/Spinny';
import * as Firebase from 'firebase';

var config = {
    apiKey: "AIzaSyBIR3w8rVwIbx7-nz3GoxJtpluk8NUhTi0",
    authDomain: "spinny-the-app.firebaseapp.com",
    databaseURL: "https://spinny-the-app.firebaseio.com",
    projectId: "spinny-the-app",
    storageBucket: "spinny-the-app.appspot.com",
    messagingSenderId: "533597445282"
  };
Firebase.initializeApp(config);

let database = Firebase.database();

ReactDOM.render(<Spinny db={database}/>, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA



