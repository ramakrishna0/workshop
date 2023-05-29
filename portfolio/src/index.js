import React from 'react';
import ReactDOM from 'react-dom/client';
import {BrowserRouter, Routes, Route} from "react-router-dom";
import {createBrowserHistory} from "history";
import App from "./components/App";
import Jokes from "./components/Jokes"
import './index.css';
import Header from "./components/Header";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <BrowserRouter history={createBrowserHistory()}>
        <Routes>
            {/*<Route path={'/'} element={<App />}></Route>*/}
            <Route path='/' element={<Header Component={App}></Header>} />
            <Route path='/jokes' element={<Header Component={Jokes}></Header>} />
        </Routes>
    </BrowserRouter>
);






















/*new Promise((resolve, reject) => {
    // return reject(new Error('No Beers Found'));
    setTimeout(() => {
        console.log('Beers');
        resolve('Beers, Beets Battlestar Galactica');
    }, 2000);
}).then(quote => console.log(quote))
    .catch((error => console.log('error', error)));*/
