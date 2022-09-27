import React from 'react';
import { useState } from 'react';
import { useLocation, useNavigate } from "react-router-dom";
import Axios from 'axios';
import Logout from './authenticate/Logout';
import JwtDecode from 'jwt-decode'

export default function UpdateRegistration() {
 const location = useLocation();
 const navigate = useNavigate();
 const [token, setToken] = useState(localStorage.getItem("token"));
 Axios.defaults.headers.common["Authorization"] = token;
 let decodedToken=JwtDecode( Axios.defaults.headers.common["Authorization"]);   // decoding the token
 const user=decodedToken.sub;

 const [afterAdded,setAfterAdded]=useState(false)
    const [afterSuccess,setAfterSuccess]=useState("")


  const [SDetails, setSDetails] = useState({email:user,name: '',
                                 contactNo:'',capacity:''});

  let handleChange = (e) => {
    
    let name = e.target.name;
    let value = e.target.value;
    SDetails[name] = value;
    setSDetails(SDetails);
    
  }

  let handleSubmit = (e)=>{
    e.preventDefault();
    const sDetails={...SDetails};
    console.log(sDetails);
    Axios.put('http://localhost:8080/center/updateServiceCenter',SDetails)
                .then((response)=>{console.log(response)
                
                  setAfterAdded(true)
                  setAfterSuccess("Registration Updated Successfully..")
          
                })
                    .catch((error)=>{console.log(error)})
  }

  function GoBack(){
    navigate("/ServiceCenter",{
      state: {
         name: user
          }
        })
  }


  return (
    <div>

<div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-danger" type="button" onClick={Logout}>Logout</button>
        </div>
        
        <h5> Welcome {location.state.name} </h5>   
        <h3>Update Your Details</h3>
<form  class="was-validated" onSubmit={handleSubmit}>
  <div class="col-md-4">
    <label for="name" class="form-label">Enter Name:</label>
    <input type="text" class="form-control" id="name" placeholder="enter name" name="name" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  
  
  <div class="col-md-4">
    <label for="contactNo" class="form-label">Enter Contact No:</label>
    <input type="text" class="form-control" id="contactNo" placeholder="enter contact no" name="contactNo" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>

  <div class="col-md-4">
    <label for="capacity" class="form-label">Enter Capacity:</label>
    <input type="number" class="form-control" id="capacity" placeholder="enter capacity " name="capacity" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>


  <div class="form-check mb-3">
    <input class="form-check-input" type="checkbox" id="myCheck" name="remember" required/>
    <label class="form-check-label" for="myCheck">I agree.</label>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Check this checkbox to continue.</div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>


{afterSuccess}




<div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-danger" type="button" onClick={GoBack}>Back</button>
        </div>
    </div>
  );
}