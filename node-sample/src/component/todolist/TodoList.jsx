import React from "react";
import {connect} from "react-redux";
import {complete} from "../../action/todo";
import Todo from "./Todo";

class TODOList extends React.Component {
    render() {
        const {todos, onClick} = this.props;
        return (
          <div className="row todolist-con">
              <ul>
                  {todos.map(todo =>
                    <Todo key={todo.id} onClick={onClick} {...todo} />
                  )}
              </ul>
          </div>

        );
    }
}

const todolistStateToProps = (state) => {
    return {
        todos: state.todos
    }
}

const todolistDispatchToProps = (dispatch) => {
    return {
        onClick(data) {
            console.log(data);
            dispatch(complete(data))
        }
    }
}

export default connect(todolistStateToProps, todolistDispatchToProps)(TODOList);
