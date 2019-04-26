import React from 'react';

class Contact extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div id='Contact'>
                If you contact me, I will reply
                <form>
                    <textarea placeholder='hit me up dog'></textarea>
                </form>
            </div>
        )
    }

}

export default Contact;