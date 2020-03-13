import React, {Component} from 'react';

class Doquiz extends Component {
    constructor(props) {
        super(props);
        this.state = {
            questions: [],
        };
    }

    componentDidMount() {
        const {quizId} = this.props.match.params;
        console.log(quizId);

        fetch('/api/quizzes/' + quizId + '/questions')
            .then(response => response.json())
            .then(data => this.setState({questions: data}))

    }

    render() {
        return (

            <div className="condiv home">
                <h2>Play quiz</h2>
                {this.state.quizzes.map((item) => (
                    <div>
                        item.
                    </div>
                ))}
                { console.log(this.state)}
            </div>
        )
    }

}

export default Doquiz 