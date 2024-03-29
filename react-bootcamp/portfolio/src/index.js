import React from 'react';
import ReactDOM from 'react-dom/client';
import {BrowserRouter, Routes, Route} from "react-router-dom";
import {createBrowserHistory} from "history";
import App from "./components/App";
import Jokes from "./components/Jokes"
import './index.css';
import Header from "./components/Header";
import MusicMaster from './projects/music-master/'
import EvensOrOdds from "./projects/evens-or-odds";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <BrowserRouter history={createBrowserHistory()}>
        <Routes>
            {/*<Route path={'/'} element={<App />}></Route>*/}
            <Route path='/' element={<Header><App/></Header>}/>
            <Route path='/jokes' element={<Header><Jokes/></Header>}/>
            <Route path={'/music-master'} element={<Header><MusicMaster/></Header>}/>
            <Route path={'/evens-or-odds'} element={<Header><EvensOrOdds/></Header>}/>
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
