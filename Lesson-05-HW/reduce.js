function count(stringArray) {
    let returnObject = {};
    stringArray.reduce( (accumulator,currentString) => {
        if (typeof returnObject[currentString] == 'undefined') { //i.e. property of key currentString doesn't exist
            //add that string and set it's value to 1;
            returnObject[currentString] = 1;
        } else {
            returnObject[currentString]++;
        }
    },0);
    return returnObject;
}

module.exports = count;