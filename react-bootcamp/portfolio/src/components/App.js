import React, {useState} from 'react';
import Projects from "./Projects";
import SocialProfiles from "./SocialProfiles";
import profile from '../assests/profile.png';
import Title from "./Title";
import Header from "./Header";


function App() {
    const [displayBio, setDisplayBio] = useState(false);
    const toggleBio = () => {
        setDisplayBio(!displayBio);
    }
    return (
        <div>
            <img src={profile}  alt='profile' className='profile'/>
            <h1>Hello!</h1>
            <p>My name is Rama Krishna.</p>
            <Title />
            <p>I'm always looking to work on meaningful projects.</p>
            {
                displayBio ? (
                    <div>
                        <p>I live in Seattle, and code everyday.</p>
                        <p>My favorite language is JavaScript, and I think React.js is awesome</p>
                        <p>Besides coding, I also love running.</p>
                        <button onClick={toggleBio}>Show less</button>
                    </div>
                ) : (
                    <div>
                        <button onClick={toggleBio}>Read more</button>
                    </div>
                )
            }
            <hr />
            <Projects />
            <hr />
            <SocialProfiles />
        </div>
    );
}

export default App;

