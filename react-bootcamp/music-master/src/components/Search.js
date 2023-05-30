import React, {useEffect, useState} from "react";

function Search({searchArtist}) {
    const [artistQuery, setArtistQuery] = useState('');
    const updateArtistQuery = ({target: {value}}) => {          //event.target.value
        setArtistQuery(value);
    }
    const search = () => {
        searchArtist(artistQuery);
    }
    const handleKeyPress = ({key}) => {
        if (key === 'Enter') {
            searchArtist(artistQuery);
        }
    }
    return (
        <div>
            <input
                onChange={updateArtistQuery}
                onKeyUp={handleKeyPress}
                placeholder={'Search for an Artist'}/>
            <button onClick={search}>Search</button>
        </div>
    );
}
export default Search;