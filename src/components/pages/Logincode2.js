import { React, useState } from "react";
import axios from "axios";
import "./LoginCode.css";
import { Link } from "react-router-dom";

import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";

const LoginCode2 = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const handleSubmit = async (event) => {
    event.preventDefault();
    const response = await axios.post("http://localhost:8092/authenticate", {
      username: username,
      password: password,
    });
    localStorage.setItem("token", response.data.token);
    if (response == 403) {
      console.log("Incorrect username or password");
    } else {
      console.log("successfully logged in");
    }
    window.location.href = "/staffbooks";
  };

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };
  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handlebutton =() =>{
    alert("Login successful");
}

  return (
    <div className="div">
        <form  className="form" onSubmit={handleSubmit}>
         <h4>Login as Staff</h4>
         <label htmlFor="username">Username</label>
        <input className="labelfield" type="text" id="username" name="username" value={username} onChange={handleUsernameChange} required/>

        <label htmlFor="password">Password</label>
        <input className="labelfield" type="password" id="password" name="password" value={password} onChange={handlePasswordChange} required/>

         <button type="submit" onClick={handlebutton}>Login</button>
         {error && <div>{error}</div>}
         <p>Don't have an account?<Link to="/Staffsignup"><b>Signup</b> </Link></p>
         </form>
    </div>
   
  );
};
export default LoginCode2;


