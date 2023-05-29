import React from "react";
import SOCIAL_PROFILES from "../data/socialProfiles";

const SocialProfile = ({ socialProfile: { image, link } }) => {
    return (
        <span>
                <a href={link} >
                    <img src={image} alt='social-profile' style={{ width: 35, height: 35, margin:10 }}/>
                </a>
        </span>
    );
}

const SocialProfiles = () => (
    <div>
        <h1>Connect with me</h1>
        <div>
            { SOCIAL_PROFILES.map(PROFILE => (<SocialProfile key={PROFILE.id} socialProfile={PROFILE} />) ) }
        </div>
    </div>
);

export default SocialProfiles;