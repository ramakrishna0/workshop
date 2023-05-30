/*let fooArray = [1, 2, 'foo', 'bar', true, false, { foo: 1, bar:2}];
fooArray = ['ffo', 'bar', 'goo'];

console.log(fooArray);

const runLoop = (param1, param2) => {
    for (let i = 0; i < 10; i++) {
        if (i === 5) {
            console.log('i is 5!!!');
        }
        console.log(i);
    }
    console.log(param1, param2);
    param2();
};

const logBam = () => console.log('bam');        //call back function

runLoop('bat', logBam);*/


class Animal {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
    speak() {
        console.log('I am', this.name, 'and I am', this.age, 'years old');
    }
}


class Lion extends Animal{
    constructor(name, age, hairColor, speed) {
        super(name, age)
        this.hairColor = hairColor;
        this.speed = speed;
    }
    logName() {
        console.log('ROAR! I have', this.hairColor, 'fur, and I can run', this.speed, 'miles per hour');
    }
}

const goldenLion = new Lion('Mufasa', 24, 'golden', 40);
const redLion = new Lion('Scar', 22, 'red', 30);

console.log(goldenLion);
console.log(redLion);

goldenLion.speak();
redLion.speak();

goldenLion.logName();
redLion.logName();