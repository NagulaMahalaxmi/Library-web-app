import axios from "axios";
import React, { useEffect, useState } from "react";
import "./Tabledisplay.css";
import { useHistory } from "react-router-dom";

function Tabledisplay() {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    loadBooks();
  }, []);

  const loadBooks = async () => {
    const result = await axios.get(`http://localhost:8083/api/Books`);
    console.log(result.data);
    setBooks(result.data);
  };

  const history = useHistory();
  const handleBookClick = () => {
    history.push("/Booksdisplay");
  };


  return (
  
    <div className="book-list container">
    <div className="row">
      {books.map((book) => {
        return (
          <div className="col-md-4 book" key={book.access_number}>
            <h2 className="title">{book.title}</h2>

            
            <img src={book.bookurl} alt={book.title} onClick={ handleBookClick} ></img>
           

           
            <b><p>{book.subject}</p></b>

            
            
            
          </div>
        );
      })}
    </div>
  </div>
);
}

export default Tabledisplay;
