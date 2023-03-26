import React, { useState } from 'react'
import { Button } from '../Button';

function Searchpage() {

    const[name,setName] = useState('');
    const[vari,setVari] = useState('');
    const[data,setData] = useState('');
    const[temp,setTemp] = useState('');

    const onhandlesubmithandler =(e) =>{
        console.log(name);
        console.log(vari)
        setTemp("true")
        if(name=='Accessnumber'){
            setData(data.filter(book => {
                return book.Accessnumber == vari

            }))
            console.log(data)
        } else if(name=='Title'){
            setData(data.filter(book =>{
                return book.Title == vari
            }))
        } else if(name=='Author'){
            setData(data.filter(book => {
                return book.Author == vari
            }))
        } else if(name=='Subject'){
            setData(data.filter(book => {
                return book.Subject == vari
            }))
        }else if(name=='Keyword'){
                setData(data.filter(book => {
                    return book.Keyword == vari
                }))
        }else{}
        console.log(data)

    }
  return (
    <div>
        
        <label> select category to search</label>
        <select className='form-control' value={name} onChange={e => {setName(e.target.value)}}>
        <option value="Accessnumber">Accessnumber</option>
        <option value="Title">Title</option>
        <option value="Author">Author</option>
        <option value="Subject">Subject</option>
        <option value="Keyword">Keyword</option>
        </select><br/>
         <label>Enter the field name:</label><br/>
        <input type="text" value ={vari} onChange={e=>{setVari(e.target.value)}}></input>
        <Button onClick={onhandlesubmithandler}>Submit</Button> 
       
    </div>
  )
}

export default Searchpage;