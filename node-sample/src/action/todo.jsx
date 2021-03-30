// action type
const ADD_TODO = 'ADD_TODO'
const COMPLETE_TODO = 'COMPLETE_TODO'

// action creators
function addTodo(text) {
    return { type: ADD_TODO,  text};
}

function complete({complete, id}) {
    return { type: COMPLETE_TODO,  complete, id};
}

export  {
    ADD_TODO,
    COMPLETE_TODO,
    addTodo,
    complete,
}
