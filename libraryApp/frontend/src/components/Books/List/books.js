import React from "react";
import BookElement from '../Element/bookElement'
import {Link} from "react-router-dom";

const books = (props) => {
    return (
      <div className={"container mt-5"}>
          <div className={"row"}>

              <div className="col mb-3">
                  <div className="row">
                      <div className="col-sm-12 col-md-12">
                          <Link className="btn btn-block btn-dark" to={"/books/add"}> Add new book</Link>
                      </div>
                  </div>
              </div>

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
                            <BookElement book={el} onDelete={props.onDelete} onEdit={props.onEdit} onMark={props.onMark}/>
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