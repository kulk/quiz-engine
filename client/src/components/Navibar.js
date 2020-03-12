import React, {Component} from 'react';
import Navitem from './Navitem';
import { Navbar, Nav, Form, FormControl, Button } from 'react-bootstrap';

class Navibar extends Component {

    constructor(props) {
        super(props);
        this.state = {
            'NavItemActive': ''
        }
    }

    activeitem = (x) => {
        if (this.state.NavItemActive.length > 0) {
            document.getElementById(this.state.NavItemActive).classList.remove('active');
        }
        this.setState({'NavItemActive': x}, () => {
            document.getElementById(this.state.NavItemActive).classList.add('active');
        });
    };

    render() {
        return (
            <Navbar bg="light" expand="lg">
                <Navbar.Brand >Quiz Engine</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto">
                        <Navitem item="Home" tolink="/" activec={this.activeitem}></Navitem>
                        <Navitem item="Create quiz" tolink="/create-quiz" activec={this.activeitem}></Navitem>
                        <Navitem item="About" tolink="/about" activec={this.activeitem}></Navitem>
                    </Nav>
                    <Form inline>
                        <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                        <Button variant="outline-success">Search</Button>
                    </Form>
                </Navbar.Collapse>
            </Navbar>
        )
    }
}

export default Navibar