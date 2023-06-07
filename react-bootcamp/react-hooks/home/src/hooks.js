import {useEffect, useState} from "react";

export const useFetch = (endpoint, initialValue) => {
    const [result, setResult] = useState(initialValue);
    useEffect(() => {
        fetch(endpoint)
            .then(response => response.json())
            .then(json => setResult(json));
    }, []);
    return result;
};