import React, { useState } from "react";
import { Button } from "./Button";
import { Link } from "react-router-dom";
import "./Navbar.css";
import Dropdown from "./Dropdown";
import Dropdown2 from "./Dropdown";


function Navbar() {
  const [click, setClick] = useState(false);
  

  const handleClick = () => setClick(!click);
  const closeMobileMenu = () => setClick(false);

  const handlelogout=()=>{
    window.localStorage.removeItem("jwtToken");
    window.location.href="/"
}
  
  return (
    <>
      <nav className="navbar">
        <Link to="/" className="navbar-logo" >
            <h6>Library Management System</h6>
        </Link>
        
        
        <li className="nav-item-search">
            <Link
              to="/Search"
              className="nav-links"
              onClick={closeMobileMenu}
            >
              Search
            </Link>
          </li>

        <div className="menu-icon" onClick={handleClick}>
          <i className={click ? "fas fa-times" : "fas fa-bars"} />
        </div>

        <ul className={click ? "nav-menu active" : "nav-menu"}>
          <li className="nav-item">
            <Link
              to="/"
              className="nav-links"
              onClick={closeMobileMenu}
            >
              Home
            </Link>
          </li>
          
          
          
          <li className="nav-item">
            <Link
              to="/logincode2"
              className="nav-links"
              onClick={closeMobileMenu}
            >Staff
            </Link>
          </li>
          <li className="nav-item">
            <Link
              to="/logincode"
              className="nav-links"
              onClick={closeMobileMenu}
            >
              Student
            </Link>
          </li>
          <li className="nav-item">
            <Link
              to="/Booksdisplay"
              className="nav-links"
              onClick={closeMobileMenu}
            >
              Books
            </Link>
          </li>

          
          

          <li className="nav-item">
            <Link
              to="/Cart"
              className="nav-links"
              onClick={closeMobileMenu}
            >
              Cart
            </Link>
          </li>
          </ul>
          
          
        
       
      </nav>
    </>
  );
}

export default Navbar;
