import React from 'react';

class Reset extends React.Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <button type='button' value='Reset' onClick={this.props.reset}>Reset</button>
        )
    }
}

export default Reset;