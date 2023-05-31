import React from "react";
import {connect} from "react-redux";

const correctGuessesRecordKey = 'CORRECT_GUESSES_RECORD_foo123';
const checkRecord = correctGuesses => {
    const record = Number(localStorage.getItem(correctGuessesRecordKey));
    if (correctGuesses > record) {
        localStorage.setItem(correctGuessesRecordKey, correctGuesses);
        return {record: correctGuesses, isNewRecord: true};
    }
    return {record, isNewRecord: false};
};
const GameState = ({correctGuesses, remaining}) => {
    const guessText = correctGuesses === 1 ? 'guess' : 'guesses'
    const {record, isNewRecord} = checkRecord(correctGuesses);
    const recordLabel = isNewRecord ? '🎉 New Record' : 'Record';
    return (
        <div>
            <p>{remaining} cards remaining</p>
            <p>{correctGuesses} correct {guessText}</p>
            <h3>{recordLabel}: {record}</h3>
        </div>
    )
};

export default connect(
    ({
         gameState: {correctGuesses},
         deck: {remaining}
     }) => ({correctGuesses, remaining}),
    {}
)(GameState);