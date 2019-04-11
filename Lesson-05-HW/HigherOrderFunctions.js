function funkRunner(myFunk,n) {
    for (let i = 0; i < n; i++) {
        myFunk();
    }
}

module.exports = funkRunner;