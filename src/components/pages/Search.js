import React from 'react';
import '../../App.css';
import { useState } from 'react';
import axios from 'axios';
 import './Search.css';

 import Button from 'react-bootstrap/Button';

function Search() {
  const[query,setQuery] = useState('');
  const[searchResults,setSearchResults] = useState([]);

  const handleSubmit = async (event) => {
    event.preventDefault();
    try{
    const response = await axios.get(`http://localhost:8098/api/title/${query}`);
    setSearchResults(response.data);
    console.log(response.data)
  } catch(error) {
    console.log(error);
  }

  }
  

  return (
   
    <div className='searchdiv'>
    <form className='searchform' onSubmit={handleSubmit}>
    <label htmlFor='search-input'></label>
    <input id="search-input" type="text" value={query} onChange={(event)=>setQuery(event.target.value)}/>
    <button className='searchbutton' type='submit'>Search</button> 
    </form>
    
   
    
   
      <div className="book-list11 container">
      <div className="row">
        {searchResults.map(book => (
            <div className="col-md-7 book" key={book.access_number}>
              <h2 className="title">{book.title}</h2>
              <div className="imagegrid">
              <img src={book.bookurl} alt={book.title} ></img>
              </div>
              <p>{book.subject}</p>
             </div>
             
        )
      )}
      </div>

      </div>
      </div>
      
   
   
    
   
  );
}
export default Search;


 {/* <div className='search-book'>
      {searchResults.map(book =>
        <div key = {book.access_number}>
          <img src={book.bookurl} alt={book.title}/>
          <div>
          <h3>{book.title}</h3>
          <p>{book.author}</p>
          </div>
          
        </div>  */}