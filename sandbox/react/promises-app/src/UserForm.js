import React from 'react';
import Axios from 'axios';

class UserForm extends React.Component {
    constructor(props) {
        super(props);
        this.props = props;
    }

    render() {
        return (
            <div id='UserForm'>
                <form onSubmit={this.getUser}>
                    <input type='text' name='username'></input>
                    <button type='submit'>Submit</button>
                </form>
            </div>
        )
    }

    // getUser(event) {
    //     event.preventDefault();
    //     const user = event.target.elements.username.value;
    //     Axios.get(`https://jsonplaceholder.typicode.com/users?username=${user}`).then( (success) => {
    //         console.log(success);
    //     }, (failure) => {
    //         console.log(failure);
    //     })
    // }

    getUser(event) {
        event.preventDefault();
        const user = event.target.elements.username.value;
        
    }
}

export default UserForm;