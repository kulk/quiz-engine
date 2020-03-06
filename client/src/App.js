import React from 'react';
import Quizzes from './components/Quizzes';
import Navbar from './components/Navbar';
import './App.css';
import { BrowserRouter as Router, Route, } from "react-router-dom";
import Home from './contents/Home';
import About from './contents/About';

function App() {

    return (
        <Router>
            <div className="App">
                <Navbar />
                {/*<Route exact path "/">
                    <Home/>
                </Route>*/}
                <Route path="/about">
                    <About />
                </Route>
            </div>
            {/*<h2>QUIZ ENGINE</h2>*/}
            {/*<Quizzes/>*/}
        </Router>
    )

}

export default App;
