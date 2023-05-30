import React, from "react";

const Track = ({track: {name, album, preview_url}, audio}) => {
    const playAudio = () => {
        if(preview_url === null) return;
        if (audio.src === preview_url) {
            audio.paused ? audio.play() : audio.pause();
            return;
        }
        audio.src = preview_url;
        audio.paused ? audio.play() : () => {
            audio.pause();
            audio.play();
        }
    }
    return (
        <div onClick={playAudio} className={'track'}>
            <img
                src={album?.images[0].url}
                alt={'artist-image'}
                className={'track-image'}
            />
            <p className={'track-text'}>{name}</p>
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