import React, {useState, useEffect} from "react";
import PICTURES from './data/pictures'

const SECONDS = 1000;
const MINIMUM_DELAY = 1000;
const MINIMUM_INCREMENT = 1;

function Gallery() {
    const [index, setIndex] = useState(0);
    const [delay, setDelay] = useState(3 * SECONDS);
    const [increment, setIncrement] = useState(1);

    useEffect(() => {
        const interval = setInterval(() => {
            setIndex(prevIndex => (prevIndex + increment) % PICTURES.length);
        }, delay);

        return () => {
            console.log('clear interval');
            clearInterval(interval);
        };
    }, [delay, increment]);

    const updateDelay = event => {
        const delay = Number(event.target.value) * SECONDS;
        setDelay(delay < MINIMUM_DELAY ? MINIMUM_DELAY : delay);
    }

    const updateIncrement = event => {
        const increment = Number(event.target.value);
        setIncrement(increment < MINIMUM_INCREMENT ? MINIMUM_INCREMENT : increment);
    };

    return (
        <div>
            <img
                src={PICTURES[index].image}
                alt={'gallery-image'}
            />
            <div className={'multiform'}>
                <div>
                    Gallery transition delay (seconds):
                    <input type={'number'} onChange={updateDelay}/>
                </div>
                <div>
                    Gallery Increment:
                    <input type={'number'} onChange={updateIncrement} />
                </div>
            </div>
        </div>
    )

}

export default Gallery;