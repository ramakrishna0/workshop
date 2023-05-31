import {SET_GAME_STARTED, SET_INSTRUCTIONS_EXPANDED} from "./types/types";

export const setGameStarted = value => {
    return {
        type: SET_GAME_STARTED,
        gameStarted: value
    };
};
export const setInstructionsExpanded = value => {
    return {
        type: SET_INSTRUCTIONS_EXPANDED,
        instructionsExpanded: value
    };
};


