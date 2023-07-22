import {useEffect, useState} from "react";
import MATRIX_FRAMES from "./data/matrix";

export const useFetch = (endpoint, initialValue) => {
    const [result, setResult] = useState(initialValue);
    useEffect(() => {
        fetch(endpoint)
            .then(response => response.json())
            .then(json => setResult(json));
    }, []);
    return result;
};

export const useDynamicTransition = ({delay, increment, length}) => {
    const [index, setIndex] = useState(0);
    useEffect(() => {
        const interval = setInterval(() => {
            setIndex(prevIndex => (prevIndex + increment) % length);
        }, delay);

        return () => {
            clearInterval(interval);
        };
    }, [delay, increment]);

    return index;
};