// ## Exercise 2: Prototypes
// - The constructor takes `startX` and `startY` parameters
// - Particle will have a property of `x` that defaults to the value of the argument `startX`
// - Particle will have a property of `y`that defaults to the value of the argument `startY`
// - Particle will have a property of `velocity` that defaults to {x: 0, y: 0}
// - Create an empty array named `particles`
// - Write loop to create 100 particles
// 	- x values will be assigned from 0-99
// 	- y will be random from 0 to 500 (`Math.random()*500`)

// - Create a `time` variable and set it to 0
// - Create a `gravity` variable and set it to 0.5
// - Extend the particle class from earlier with a prototype object.
// - Create a prototype object that contains:
// 	- A property of `getVelocity()` that returns the value (time * gravity)
// 	- A property of `move()` 
// 		- `move()` should add the value from `getVelocity()` to the existing `y` position 
// 		- If and when `y >= 500` `move()` should instead do the following: `console.log('bottom')`  
// - use your existing array and for loop to create a particles array 
// - Use `setInterval` at 100ms to
// 	- increment the global `time` variable by 1
// 	- `console.log` all the particle's `x` values
// 	- also `return` an array with all of the `y` values that are less than 500 (`y < 500`)
// 	- take the array with `y` values  
// 		- call the `move()` function on EACH item

class Particle {
    constructor(time,xPos,yPos,velocity,acceleration) {
        this.time = time;
        this.xPos = xPos;
        this.yPos = yPos;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }
    calculateXPos() {

    }
    calculateYPos() {
        let aTSquared = this.acceleration.yAccellInit * this.time.getTime() * this.time.getTime();
        let vT = this.velocity.yVelInit * this.time.getTime();
        if (this.yPos <= 0) {
            return "On the ground";
        } else {
            this.yPos = this.yPos + vT + aTSquared;
            if (this.yPos < 0) {
                this.yPos = 0;
            }
            return this.yPos;
        }
        
    }
    setTime() {

    }
}

class Velocity {
    constructor(valueOfT,yInit, yVelFunc) {
        this.time = valueOfT;
        this.yVelInit = yInit;
        this.yVelCurr = yInit;
        this.yVelFunc = yVelFunc;
    }
    calculateVelocity() {
        this.yVelCurr = this.yVelInit + this.yVelFunc(this.time.getTime()) * this.time.getTime();
    }
}

class Acceleration {
    constructor(valueOfT,yInit,yAccellFunc) {
        this.time = valueOfT;
        this.yAccellInit = yInit;
        this.yAccellCurr = yInit;
        this.yAccellFunc = yAccellFunc;
    }
    calculateAcceleration() {
        this.yAccellCurr = this.yAccell + this.yAccellFunc(this.time.getTime())
    }
}

class Time {
    constructor(t) {
        this.value = t;
    }
    getTime() {
        return this.value;
    }
    setTime(t) {
        this.value = t;
    }
}

let time = new Time(0);
let particles = [];
let yAccellFunc = function(t){
    return -0.5;
}
let yVelFunc = function(t) {
    return -0.5 * t;
}

for (let i = 0; i < 100; i++) {
    particles.push(new Particle(time,i,Math.random()*500,new Velocity(time,0,yVelFunc),new Acceleration(time,-0.5,yAccellFunc)));
}

console.log(particles);
let inFreefall = []
let id = setInterval( () => {
    time.value++;
    inFreefall = particles.filter( (particle) => {
        particle.calculateYPos();
        return particle.yPos > 0;
    })
    console.log(inFreefall.length);
},1000)
setTimeout( () => {
    clearInterval(id);
    console.log(particles);
},1000*10);







