### My notes from today

    //let students = ['a','b','c'];
    //let [x,...z] = students;
    //console.log(x,...z);

    // let completedHomework = () => {
    //     return ['a','b','c'];
    // }
    // let [x,y,z] = completedHomework();
    // console.log(x,y,z);

    function returnBothThings() {
        let myObject = {
            me: 'Mike',
            notMe: 'Bruice',
        }
    
        function thisFunk(newNotMe = 'somebody') {
            return newNotMe;
        }
        return [myObject,thisFunk];
    }

next

    class Person {
        constructor(name,job) {
            this.name = name;
            this.job = job;
        }

        getName() {
            return this.name;
        }

        getJob() {
            return this.job;
        }
    }

    class SuperHero extends Person{
        constructor(name,heroName,superPower) {
            super(name,'super hero');
            this.heroName = heroName;
            this.superPower = superPower;
        }

        getHeroName() {
            return this.heroName;
        }

        getSuperPower() {
            return this.superPower;
        }

        getSecretIdentity() {
            return `${this.name} is ${this.heroName}`;
        }
    }

    console.log(new SuperHero);

next 

    function boo() {
        let x = usingVar;
    
        var usingVar = "I'm using var";
    
        console.log(x);
    }

    var b = a;
    var a = 6;

    boo();

next 

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

