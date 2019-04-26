import React from 'react';
import {NavLink} from 'react-router-dom';

class Navigation extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div id='Navigation'>Navigation Station: 
                <NavLink to='/contact'>Contact </NavLink>
                <NavLink to='/about'>About </NavLink>
                <NavLink to='/'>Home </NavLink>
            </div>
        )
    }
}

export default Navigation;