import {SET_GAME_STARTED, SET_INSTRUCTIONS_EXPANDED} from "../actions/types/types";

const DEFAULT_SETTINGS = {
    gameStarted: false,
    instructionsExpanded: false
};
const rootReducer = (state = DEFAULT_SETTINGS, action) => {
    switch (action.type) {
        case SET_GAME_STARTED:
            return {
                ...state,
                gameStarted: action.gameStarted
            };

        case SET_INSTRUCTIONS_EXPANDED:
            return {
                ...state,
                gameStarted: state.gameStarted
            };
        default:
            return state;
    }
};

export default rootReducer;
