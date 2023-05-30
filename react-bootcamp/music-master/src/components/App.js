import React, {useEffect, useState} from 'react';
import Artist from "./Artist";
import Tracks from "./Tracks";
import Search from "./Search";
function App() {
    const [artist, setArtist] = useState({});
    const [tracks, setTracks] = useState([]);
    const SPOTIFY_API_ADDRESS = 'https://spotify-api-wrapper.appspot.com/';
    const searchArtist = artistQuery => {
        fetch(`${SPOTIFY_API_ADDRESS}/artist/${artistQuery}`)
            .then(response => response.json())
            .then(({artists: {items, total}}) => total > 0 ? setArtist(items[0]) : undefined)
            .catch(error => alert(error.message));
    }
    useEffect(() => {
        if (Object.keys(artist).length === 0) return;
        fetch(`${SPOTIFY_API_ADDRESS}/artist/${artist.id}/top-tracks`)
            .then(response => response.json())
            .then(({tracks}) => setTracks(tracks))
            .catch(error => alert(error.message));
    }, [artist]);
    useEffect(() => {
        searchArtist('bruno');
    }, []);
    return (
        <div>
            <h2>Music Master</h2>
            <Search searchArtist={searchArtist}/>
            <Artist artist={artist}/>
            <Tracks tracks={tracks}/>
        </div>
    );
}
export default App;

