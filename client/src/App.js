import React from 'react';
import Quizzes from './components/Quizzes';
import './App.css';

function App() {
  return (
    <div className="App">
        <nav>
            <h2>QUIZ ENGINE</h2>
        </nav>
        <div className="row">
            <Quizzes />
        </div>

    </div>
  );
}

export default App;
