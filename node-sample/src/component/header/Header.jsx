import React from 'react';
import {connect} from 'react-redux';
import {addTodo} from "../../action/todo";

class Header extends React.Component {

    render() {
        let input;
        const {onClick} = this.props;
        return (
            <div className="row todolist-header">
                <div className="col ">
                    <div className="row justify-content-center">
                        <h3 className="h3">Crossent Todo List</h3>
                    </div>
                    <div className="row mt-2">
                        <div className="col text-center">
                            <input type="text" className="form-control todo-input w-80" placeholder="입력하세요" ref={node => {input = node;}}/>
                            <button type="button" className="add-btn" onClick={() => {onClick(input.value); input.value = "";}}>
                                <i className="fa fa-plus-circle vt-middle"></i>
                            </button>
                        </div>
                    </div>
                </div>
            </div>

        );
    }
}

const headerDispatchToProps = (dispatch) => {
    return {
        onClick(txt) {
            dispatch(addTodo(txt))
        }
    }
}

export default connect(undefined, headerDispatchToProps)(Header);
