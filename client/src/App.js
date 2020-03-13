import React from 'react';

import Navibar from './components/Navibar';
import './App.css';
import { BrowserRouter as Router, Route, } from "react-router-dom";
import Home from './contents/Home';
import Createquiz from './contents/Createquiz';
import About from './contents/About';
import Doquiz from './contents/Doquiz';

function App() {

    return (
        <Router>
            <div>
                <Navibar />
            </div>
            <div className="container">
                <Route exact path="/">
                    <Home />
                </Route>
                <Route path="/create-quiz">
                    <Createquiz />
                </Route>
                <Route path="/about">
                    <About />
                </Route>
                <Route path="/do-quiz/:quizId" component={Doquiz} />
                    {/*<Doquiz />*/}
                {/*</Route>*/}
            </div>

        </Router>
    )

}

export default App;
