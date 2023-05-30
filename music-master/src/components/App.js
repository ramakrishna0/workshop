import React, {useEffect, useState} from 'react';
import Artist from "./Artist";
import Tracks from "./Tracks";
function App() {
    const [artistQuery, setArtistQuery] = useState('');
    const [artist, setArtist] = useState({});
    const [tracks, setTracks] = useState([]);
    const SPOTIFY_API_ADDRESS = 'https://spotify-api-wrapper.appspot.com/';

    const updateArtistQuery = ({target: {value}}) => {          //event.target.value
        setArtistQuery(value);
    }
    const handleKeyPress = ({key}) => {
        if (key === 'Enter') {
            searchArtist();
        }
    }
    const searchArtist = () => {
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
    console.log(tracks);
    return (
        <div>
            <h2>Music Master</h2>
            <input
                onChange={updateArtistQuery}
                onKeyUp={handleKeyPress}
                placeholder={'Search for an Artist'}/>
            <button onClick={searchArtist}>Search</button>
            <Artist artist={artist}/>
            <Tracks tracks={tracks}/>
        </div>
    );
}
export default App;

