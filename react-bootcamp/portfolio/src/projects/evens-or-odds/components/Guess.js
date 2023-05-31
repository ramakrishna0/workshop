import React from "react";
import {connect} from "react-redux";
import {setGuessOdd, setGuessEven} from "../actions/guess";
import gameStateReducer from "../reducers/gameState";


const Guess = ({guess, setGuessEven, setGuessOdd}) => {

    return (
        <div>
            <h3>Will it be even or odd?</h3>
            <div>
                <button
                    onClick={setGuessEven}
                    style={guess === 'even' ? {backgroundColor: 'lime'} : null}
                >Even</button>
                {' '}
                <button
                    onClick={setGuessOdd}
                    style={guess === 'odd' ? {backgroundColor: 'lime'} : null}
                >Odd</button>
            </div>
        </div>
    )

}


export default connect(
    ({gameState:{guess}}) => ({guess}),
    {setGuessEven, setGuessOdd}
)(Guess);