import React, {useEffect, useState} from "react";
import Header from "./Header";

// const Joke = props => {
// const { setup, punchline } = props.joke;
const Joke = ({ joke: {setup, punchline} }) => {
    return (
        <p style={{ margin: 20 }}>{setup} <em>{punchline}</em></p>
    );
}

function Jokes() {
    const [joke, setJoke] = useState({});
    const [jokes, setJokes] = useState([]);
    const RANDOM_JOKE_URL = 'https://official-joke-api.appspot.com/random_joke';
    const RANDOM_TEN_JOKES_URL = 'https://official-joke-api.appspot.com/random_ten';

    useEffect(() => {
        fetch(RANDOM_JOKE_URL)
            .then(response => response.json())
            .then(json => setJoke(json))
            .catch(error => alert(error.message));
    }, []);

    const fetchJokes = () => {
        fetch(RANDOM_TEN_JOKES_URL)
            .then(response => response.json())
            .then(json => setJokes(json))
            .catch(error => alert(error.message));
    }

    return (
        <div>
            <h2>Highlighted Joke</h2>
            <Joke joke={joke}/>
            <hr />
            <h2>Want ten new jokes ?</h2>
            <button onClick={fetchJokes}>Click Me!</button>
            <div>
                { jokes.map(joke => (<Joke key={joke.id} joke={joke} />) ) }
            </div>
        </div>
    )
}

export default Jokes;