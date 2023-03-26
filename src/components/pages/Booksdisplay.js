import axios from "axios";
import React from "react";
import { useEffect, useState } from "react";
import Categorylist from "./Categorylist";
import BookList from "./BookList";
import Cart from "./Cart";

import "./Booksdisplay.css";
import Homedisplay from "./Homedisplay";
import { isExpired } from "react-jwt";



function Booksdisplay() {
  const [categories, setCategories] = useState([]);
  const [books, setBooks] = useState([]);
  const [selectedcategory, setSelectedcategory] = useState(null);

  if(isExpired(localStorage.getItem('jwtToken'))){
    alert("Session timeout please login again")
    window.location.href('/')

  }



  useEffect(() => {
    async function fetchCategories() {
      const response = await axios.get(`http://localhost:8095`);
      const data = response.data;
    
      setCategories(data);
    }
    fetchCategories();
  }, []);
  console.log(categories);

  const fetchBooks = async (categoryid) => {
    console.log(categoryid);
    let url = `http://localhost:8093/api/Books`;
    if (categoryid) {
      url = `http://localhost:8093/api/Books/book/${categoryid}`;
    }
    const response = await axios.get(url);
    const data = response.data;
    console.log(response.data);
    setBooks(data);
   
  };
  useEffect(() => {
    fetchBooks(selectedcategory);
  }, [selectedcategory]);

  
  return (
    <div>

      <Categorylist
        categories={categories}
         onSelectCategory={setSelectedcategory}
      />
      <BookList books={books} />
     
   
      </div>
  );
}

export default Booksdisplay;
