import * as Redux from './node_modules/';

function create_NEW_VALUES_action(values) {
    return {
        type: 'NEW_VALUES',
        payload: values,
        error:false,
        meta: new Date(Date.now).toLocaleTimeString(),
    }
}

const initialState = {
    madlib: {
        person: null,
        place: null,
        workOfArt: null,
        year: null,
        food: null,
        adjective: null,
    }
}

function madlibReducer(currentState,action) {
    let nextState = JSON.parse(JSON.stringify(currentState));
    switch(action.type) {
        case 'NEW_VALUES': {
            nextState.madlib = action.payload;
            return nextState;
        }
        default: {
            return nextState;
        }
    }
}

let state = Redux.createStore(madlibReducer,initialState);
let unsubscribeListener = state.listener( () => {
    
})

let inputForm = document.querySelector('form');

function createMadlib(inputs) {
    return `There once was a person named ${inputs.person}. ${inputs.person} worked at ${inputs.place}
    until one day ${inputs.workOfArt}, the famous work created in ${inputs.year} was stolen. When 
    it was announced on the radio, a ${inputs.adjective} ${inputs.person} choked on their ${inputs.food}.
    A passerby saved their life, and they lived happily ever after. The End.`
}

inputForm.addEventListener('submit', (event) => {
    event.preventDefault();
    let p = document.querySelector('#madlib');
    let inputs = {};
    inputs.person = event.target.elements.person.value;
    inputs.place = event.target.elements.place.value;
    inputs.workOfArt = event.target.elements.workOfArt.value;
    inputs.year = event.target.elements.year.value;
    inputs.food = event.target.elements.food.value;
    inputs.adjective = event.target.elements.adjective.value;
    p.innerHTML = createMadlib(inputs);
})

