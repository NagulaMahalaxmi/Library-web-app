import React from 'react';
import { Link } from 'react-router-dom';
import { useState } from 'react';
import axios from 'axios';
import './Deletemembers.css';

function  Deletemembers() {
    const[id,setId] = useState('');
    const[username,setUsername] = useState('');
    const[email,setEmail] = useState('');
    const[password,setPassword] = useState('');
    const[error1,setError1] = useState('');
   
    
    function handlesubmitmember(event) {
        event.preventDefault();
       axios.delete(`http://localhost:8093/api/Members/${id}`,
       {
        "id":id,
        "username":username,
        "email":email,
        "password":password
        

       }
       ).then(res=>{
        console.log(res.data);
        
       }).catch(error1=>{
        console.log(error1)
       })
    };

    const handleUsername = (event) => {
        setUsername(event.target.value);
    };
    const handleEmail = (event) => {
        setEmail(event.target.value);
    }
    const handlePassword = (event) => {
        setPassword(event.target.value);
    }
    const handlebutton =() =>{
        alert("Member deleted successfully");
    }
    
  return (
    
    <div  className="button-container1">
    <form className="memberform"   onSubmit={handlesubmitmember}>
             <h2>Delete Member</h2> 
             <label htmlFor="Id">Id</label>
            <input type="text" id="id" name="id" value={id} onChange={(event) => setId(event.target.value)} required/>  
            <label htmlFor="firstName">UserName</label>
            <input type="text" id="firstName" name="firstName" value={username} onChange={(event) => setUsername(event.target.value)} required/> 
            <label htmlFor="email">Email</label>
            <input type="text" id="email" name="email" value={email} onChange={(event => setEmail(event.target.value))} required/>
            <label htmlFor="password">Password</label>
            <input type="password" id="password" name="password" value={password} onChange={(event => setPassword(event.target.value))} required/> 
            
            <Link to="/staffbooks"><button type="submit" onClick={handlebutton}>Delete Member</button></Link>
             {error1 && <div>{error1}</div>}
             <p>Add Member? <Link to="/adddeletemembers"> <b>Add</b></Link></p>
             </form>
             </div>
   
  )
}

export default Deletemembers;