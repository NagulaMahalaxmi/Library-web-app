import axios from "axios";
import { useEffect, useState } from "react";
import "./BookList.css";
import { useHistory } from "react-router-dom";
import Cart from "./Cart";
import Search from "./Search";

function BookList({ books }) {
  const [issue, setIssue] = useState("");
  const [Return, setReturn] = useState("");
  const [renewal, setRenewal] = useState("");

  const history = useHistory();

  function handleIssueClick(e, id) {
    e.preventDefault();
    axios
      .get(
        `http://localhost:8091/loginuser/${localStorage.getItem("jwtToken")}`
      )
      .then((res) => {
        axios
          .post(`http://localhost:8099/books/issue`, {
            bookid: id,
            memberusername: res.data.toString(),
          })
          .then((res) => {
            setIssue(res.data);
            console.log(res.data);
          });
        window.location.href = "/Cart";
      });
  }

  function handleReturnClick(e, id) {
    e.preventDefault();
    axios
      .get(
        `http://localhost:8091/loginuser/${localStorage.getItem("jwtToken")}`
      )
      .then((res) => {
        console.log(res.data);
        axios
          .post(`http://localhost:8099/books/return`, {
            bookid: id,
            memberusername: res.data.toString(),
          })
          .then((res) => {
            setReturn(res.data);
            console.log(res.data);
          });
        window.location.href = "/Cart";
      });
  }
  function handleRenewalClick(e, id) {
    e.preventDefault();
    axios
      .get(
        `http://localhost:8091/loginuser/${localStorage.getItem("jwtToken")}`
      )
      .then((res) => {
        console.log(res.data);
        axios
          .post(`http://localhost:8099/books/renewal`, {
            bookid: id,
            memberusername: res.data.toString(),
          })
          .then((res) => {
            setRenewal(res.data);
            console.log(res.data);
          });
        window.location.href ="/Cart";
      });
  }

  return (
    <>
     
       <div className="book-list container">
      <div className="row">
        {books.map(book => (
            <div className="col-md-4 book" key={book.access_number}>
              <h2 className="title">{book.title}</h2>
              <div className="imagegrid">
              <img src={book.bookurl} alt={book.title} ></img>
              </div>
              <p>{book.subject}</p>

              <button
                className="button"
                onClick={(e) => {handleIssueClick(e,book.access_number) }}
              >
                Issue
              </button>
              <button
                className="button"
                 onClick={ (e) => {handleReturnClick(e,book.access_number)}}
              >
                Return
              </button>
              <button
                className="button"
                 onClick={(e) => {handleRenewalClick(e,book.access_number)}}
              >
                Renewal
              </button>
            </div>
        ))}
      </div>
    </div> 
      
    </>
  );
}
export default BookList;
















//const bookid= books.map(book=>(book.access_number))
//useEffect(() => {

//     axios.post(`http://localhost:8089/books/issue`,
//     {
//      "bookid":bookid,
//      "memberid":memberid

//     }

//     ).then(res=>{
//      console.log(res.data);

//     }).catch(error1=>{
//      console.log(error1)
//     })
//     setIssue(res.data);
// });


{/* <div class="w3-show-inline-block">
              <div class="w3-bar">
              <button class="w3-button w3-blue" className="button"
                onClick={(e) => {handleIssueClick(e,book.access_number) }}>Issue</button>
              <button class="w3-button w3-blue" className="button"
                 onClick={ (e) => {handleReturnClick(e,book.access_number)}}>Return</button>
              <button class="w3-button w3-blue" className="button"
                 onClick={(e) => {handleRenewalClick(e,book.access_number)}}>Renewal</button>
            </div>
            </div>
            </div> */}