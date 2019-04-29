import React from 'react';
import './Picture.css';

class Picture extends React.Component {
    constructor(props) {
        super(props);
        // this.state = {
        //     image: props.image
        // }
    }
    
    render() {
        return (
            <img className='spinny-picture' src={this.props.image} style={this.props.style}></img>
        )
    }
}

export default Picture;