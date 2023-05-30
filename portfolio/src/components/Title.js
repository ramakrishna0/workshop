import React, {Component} from "react";

const TITLES = ['a software engineer', 'a musician', 'a nerd'];

class Title extends Component {
    state = {titleIndex: 0};

    componentDidMount() {
        this.animateTitles();
    }
    animateTitles() {
        this.titleInterval = setInterval(() => {
            this.setState({titleIndex: (this.state.titleIndex + 1) % TITLES.length})
        }, 4000);
    }

    componentWillUnmount() {
        clearInterval(this.titleInterval);
    }

    render() {
        const title = TITLES[this.state.titleIndex];
        return (
        <p>I am {title}.</p>
        );
    }
}

export default Title;
