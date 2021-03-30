import React from 'react';

class TODO extends React.Component {
    render() {
        const {id, todo, complete, onClick} = this.props;
        return (
            <li id={id}
                onClick={() => onClick({id:id, complete: !complete})}
                className={!!complete ? 'completed' : ''}
            >{todo}</li>
        );
    }
}

export default TODO;
