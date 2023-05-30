import React, {useState} from "react";

const Track = ({track: {name, album, preview_url}, setter, playing}) => {
    const playAudio = () => {
        if(preview_url === null) return;
        if (audio.src === preview_url) {
            audio.paused ? play() : pause();
            return;
        }
        audio.src = preview_url;
        if(audio.paused) {
            play();
        } else {
            pause();
            play();
        }
    };
    const play = () => {
        audio.play();
        setter(preview_url);
    };
    const pause = () => {
        audio.pause();
        setter('');
    };
    const trackIcon = () => {
        if(!preview_url) {
            return <span>N/A</span>
        }
        if(playing === preview_url && !audio.paused)
            return <span>| |</span>
        return <span>&#9654;</span>;
    };
    return (
        <div onClick={playAudio} className={'track'}>
            <img
                src={album?.images[0].url}
                alt={'artist-image'}
                className={'track-image'}
            />
            <p className={'track-text'}>{name}</p>
            <p className={'track-icon'}>{trackIcon()}</p>
        </div>
    );
}
function Tracks({tracks}) {
    const [playing, setPlaying] = useState('');
    audio.onended = () => {
        setPlaying('');
    };

    return (
        <div>
            {tracks.map(track => <Track key={track.id} track={track} setter={setPlaying} playing={playing}/>)}
        </div>
    );
}
const audio = new Audio();

export default Tracks