import React from "react";
import BookElement from '../Element/bookElement'

const books = (props) => {
    return (
      <div className={"container mm-4 mt-5"}>
          <h1>Hello</h1>
          <div className={"row"}>
              <div className={"row"}>
                  <table className={"table table-striped"}>
                      <thead>
                            <tr>
                                <th scope={"col"}>Name</th>
                                <th scope={"col"}>Categories</th>
                                <th scope={"col"}>Author</th>
                                <th scope={"col"}>Available Copies</th>
                            </tr>
                      </thead>
                      <tbody>
                      {props.books.map((el) => {
                          return(
                            <BookElement book={el}/>
                          )
                      })}
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
    );
}

export default books;