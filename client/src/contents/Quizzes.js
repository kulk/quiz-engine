import React, {Component} from 'react';

export default class Quizzes extends Component {

    constructor(props) {
        super(props);
        this.state = {
            quizzes: [],
        };
    }

    componentDidMount() { //invoked immediately after a component is mounted (inserted into the tree
        fetch('http://localhost:8080/api/quizzes')// fetch accesses part of the HTTP pipeline
            .then(response => response.json())
            .then(data => this.setState({quizzes: data}))
    }

    render() {
        return (
            <div>
                { console.log(this.state)}
                {this.state.quizzes.map((item) => ( // map is a for loop
                    <div className="row">
                        <div className="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                            <div className="jumbotron">
                                <p>{item.name}</p>
                                <p>QuizId: {item.quizId}</p>
                                <div>{item.questions.map((question) => (

                                    <p>{question.question}</p>
                                    //console.log(question);

                                    ))}</div>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        )
    }


}