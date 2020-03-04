import React, {Component} from 'react';

export default class Quizzes extends Component {

    constructor(props) {
        super(props);
        this.state = {
            quizzes: [],
        };
    }

    componentDidMount() {
        fetch('http://localhost:8080/api/quizzes')
            .then(response => response.json())
            .then(data => this.setState({quizzes: data}))
    }

    render() {
        return (
            <div className="row">
                {this.state.quizzes.map((item) => (
                    <p>{item.name}</p>
                ))}
            </div>
        )
    }


}