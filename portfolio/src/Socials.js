import React, {Component} from "react";
import SOCIAL_PROFILES from "./data/socialProfiles";


class Social extends Component {
    render() {
        const{ image, link } = this.props.socialProfile;
        return (
            <span>
                <a href={link} >
                    <img src={image} alt='social-profile' style={{ width: 35, height: 35, margin:10 }}/>
                </a>
            </span>
        );
    }
}

class Socials extends Component {
    render() {
        return (
            <div>
                <h1>Connect with me</h1>
                <div>
                    {
                        SOCIAL_PROFILES.map(PROFILE => {
                            return (
                                <Social key={PROFILE.id} socialProfile={PROFILE}/>
                            );
                        })
                    }
                </div>
            </div>
        );
    }

}

export default Socials;