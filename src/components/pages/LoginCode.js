import { React,useState } from "react";
import axios from 'axios';
import './LoginCode.css';
import { Link } from "react-router-dom";




const LoginCode = () => {
    const[username,setUsername] = useState('');
    const[password,setPassword] = useState('');
    const[isLoggedIn,setIsLoggedIn] = useState('');

    const[error,setError] = useState('');
    function handleSubmit(event) {
        event.preventDefault();
        axios.post("http://localhost:8091/authenticate",
            {
                "username": username,
                "password": password
            }).then(res => {
                console.log(res.data.jwt)
                localStorage.setItem("jwtToken", res.data.jwt);
                setIsLoggedIn(true);
                console.log(isLoggedIn);

                if(res==403){
                    alert("Incorrect username or password");
                }
                else{
                    console.log("successfully logged in");
                }
                window.location.href = '/';
            }
            )
            
        
    }

       

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    };
    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    }
    const handlebutton =() =>{
        alert("Login successful");
    }
   

   
    return (
         
   
        <div className="div">
        <form  className="form" onSubmit={handleSubmit}>
         <h4>Login as Student</h4>  
         <label  htmlFor="username">Username</label>
        <input className="labelfield" type="text" id="username" name="username" value={username} onChange={handleUsernameChange} required/> 

        <label htmlFor="password">Password</label>
        <input  className="labelfield" type="password" id="password" name="password" value={password} onChange={handlePasswordChange} required/> 

         <button type="submit" onClick={handlebutton}>Login</button>

         {error && <div>{error}</div>}
         <p>Don't have an account?<Link to="/Signupcode"><b>Signup</b></Link></p>
         </form>
    </div> 
       
        
    );

}
export default LoginCode;




 