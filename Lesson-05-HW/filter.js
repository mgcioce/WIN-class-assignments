function getShortMessages(messages) {
    let array = messages.map( (object) => {
        return object.message;
    });
    return array.filter( (message) => {
        return message.length < 50;
    });
}

module.exports = getShortMessages;