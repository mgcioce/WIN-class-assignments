import React from 'react';
import Picture from './Picture'
import logo from '../logo.svg'
import UserInput from './UserInput';
import Slider from './Slider';
import Reset from './Reset';



class Spinny extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            image: logo,
            slider: 2,
            database: props.db,
        }
        this.state.database.ref('image_url/').set(this.state.image);
        this.state.database.ref('slider_speed').set(this.state.slider);
    }
    
    render() {

        return (
            
            <div id='App'>
                <Picture image={this.state.image} style={{animationDuration: this.state.slider + 's'}}/>
                <UserInput submitURL={this.submitURL.bind(this)}/> 
                <Slider speed={this.state.slider} inputFunction={this.sliderChange.bind(this)}/>
                <Reset reset={this.resetState.bind(this)}/>               
            </div>
        )        
    }

    submitURL(event) {
        event.preventDefault();
        let ui = event.target.elements.url.value;
        this.state.database.ref('image_url').set(ui).then( (success) => {
            this.state.database.ref('image_url').on('value', (snapshot) => {
                this.setState({
                    image: snapshot.val(),
                })
            })
        })
        this.setState({
            image: ui,
        })
    }

    sliderChange(event) {
        event.preventDefault();
        let sliderSpeed = event.target.value;
        this.state.database.ref('slider_speed').set(sliderSpeed).then( (success) => {
            this.state.database.ref('slider_speed').on('value', (snapshot) => {
                this.setState({
                    slider: snapshot.val(),
                });    
            });
        }, (failure) =>{
            console.log(failure);
        })
    }

    resetState(event) {
        this.setState({
            image: logo,
            slider: 2,
        })
    }
}


export default Spinny;