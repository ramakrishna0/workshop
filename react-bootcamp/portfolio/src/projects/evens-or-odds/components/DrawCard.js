import React from "react";
import {connect} from "react-redux";
import {fetchDrawCard} from "../actions/deck";


const DrawCard = (props) => {
    const fetchDrawCardWrapper = () => {
        props.fetchDrawCard(props.deck_id);
    };
    return (
        <div>
            <button onClick={fetchDrawCardWrapper}>Draw the next card!</button>
        </div>
    );
};

export default connect(
    ({deck: {deck_id, cards, remaining}}) => ({deck_id, cards, remaining}),
    {fetchDrawCard}
)(DrawCard)
//state => ({deck_id: state.deck.deck_id}