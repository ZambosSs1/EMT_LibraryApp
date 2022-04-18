import React from "react";

const bookElement = (props) => {
    return (
        <tr>
            <td>{props.book.name}</td>
            <td>{props.book.category.name}</td>
            <td>{props.book.author.name}</td>
            <td>{props.book.availableCopies}</td>
        </tr>
    )
}

export default bookElement;