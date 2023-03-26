import React, { useState } from 'react'

function Issue() {
  const[issue,setIssue]  = useState('');
  const[bookid,setbookid]=useState(1);

//   useEffect(() => {
//     async function fetchData() {
//         axios.get(`http://localhost:8091/loginuser/${localStorage.getItem('jwtToken')}`)
//             .then(res => {
//                 console.log(res.data);
//                 axios.post(`http://localhost:8099/books/issue`,
//                 {
//                     "bookid":bookid,
//                     "memberusername":res.data
//                 }
//                 )
//                 .then(
//                     res=>{
//                         setIssue(res.data);
//                         console.log(res.data);
//                     }
//                 )
                    
//             })
//     }
//     fetchData();
// }, []);




 

  return (
    <div>
    Hloo

    </div>
    
  )
}

export default Issue