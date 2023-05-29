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


class Lion {
    constructor(name, hairColor) {
        this.name = name;
        this.hairColor = hairColor;
    }

    logName() {
        console.log('Roar! I am', this.name);
    }

}

const goldenLion = new Lion('Mufasa', 'golden');
const redLion = new Lion('Scar', 'red');

console.log(goldenLion);
console.log(redLion);

goldenLion.logName();
redLion.logName();