import React, from "react";

const Track = ({track: {name, album, preview_url}, audio}) => {
    const playAudio = () => {
        if (preview_url === null || !audio.paused && audio.src === preview_url) {
            audio.pause();
            return;
        }
        audio.src = preview_url;
        audio.paused ? audio.play() : () => {
            audio.pause();
            audio.play();
        }
    }
    return (
        <div onClick={playAudio} style={{display: "inline-block", padding:10, margin:10}}>
            <img
                src={album?.images[0].url}
                alt={'artist-image'}
                style={{
                    width: 400,
                    height: 400,
                    objectFit: "cover"
            }}
            />
            <p>{name}</p>
        </div>
    );
}
function Tracks(props) {
    const audio = new Audio();
    const {tracks} = props;
    return (
        <div>
            {tracks.map(track => <Track key={track.id} track={track} audio={audio}/>)}
        </div>
    );
}



export default Tracks