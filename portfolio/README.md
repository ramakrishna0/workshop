For componentDidMount
```
useEffect(() => {
// Your code here
}, []);
```
For componentDidUpdate
```
useEffect(() => {
// Your code here
}, [yourDependency]);
```
For componentWillUnmount
```
useEffect(() => {
// componentWillUnmount
return () => {
// Your code here
}
}, [yourDependency]);
```
Declare a new state variable, which we'll call "count"  
`const [count, setCount] = useState(0);`

Update state variable "count"  
`setCount(count + 1);`



# Title.js
* work in progress.
```
import React, {useEffect, useState} from "react";

const TITLES = ['a software engineer', 'a musician', 'a nerd'];

function Title() {
    const [titleIndex, setTitleIndex] = useState(0);
    let titleInterval = 0;

    // componentDidMount
    useEffect(() => {
        console.log('mounted');
        animateTitles();
    }, []);

    // componentWillUnmount
    useEffect(() => {
        return () => {
            console.log('unmounted');
            clearInterval(titleInterval);
        }
    }, [titleIndex]);

    const animateTitles = () => {
        // this.setState({titleIndex: (this.state.titleIndex + 1) % TITLES.length});
        titleInterval = setInterval(() => {
            console.log('title index updated')
            setTitleIndex( (titleIndex+1) % TITLES.length )
        }, 4000);
    }

    return (
        <p>I am {TITLES[titleIndex]}.</p>
    );
}

export default Title;

```
