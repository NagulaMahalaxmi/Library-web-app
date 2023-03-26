import React from 'react'

function Homedisplay({booksdetails}) {
  return (
    <div  className="book-list container">
    <div className="row">
       
    {booksdetails.map((book)=>{
            
            return( 
                <div className="col-md-4 book" key={book.access_number}>
                    <h2 className="title">{book.title}</h2>

                    <img src={book.bookurl} alt={book.title}/>
                    <h3><p>{book.subject}</p></h3>

                   
                    
                </div>
                
            );
        })}
        </div>
   
</div>

  )
}

export default Homedisplay;