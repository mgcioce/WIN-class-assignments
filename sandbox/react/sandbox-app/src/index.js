import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Clock from './components/Clock.js';
import RouterPractice from './components/RouterExample';

const element = <Clock />

//ReactDOM.render(element,document.querySelector('div#root'));
ReactDOM.render(<RouterPractice />,document.querySelector('div#root'));
