import React from 'react';
import './Staffbooks.css';
import { Link } from 'react-router-dom';
import Adddeletebooks from './Adddeletebooks';
import Adddeletemembers from './Adddeletemembers';


import Button from 'react-bootstrap/Button';

function Staffbooks() {
   const handleBook = () =>{
    window.location.href = '/staffbooks';

   }
  
  return (
    <>
    {/* <div className='parent'> */}
    
    <div className='staffimage'></div>
        
    {/* <div className='staffbutton'>
    <Link to="/adddeletebooks"><button className='image-button'>ADD/Delete Books</button> </Link>
    </div> */}
    <div className='staffbutton'>
    <Link to="/adddeletebooks"><Button variant="primary">ADD Books</Button>{' '}</Link>
    </div>
    

    <div>
    <div className='memberimage'> </div>
     {/* <div className='memberbutton'>
    <Link to="/adddeletemembers"><button className='image-button1'>ADD/Delete Members </button></Link> */}
    <div className='memberbutton' >
    <Link to="/adddeletemembers"><Button variant="primary">ADD Members</Button>{' '}</Link>
    </div>
    </div>
    
    
    </>
  );
}

export default Staffbooks;