import './App.css';
import React from "react";
import {Component} from "react";
import {
    BrowserRouter as Router,
    Route,
    Routes,
    Navigate
} from "react-router-dom";
import Books from '../Books/List/books';
import Categories from '../Categories/categories';
import libraryService from "../../repository/libraryRepository";

//TODO: Sredi gi rutite !!!
class App extends Component{

  constructor(props) {
    super(props);
    this.state = {
        books: [],
        categories: []
    }
  }

  render() {
    return (
        <Router>
            <Route>
                <main>
                    <div className={"container"}>
                        <Routes>
                            <Route path={"/books"}
                                   exact render={() =>
                                <Books books={this.state.books}/>
                            }
                            />
                            <Route path={"/categories"}
                                   exact render={() =>
                                <Categories categories = {this.state.categories}/>
                            }
                            />
                            <Route path="*" element={<Navigate to ="/" />}/>
                        </Routes>
                    </div>
                </main>
            </Route>
        </Router>
    )
  }

  loadBooks = () => {
      libraryService.fetchBooks()
          .then((data) => {
              this.setState({
                  books: data.data
              })
          });
  }

  loadCategories = () => {
      libraryService.fetchCategories()
          .then((data) => {
              this.setState({
                  categories: data.data
              })
          });
  }

  componentDidMount() {
      this.loadBooks();
      this.loadCategories();
  }
}

export default App;
