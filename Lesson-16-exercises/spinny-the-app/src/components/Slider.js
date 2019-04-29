import React from 'react';

class Slider extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div id='slider'>
                <input type='range' name='slider' defaultValue='2' min='0.005' max='10' step='0.005' onChange={this.props.inputFunction}></input>
            </div>
        )
    }
}

export default Slider;