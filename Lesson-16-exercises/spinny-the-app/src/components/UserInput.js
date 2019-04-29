import React from 'react';

class UserInput extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div id='userInput'>
                <form onSubmit={this.props.submitURL}>
                    <input type='text' name='url' placeholder='enter the url of a picture here'></input>
                    <button type='submit' >Change the Picture!</button>
                </form>
            </div>
        )
    }
}

export default UserInput;