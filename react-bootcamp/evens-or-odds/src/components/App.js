import React from 'react';
import {connect} from "react-redux";
import {setGameStarted} from '../actions/settings'
import Instructions from "./Intructions";
import {fetchNewDeck} from "../actions/deck";
import fetchStates from "../reducers/fetchStates";
import DrawCard from "./DrawCard";


function App(props) {
    const startGame = () => {
        props.setGameStarted(true);
        props.fetchNewDeck();
    }
    const stopGame = () => {
        props.setGameStarted(false);
    };
    console.log('props from App', props);

    if (props.fetchState === fetchStates.error) {
        return (
            <div>
                <p>Please try reloading the app. An error occurred.</p>
                <p>{props.message}</p>
            </div>
        );
    }
    return (
        <div>
            <h2>♥ ♠ Evens or Odds ♦ ♣</h2>
            {/*♠♥♦♣♤♡♢♧*/}
            {
                props.gameStarted ? (
                    <div>
                        <h3>The game is on!</h3>
                        <br/>
                        <button onClick={stopGame}>Cancel Game</button>
                    </div>
                ) : (
                    <div>
                        <h3>A new game awaits</h3>
                        <br />
                        <button onClick={startGame}>Start Game</button>
                    </div>
                )
            }
            <hr />
            <Instructions />
            <hr />
            <DrawCard />
        </div>
    );
}

// const mapDispatchToProps = (dispatch) => {
//     return {
//         setGameStarted: value => dispatch(setGameStarted(value)),
//         fetchNewDeck: () => fetchNewDeck(dispatch)
//     };
// }

const mapStateToProps = state => {
    // const {fetchState, message} = state.deck;
    // const {gameStarted} = state.settings;
    const {
        deck: {fetchState, message},
        settings: {gameStarted}
    } = state;
    return {
        gameStarted,
        fetchState,
        message
    };
}

const componentComponent = connect(mapStateToProps,
    {setGameStarted, fetchNewDeck});

export default componentComponent(App);

