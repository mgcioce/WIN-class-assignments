// Write a `Particle` constructor function

// - The constructor takes `startX` and `startY` parameters
// - Particle will have a property of `x` that defaults to the value of the argument `startX`
// - Particle will have a property of `y`that defaults to the value of the argument `startY`
// - Particle will have a property of `velocity` that defaults to {x: 0, y: 0}
// - Create an empty array named `particles`
// - Write loop to create 100 particles
// 	- x values will be assigned from 0-99
// 	- y will be random from 0 to 500 (`Math.random()*500`)

class Particle {
    constructor(startx,starty) {
        this.x = startx;
        this.y = starty;
        this.velocity = new Velocity(0,0);
    }
}

class Velocity{
    constructor(x,y) {
        this.x = x;
        this.y = y;
    }
}

let particles = [];
for (let i = 0; i < 100; i++) {
    particles[i] = new Particle(i,Math.floor(Math.random() * 501));
}
console.log(particles);

