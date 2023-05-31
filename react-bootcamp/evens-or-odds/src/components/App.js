import React from 'react';
import {connect} from "react-redux";
import {setGameStarted} from "../actions/settings";


function App(props) {
    const flipGameStarted = () => {
        props.dispatch(setGameStarted(!props.gameStarted));
    };
    console.log('props from App', props);
    return (
        <div>
            <h2>♥ ♠ Evens or Odds ♦ ♣</h2>
            {/*♠♥♦♣♤♡♢♧*/}
            {
                props.gameStarted ? (
                    <div>
                        <h3>The game is on!</h3>
                        <br/>
                        <button onClick={flipGameStarted}>Cancel Game</button>
                    </div>
                ) : (
                    <div>
                        <h3>A new game awaits</h3>
                        <br />
                        <button onClick={flipGameStarted}>Start Game</button>
                    </div>
                )
            }
        </div>
    );
}

const mapStateToProps = state => {
    return {
        gameStarted: state.gameStarted
    };
};

const componentComponent = connect(mapStateToProps);

export default componentComponent(App);

