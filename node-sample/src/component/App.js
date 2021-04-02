import React, {Component} from "react";
import Header from "./header/Header";
import TodoList from "./todolist/TodoList";
import Footer from "./footer/Footer";
import './App.css';

class App extends Component {
  render() {
    return (
        <div className="container">
            <div className="row">
              <div className="col">
                <Header/>
                <TodoList/>
              </div>
            </div>
        </div>
    )
  }
}

export default App;
