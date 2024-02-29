import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { FormControl } from '@mui/material';
import {Container, Paper} from '@material-ui/core';
import { useState,useEffect } from 'react';
import {Link} from 'react-router-dom';
const User = () => {
    const paperStyle={padding:"50px 20px", width:600,margin:"20px auto"}
    const [users,setUsers] = useState([])
    const [name,setName] = useState("")
    const [email,setEmail] = useState("")
    const [phone,setPhone] = useState("")
    const [address,setAddress] = useState("")
   const [jobs,setJobs] = useState([])
    
    
    const handleClick = (e) => {
        e.preventDefault()
        const user = {name,email,phone,address,jobs}
       
        fetch("http://localhost:8080/user/add",{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(user)
        
    }).then(() =>{
        console.log("User added")
        console.log(user)
    })
    }

    useEffect(() => {
        fetch("http://localhost:8080/user/getAll")
        .then(res => res.json())
        .then((result)=>{
            setUsers(result);
          
            
           
        }
        )
       
        
    })
   
return(
<Container>
    <Paper elevation={3} style={paperStyle}>
<FormControl>

    <TextField id="outlined-basic" label="name" value={name}
    onChange={(e)=>setName(e.target.value)}/>
    
    <TextField id="outlined-basic" label="email" value={email}
    onChange={(e)=>setEmail(e.target.value)}/>
        
        <TextField id="outlined-basic" label="address" value={address}
    onChange={(e)=>setAddress(e.target.value)}/>
        
        <TextField id="outlined-basic" label="Phone Number" value={phone}
    onChange={(e)=>setPhone(e.target.value)}/>
       
     
    <Button onClick={handleClick}>Add Individual</Button>
</FormControl>
</Paper>
<Paper elevation={3} style={paperStyle}>
   {users.map(user =>(
        
   <Paper elevation={6} style ={{margin:"10px",padding:"15px",textAlign:"left"}} key={user.id}>

   
    Name:{user.name}
    Email:{user.email}
    Address: {user.address}
    {user.jobs.map(jobs => (
       <ul key ={jobs.id}>
        <ul>JobType: {jobs.jobType}</ul>
       <ul> Fee: {jobs.fee}</ul>
       <ul> Date: {jobs.publicationDate}</ul>
       </ul>
      
    ))}
     <Link to={`/update/${user.id}`}>Edit Job</Link>

    </Paper>
    ))
}

   
</Paper>
</Container>

)
}
export default User