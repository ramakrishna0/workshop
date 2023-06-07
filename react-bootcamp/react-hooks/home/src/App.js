import {useState} from "react";
import Joke from "./Joke";
import Stories from "./Stories";
import Tasks from "./Tasks";

function App() {

    const [userQuery, setUserQuery] = useState('');

    const searchQuery = () => {
        window.open(`https://google.com/search?q=${userQuery}`, '_blank');
    }

    const handleKeyDown = event => {
        if (event.key === 'Enter') {
            searchQuery();
        }
    }
    const updateUserQuery = event => {
        setUserQuery(event.target.value);
        console.log('userQuery', userQuery);
    }

    return (
    <div className="App">
        <h1>Hello Me!</h1>
        <input
            value={userQuery}
            onChange={updateUserQuery}
            onKeyDown={handleKeyDown}
        />
        <button onClick={searchQuery}>Search</button>
        {userQuery}
        <hr />
        <Joke />
        <hr />
        <Tasks />
        <hr />
        <Stories />
    </div>
    );
}

export default App;
