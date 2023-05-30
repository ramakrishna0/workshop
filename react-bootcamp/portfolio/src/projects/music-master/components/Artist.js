import React from "react";


const Artist = ({artist}) => {
    console.log(artist);
    if(Object.keys(artist).length === 0) return;
    const {images, name, followers, genres} = artist;
    return (
        <div>
            <div>
                <h3>{name}</h3>
                <p>{followers.total}</p>
                <p>{genres.join(', ')}</p>
            </div>
            <div>
                <img
                    src={images.length>0 ? images[0].url : null}
                    alt='artist profile'
                    style={{
                        width: 200,
                        height: 200,
                        borderRadius: 100,
                        objectFit: "cover"
                    }}
                />
            </div>
        </div>
    );
};

export default Artist;