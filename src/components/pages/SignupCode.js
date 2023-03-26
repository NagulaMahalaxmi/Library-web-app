

import { React,useState } from "react";
import axios from 'axios';
import './SignupCode.css';
import { Link } from "react-router-dom";

const SignupCode = () => {
    const[username,setUsername] = useState('');
    const[email,setEmail] = useState('');
    const[password,setPassword] = useState('');
   
    
    function handlesubmit(event) {
        event.preventDefault();
       axios.post(`http://localhost:8091/api/signup`,
       {
        "username":username,
        "email":email,
        "password":password
        

       }
       ).then(res=>{
        console.log(res.data);
        
       }).catch(error=>{
        console.log(error)
       })
       window.location.href = '/';
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
        alert("signup successful");
    }

    return (
        <>
         
    <div className="signup">
       
        <form className="form"onSubmit={(e)=>handlesubmit(e)}>
        <h4>Signup as Student</h4>
            <label htmlFor="firstName">UserName</label>
            <input className="labelfield" type="text" id="firstName" name="firstName" value={username} onChange={(event) => setUsername(event.target.value)} required/> 

            <label htmlFor="email">Email</label>
            <input className="labelfield" type="email" id="email" name="email" value={email} onChange={(event => setEmail(event.target.value))} required/>

            <label htmlFor="password">Password</label>
            <input className="labelfield" type="password" id="password" name="password" value={password} onChange={(event => setPassword(event.target.value))} required/> 

            
            <button type="submit" onClick={handlebutton}>Sign Up</button>
            <p>Already have an account? <Link to="/logincode"><b>Login</b></Link></p>
    </form>
    
    </div>
</>
    );
    

}
export default SignupCode;