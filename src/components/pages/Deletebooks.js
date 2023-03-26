
import { React,useState } from "react";
import axios from 'axios';
import { Link } from "react-router-dom";
import './Deletebooks.css';


function Deletebooks() {

    const[access_number,setAccessnumber] = useState('');
    const[author,setAuthor] = useState('');
    const[category,setCategory] = useState('');
    const[title,setTitle] = useState('');
    const[keyword,setKeyword] = useState('');
    const[subject,setSubject] = useState('');
    const[quantity,setQuantity] = useState('');
    const[error,setError] = useState('');

   
    
    function handlesubmitBook(event) {
        event.preventDefault();
       axios.delete(`http://localhost:8093/api/Books/accessno/${access_number}`,
       {
        "access_number":access_number,
        "author":author,
        "category":category,
        "title" :title,
        "keyword":keyword,
        "subject":subject,
        "quantity":quantity
        

       }
       ).then(res=>{
        console.log(res.data);
        
       }).catch(error=>{
        console.log(error)
       })
    };

    const handleAccessnumber = (event) => {
        setAccessnumber(event.target.value);
    }

    const handleAuthor= (event) => {
        setAuthor(event.target.value);
    };
    const handleCategory = (event) => {
        setCategory(event.target.value);
    }
    const handleTitle = (event) => {
        setTitle(event.target.value);
    }
    const handleKeyword= (event) => {
        setKeyword(event.target.value);
    };
    const handleSubject = (event) => {
        setSubject(event.target.value);
    }
    const handleQuantity = (event) => {
        setQuantity(event.target.value);
    }
    const handlebutton =() =>{
        alert("Book deleted successfully");
    }
    
    
  return (
    <>
    <div className="button-containerb"> 
  
    <form className="bookformb"  onSubmit={handlesubmitBook}>
             <h2>Delete Book</h2>  
             <label htmlFor="Access Number">Access Number</label>
            <input type="text" id="Access Number" name="Access Number" value={access_number} onChange={handleAccessnumber} required/> 
             <label htmlFor="author">Author</label>
            <input type="text" id="author" name="author" value={author} onChange={handleAuthor} required/> 
            <label htmlFor="title">Title</label>
            <input type="title" id="title" name="title" value={title} onChange={handleTitle} required/> 
            <label htmlFor="category">Category</label>
            <input type="category" id="category" name="category" value={category} onChange={handleCategory} required/> 
            <label htmlFor="keyword">Keyword</label>
            <input type="keyword" id="keyword" name="keyword" value={keyword} onChange={handleKeyword} required/> 
            <label htmlFor="quantity">Quantity</label>
            <input type="quantity" id="quantity" name="quantity" value={quantity} onChange={handleQuantity} required/> 
            <label htmlFor="subject">Subject</label>
            <input type="subject" id="subject" name="subject" value={subject} onChange={handleSubject} required/> 

            <Link to="/staffbooks"><button type="submit" onClick={handlebutton}>Delete Book</button></Link>
             {error && <div>{error}</div>}
             <p>Add Book? <Link to="/Signupcode"> <b>ADD</b> </Link></p>
    </form>
   
   

    </div>
    </>
  )
}

export default Deletebooks;