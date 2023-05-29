import React from "react";
import PROJECTS from "../data/project";

// function Project () {
const Project = (props) => {
    const{ title, image, description, link } = props.project;
    return (
        <div style={{ display: 'inline-block', width: 300, margin:10 }}>
            <h3>{title}</h3>
            <img src={image} alt={link} style={{ width: 200, height: 120 }}/>
            <p>{description}</p>
            <a href={link}>{link}</a>
        </div>
    );
}

const Projects = () => (
    <div>
        <h1>Highlighted Projects</h1>
        <div>
            { PROJECTS.map(PROJECT => ( <Project key={PROJECT.id} project={PROJECT}/> )) }
        </div>
    </div>
);

export default Projects;