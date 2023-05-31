import {
    DECK,
} from "../actions/types/types";
import fetchStates from './fetchStates'

const DEFAULT_DECK = {
    deck_id: '',
    remaining: 0,
    fetchState: '',
    message: ''
};
const deckReducer = (state = DEFAULT_DECK, action) => {
    switch (action.type) {
        case DECK.FETCH_SUCCESS:
            const {remaining, deck_id} = action;
            console.log(remaining, deck_id);
            return {
                ...state,
                remaining,
                deck_id,
                fetchState: fetchStates.success
            }
        case DECK.FETCH_ERROR:
            return {
                ...state,
                message: action.message,
                fetchState: fetchStates.error
            }
        default:
            return state;
    }
};

export default deckReducer;
