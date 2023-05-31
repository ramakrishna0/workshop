import React from 'react';
import ReactDOM from 'react-dom/client';
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

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <Provider store={store} >
        <App />
    </Provider>
);
