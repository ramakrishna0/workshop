import React from 'react';
import {configureStore} from "@reduxjs/toolkit";
import {Provider} from "react-redux";
import App from "./components/App";
import rootReducer from "./reducers";
import './index.css';



const store = configureStore({
    reducer: rootReducer
});
store.subscribe(() => {
    console.log('subscribe store.getState()', store.getState())
});

const EvensOrOdds = () => {
    return (
        <Provider store={store}>
            <App/>
        </Provider>
    )
};

export default EvensOrOdds;
