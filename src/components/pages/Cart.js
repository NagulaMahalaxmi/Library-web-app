
import React, { useState } from 'react';
import BookList from './BookList';
import axios from 'axios';
import { useEffect } from 'react';

function Cart() {
    const[cart,setcart]=useState([]);

    useEffect(()=>{
        axios.get(`http://localhost:8091/loginuser/${localStorage.getItem('jwtToken')}`)
            .then(res => {
                console.log(res.data);
                axios.get(`http://localhost:8099/memberusername/${res.data}`)
                .then(
                    res=>{
                        setcart(res.data);
                        console.log(res.data);
                    }
                )
    })
},[]);
useEffect(()=>{
    console.log(cart);
},cart);
  

   



    return (
        <div>
            <table className="table ">
                    <thead>
                        <tr>
                            <th><b>CarId</b></th>
                            <th><b>Bookid</b></th>
                            <th><b>Username</b></th>
                            <th><b>Status</b></th>

                        </tr>
                    </thead>
                    <tbody>
                        {cart.map(item => (
                            <tr>
                                <td>{item.cartid}</td>
                                <td>{item.bookid}</td>
                                <td>{item.memberusername}</td>
                                <td>{item.status}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
           

        </div>
    );

}

export default Cart;




























// const {cartItems,onCheckoutClick} = books;
    
//     const handleCheckoutClick = () => {
//         onCheckoutClick();
//     };
//   return (
//     <div>
//         <h3>Cart</h3>
//         <ul>
//             {cartItems.map((item) => (
//                 <li key ={item.id}>
//                     <span>{item.title}</span>
//                     <span>{item.subject}</span>
//                     <span>{item.author}</span>
                    

//                 </li>
//             ))}
           
//         </ul>
//         <button onClick={handleCheckoutClick}>Checkout</button>

//     </div>