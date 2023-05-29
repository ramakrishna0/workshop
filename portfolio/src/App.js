import React, {Component} from 'react';
import Projects from "./Projects";
import Socials from "./Socials";
import profile from './assests/profile.png';


class App extends Component {
    state = {displayBio: false};
    /*constructor(props) {
        super(props);
        this.state = {displayBio: false};
        this.toggleDisplaybio = this.toggleDisplaybio.bind(this);   //or declare state as a class variable
    }*/
    toggleDisplaybio = () =>{
        this.setState({displayBio : !this.state.displayBio});
    }


    render() {
        return (
            <div>
                <img src={profile}  alt='profile' className='profile'/>
                <h1>Hello!</h1>
                <p>My name is Rama Krishna. I'm a software developer.</p>
                <p>I'm always looking to work on meaningful projects.</p>
                {
                    this.state.displayBio ? (
                        <div>
                            <p>I live in Seattle, and code everyday.</p>
                            <p>My favorite language is JavaScript, and I think React.js is awesome</p>
                            <p>Besides coding, I also love running.</p>
                            <button onClick={this.toggleDisplaybio}>Show less</button>
                        </div>
                    ) : (
                        <div>
                            <button onClick={this.toggleDisplaybio}>Read more</button>
                        </div>
                    )
                }
                <hr />
                <Projects />
                <hr />
                <Socials />
            </div>
        );
    }
}

export default App;

