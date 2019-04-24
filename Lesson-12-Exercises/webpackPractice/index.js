//function definitions
function scaleRGB(colorsArray) {
    colorsArray = colorsArray.map( (color) => {
        Object.keys(color).map( (key) => {
            if (typeof color[key] == 'number')
                color[key] = color[key]/255;
        })
        return color;
    })
    return colorsArray;
}


function buildInputData(array) {
    
    let splitArray = [];
    splitArray[0] = array.map( (colorObject) => {
        let returnObject = {};
        Object.keys(colorObject).forEach( (key) => {
            if (typeof colorObject[key] == 'number') {
                returnObject[key] = colorObject[key];
            }
        })
        return returnObject;
    })
    
    splitArray[1] = array.map( (colorObject) => {
        return colorObject.text;
    });

    let returnArray = []
    for (let i = 0; i < splitArray[0].length;i++) {
        let returnObject = {};
        returnObject.input = splitArray[0][i];
        returnObject.output = {};
        returnObject.output[splitArray[1][i]] = 1;
        returnArray.push(returnObject);
    }

    return returnArray;
}

function hexToRGB(hex) {
    hex = hex.slice(1);
    let returnObject = {r: null, g: null, b: null};
    let keys = ['r','g','b'];
    for (let i = 0; i < keys.length; i++) {
        let nextColor = hex[2*i]+hex[2*i+1];
        nextColor = parseInt(nextColor,16);
        returnObject[keys[i]] = nextColor; 
        console.log(nextColor);
    }
    return returnObject;
}

function changeText(probabilityObject,textArea) {
    if (probabilityObject['white'] > probabilityObject['black']){
        textArea.style.setProperty('color','white');
    } else {
        textArea.style.setProperty('color','black');
    }
}
//network training
const network = new brain.NeuralNetwork();

colors = [
    {r: 0, g: 0, b: 0, text:'white'},// black => white text
    {r: 0, g: 0, b:255, text:'white'}, //blue => white text
    {r: 0, g:255, b: 0, text: 'black'}, //green => black text
    {r: 0, g:255, b:255, text: 'black'}, //aqua blue => black text
    {r: 255, g: 0, b: 0, text: 'white'},//red => white text
    {r: 255, g:0, b:255, text: 'black'}, //pink => black text
    {r: 255, g:255, b:0, text: 'black'}, //yellow => black text
    {r: 255, g:255, b:255, text: 'black'},//white => black text
    {r: 255, g:128, b:0, text: 'black'},//orange => black text
    {r: 128, g:128, b:128, text: 'black'},//grey => black text
    {r: 128, g:0, b:255, text: 'white'}//purple => white text
]
colors = scaleRGB(colors);
let inputData = buildInputData(colors);

//console.log(inputData);

network.train(inputData);

let textArea = document.querySelector('div#textArea');
let colorInput = document.querySelector('input[type="color"]');
colorInput.addEventListener('change', (event) => {
    let colorValue = colorInput.value;
    textArea.style.setProperty('background-color',colorValue);
    let rgb = hexToRGB(colorValue);
    rgb = scaleRGB([rgb]);
    console.log(rgb);
    let probabilites = network.run(rgb);
    console.log(probabilites);
    changeText(probabilites,textArea);
})
// console.log(network.run([{r: 0.5, g: 0.5, b: 0.5}]));


