import TextField from '@mui/material/TextField';
import axios from 'axios';
import Button from '@mui/material/Button';
import '../App.css'
import { FormControl } from '@mui/material';
import {Container, Paper} from '@material-ui/core';
import { useState,useEffect} from 'react';
import { useParams,useNavigate } from 'react-router-dom';
const AddJob = () => {
    const paperStyle={padding:"50px 20px", width:600,margin:"20px auto"}
    const [user,setUser] = useState("")
    
    const {id}=useParams()
    const [errors, setErrors] = useState({})
    const navigate = useNavigate()
    const [name,setName] = useState("")
    const [email,setEmail] = useState("")
    const [phone,setPhone] = useState("")
    const [address,setAddress] = useState("")
    const [jobs,setJobs] = useState([])
    
    const [jobType,setJobType] = useState("")
    const [jobFee,setJobFee] = useState()
    const [jobpublicationDate,setJobDate] = useState("")

 
    useEffect(()=> {
        axios.get(`http://localhost:8080/user/${id}`)
        .then((res) =>{
            console.log('Here is my view page', res.data)
            
            const user = res.data
            setName(user.name)
            setEmail(user.email)
            setPhone(user.phone)
            setAddress(user.address)
            setJobs(user.jobs)
           
            
            
           
            user.jobs.map(jobs => 
                setJobFee(jobs.fee)
              )
              user.jobs.map(jobs => 
                setJobType(jobs.jobType)
              )
              user.jobs.map(jobs => 
                setJobDate(jobs.publicationDate)
              )
         
        
        })
        .catch((err)=>{
            console.log('This is our view error', err)
        })
    },[id])
   
   
    const handleSubmit = () => {
        
      
        setJobs([
            ...jobs,
            { jobType: jobType, fee:jobFee,publicationDate:jobpublicationDate }
            
          ])
       
          console.log(jobs)
        
   
        axios.put(`http://localhost:8080/user/${id}/process`,{name,email,phone,address,jobs})
        .then((res)=> {
            
            if (res.data.error){
                console.log(res.data.error)
                setErrors(res.data.error)
                console.log(setErrors)
                setUser(user.user)
                setEmail(user.email)
                setName(user.name)
                setAddress(user.address)
                setPhone(user.phone)

                user.jobs.map(jobs => 
                    setJobFee(jobs.fee)
                  )
                  user.jobs.map(jobs => 
                    setJobType(jobs.jobType)
                  )
                  user.jobs.map(jobs => 
                    setJobDate(jobs.publicationDate)
                  )
                
            }else{
                
                console.log("this is our handlesubmit for update page",res)
      
            }
         
        })
        .catch(err => console.log(err))
    }
   return(
    <Container>
    <Paper elevation={3} style={paperStyle}>
   
  
        
    
          
         
<FormControl>
    <TextField id="outlined-basic" label="Job Type" value={jobType}
    onChange={(e)=>setJobType(e.target.value)}/>
        
        <TextField id="outlined-basic" label="Fee" value={jobFee}
    onChange={(e)=>setJobFee(e.target.value)}/>
        
        <TextField id="outlined-basic" label="Date" value={jobpublicationDate}
    onChange={(e)=>setJobDate(e.target.value)}
    />
    
       
  
        
        err={errors.message}
       <Button onClick={() => {

  handleSubmit();
  
       
}}>Add Job to individual</Button>
  
</FormControl>
     
<ul>Name: {name}</ul>
        <ul> Address: {address}</ul>
        <ul> Phone: {phone}</ul>
        <ul>jobs: {jobs.map(jobs => (
      
      <div className='goodathletics' key ={jobs.id}>
        <ul>JobType: {jobs.jobType}</ul>
       <ul> Fee: {jobs.fee}</ul>
       <ul> Date: {jobs.publicationDate}</ul>
       </div>
      
       ))}  </ul> 
</Paper>

</Container>


   )
}

export default AddJob