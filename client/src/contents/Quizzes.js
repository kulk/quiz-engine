import React, {Component} from 'react';
import { Link, useParams } from "react-router-dom";

export default class Quizzes extends Component {

    constructor(props) {
        super(props);
        this.state = {
            quizzes: [],
        };
    }

    componentDidMount() { //invoked immediately after a component is mounted (inserted into the tree
        fetch('/api/quizzes')// fetch accesses part of the HTTP pipeline
            .then(response => response.json())
            .then(data => this.setState({quizzes: data}))
    }

    render() {
        return (
            <div>
                {this.state.quizzes.map((item) => ( // map is a for loop
                    <div className="row">
                        <div className="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                            <div className="jumbotron">
                                <Link to ={ '/do-quiz/' + item.quizId} >{item.name}</Link>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        )
    }

    function


}