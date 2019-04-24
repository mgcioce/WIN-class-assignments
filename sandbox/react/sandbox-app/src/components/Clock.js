import React from 'react';
import ReactDOM from 'react-dom';

class Clock extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            time: new Date(Date.now()),
        }
    }

    updateState() {
        this.setState( {
            time: new Date(Date.now()),
        })
    }

    render() {
        return <h1 id='time'>The current time is {this.state.time.toLocaleTimeString('en-US')}</h1>;
    }

    componentDidMount() {
        setInterval(this.updateState.bind(this), 1000);
    }



}

export default Clock;