import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Clock from './components/Clock.js';

const element = <Clock />

ReactDOM.render(element,document.querySelector('div#root'));
