import React from "react";
import {connect} from "react-redux";
import {setGameStarted, setInstructionsExpanded} from "../actions/settings";

const Instructions = props => {
    const {instructionsExpanded} = props;
    const flipInstructions = () => {
        props.setInstructionsExpanded(!instructionsExpanded);
    };
    return (
        instructionsExpanded ? (
            <div>
                <h3>Instructions</h3>
                <p>Welcome to evens or odds. The game goes like this</p>
                <p>The deck is shuffled. Then choose: will the next card be even or odd?</p>
                <p>(Face cards don't count)</p>
                <br/>
                <button onClick={flipInstructions}>Show less</button>
            </div>
        ) : (
            <div>
                <h3>Instructions</h3>
                <p>Welcome to evens or odds. The game goes like this...</p>
                <button onClick={flipInstructions}>Read more</button>
            </div>
        )

    );
};

/*export default connect(
    state => ({instructionsExpanded: state.instructionsExpanded}),
    (dispatch) => ({flipInstructions: (value) => dispatch(setInstructionsExpanded(value))})
)(Instructions);*/
export default connect(
    state => ({instructionsExpanded: state.settings.instructionsExpanded}),
    {setInstructionsExpanded}
)(Instructions);


