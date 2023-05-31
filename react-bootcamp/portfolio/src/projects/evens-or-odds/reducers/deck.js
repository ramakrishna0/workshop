import {DECK,DECK_DRAW} from "../actions/types/types";
import fetchStates from './fetchStates'

const DEFAULT_DECK = {
    deck_id: '',
    remaining: 0,
    fetchState: '',
    message: '',
    cards: []
};
const deckReducer = (state = DEFAULT_DECK, action) => {
    let remaining, deck_id, cards;
    switch (action.type) {
        case DECK.FETCH_SUCCESS:
            ({remaining, deck_id} = action);
            return {
                ...state,
                remaining,
                deck_id,
                fetchState: fetchStates.success
            }
        case DECK.FETCH_ERROR || DECK_DRAW.FETCH_ERROR:
            return {
                ...state,
                message: action.message,
                fetchState: fetchStates.error
            }
        case DECK_DRAW.FETCH_SUCCESS:
            ({remaining, cards} = action)
            return {
                ...state,
                cards,
                remaining
            }
        default:
            return state;
    }
};

export default deckReducer;
