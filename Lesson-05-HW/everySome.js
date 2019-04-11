function funk1(validUsers) {
    return (testArray) => {
        return testArray.every( (element) => {
            return validUsers.some( (el) => {
                return el.id == element.id;
            })
        })
    }
}

module.exports = funk1;