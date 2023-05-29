import React, {Component} from "react";
import PROJECTS from "./data/project";

class Project extends Component {

    render() {
        const{ title, image, description, link } = this.props.project;
        return (
            <div style={{ display: 'inline-block', width: 300, margin:10 }}>
                <h3>{title}</h3>
                <img src={image} alt={link} style={{ width: 200, height: 120 }}/>
                <p>{description}</p>
                <a href={link}>{link}</a>
            </div>
        );
    }
}


class Projects extends Component {
    render() {
        return (
            <div>
                <h1>Highlighted Projects</h1>
                <div>
                    {
                        PROJECTS.map(PROJECT => {
                            return (
                                <Project key={PROJECT.id} project={PROJECT}/>
                            );
                        })
                    }
                </div>
            </div>
        );
    }
}

export default Projects;