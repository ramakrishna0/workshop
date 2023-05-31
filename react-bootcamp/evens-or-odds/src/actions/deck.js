import {DECK} from './types/types';

const NEW_DECK_URL = 'https://deckofcardsapi.com/api/deck/new/shuffle';

export const fetchDeckSuccess = ({remaining, deck_id}) => {
    return {
        type: DECK.FETCH_SUCCESS,
        remaining,
        deck_id
    }
}

export const fetchDeckError = message => {
    return {
        type: DECK.FETCH_ERROR,
        message
    }
}

export const fetchNewDeck = () => dispatch => {
    return fetch(NEW_DECK_URL)
        .then(response => {
            if (response.status !== 200) {
                throw new Error('unsuccessful request to deckofcardsapi.com');
            }
           return response.json();
        })
        .then(json => dispatch(fetchDeckSuccess(json)))
        .catch(error => dispatch(fetchDeckError(error.message)));
};