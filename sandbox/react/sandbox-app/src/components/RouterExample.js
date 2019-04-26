import React from 'react';
import {BrowserRouter,Route,Switch,Link} from 'react-router-dom';
import '../index.css';
import About from './About';
import Home from './Home';
import Contact from './Contact';
import Error from './Error';
import Navigation from './Navigation';

// const NewRoute = () => {
//     return (
//         <div>
//             New Route
//         </div>
//     );
// }

class RouterPractice extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <BrowserRouter>
                <Navigation>
                    
                </Navigation>
                <Switch>
                    <Route path="/about" component={About} exact>
                        {/* <a href="/About" exact>About</a> */}
                    </Route>
                    <Route path='/' component={Home} exact></Route>
                    <Route path='/contact' component={Contact} exact></Route>
                    <Route component={Error}></Route>
                </Switch>
                
            </BrowserRouter>
        )
    }
}





export default RouterPractice;

