const teacher = {
    name: 'Jim',
    speak: function() {
        let boundFunction = function () {
            console.log('later my name is ' + this.name);
        }
        boundFunction = boundFunction.bind(this);
        setTimeout(boundFunction,1000);
    }
}

teacher.speak();