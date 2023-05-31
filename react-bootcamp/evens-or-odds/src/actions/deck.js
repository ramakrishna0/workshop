import {DECK, DECK_DRAW} from './types/types';

const DECK_URL = 'https://deckofcardsapi.com/api/deck';

export const fetchDeckSuccess = ({remaining, deck_id}) => {
    return {
        type: DECK.FETCH_SUCCESS,
        remaining,
        deck_id
    }
};

export const fetchDeckError = message => {
    return {
        type: DECK.FETCH_ERROR,
        message
    }
};

export const fetchNewDeck = () => dispatch => {
    return fetch(`${DECK_URL}/new/shuffle`)
        .then(response => {
            if (response.status !== 200) {
                throw new Error('unsuccessful request to deckofcardsapi.com');
            }
            return response.json();
        })
        .then(json => dispatch(fetchDeckSuccess(json)))
        .catch(error => dispatch(fetchDeckError(error.message)));
};

export const fetchDeckDrawNewCardSuccess =({cards, remaining}) => {
    return {
        type: DECK_DRAW.FETCH_SUCCESS,
        cards,
        remaining

    };
}

export const fetchDrawCard = deck_id => dispatch => {
    return fetch(`${DECK_URL}/${deck_id}/draw`)
        .then(response => {
            if (response.status !== 200) {
                throw new Error('unsuccessful request to deckofcardsapi.com');
            }
            return response.json();
        }).then(json => dispatch(fetchDeckDrawNewCardSuccess(json)))
        .catch(error => dispatch(fetchDeckError(error.message)));

};