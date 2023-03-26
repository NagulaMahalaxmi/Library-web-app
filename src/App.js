import React from 'react';
import Navbar from './components/Navbar';
import './App.css';
import Home from './components/pages/Home';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Services from './components/pages/Login';
import Products from './components/pages/Products';

import SignUp from './components/pages/Search';


import Login from './components/pages/Login';
import Search from './components/pages/Search';
import LoginCode from './components/pages/LoginCode';
import SignupCode from './components/pages/SignupCode';
import Tabledisplay from './components/pages/Tabledisplay';
import Booksdisplay from './components/pages/Booksdisplay';

import Staffsignup from './components/pages/Staffsignup';
import Logincode2 from './components/pages/Logincode2';

import Adddeletebooks from './components/pages/Adddeletebooks';
import Staffbooks from './components/pages/Staffbooks';
import Adddeletemembers from './components/pages/Adddeletemembers';
import Deletebooks from './components/pages/Deletebooks';
import Deletemembers from './components/pages/Deletemembers';
import BookList from './components/pages/BookList';
import Cart from './components/pages/Cart';
import Homedisplay from './components/pages/Homedisplay';
import Searchpage from './components/pages/Searchpage';



function App() {
  return (
    <>
   
    <Router>
      <Navbar />
      <Switch>

        <Route path='/' exact component={Home} />
        <Route path='/Tabledisplay' component={Tabledisplay} />

        <Route path='/Homedisplay' component={Homedisplay}/>
       
        <Route path='/logincode' component={LoginCode} />
        <Route path='/Signupcode' component={SignupCode} />

        <Route path='/logincode2' component={Logincode2} />
        <Route path='/Staffsignup' component={Staffsignup} />


        <Route path='/Booksdisplay' component={Booksdisplay} />
       
        <Route path='/adddeletebooks' component={Adddeletebooks}/>
        <Route path='/adddeletemembers' component={Adddeletemembers}/>
        <Route path='/staffbooks' component={Staffbooks}/>

        <Route path='/Deletebooks' component={Deletebooks}/>
        <Route path='/Deletemembers' component={Deletemembers}/>
        <Route path='/Cart' component={Cart}/>

        <Route path='/Search' component={Search}/>
        


      </Switch>
    </Router>
    
    
    {/* <Display></Display> */}
    {/* <Tabledisplay></Tabledisplay> */}
    </>
    
  );
}

export default App;
