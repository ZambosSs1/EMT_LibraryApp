import axios from '../custom-axios/axios';

const libraryService = {
    fetchBooks: () => {
        return axios.get("/books");
    },

    fetchCategories: () => {
        return axios.get("/categories");
    }
}

export default libraryService;