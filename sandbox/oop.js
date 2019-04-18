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