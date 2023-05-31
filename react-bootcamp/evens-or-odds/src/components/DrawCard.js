import React from "react";
import {connect} from "react-redux";


const DrawCard = props => {
    return (
        <div>
            <button>Draw the next card!</button>
        </div>
    );
};

export default connect()(DrawCard);