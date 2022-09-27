import React,{ useState } from 'react';
import { useLocation, useNavigate } from "react-router-dom";
import Axios from 'axios';
import Logout from './authenticate/Logout';
import JwtDecode from 'jwt-decode'

export default function AddBooking()
{

  const navigate = useNavigate();
  const location = useLocation();
  const [token, setToken] = useState(localStorage.getItem("token"));
  Axios.defaults.headers.common["Authorization"] = token;
  let decodedToken=JwtDecode( Axios.defaults.headers.common["Authorization"]);   // decoding the token
  const user=decodedToken.sub;

    let [customerDetails, setCustomerDetails] = useState({date: '',slots: '',email: ''});
    const [afterAdded,setAfterAdded]=useState(false)
    const [afterSuccess,setAfterSuccess]=useState("")

    let handleChange = (e) => {
      
      let name = e.target.name;
      let value = e.target.value;
      customerDetails[name] = value;
      setCustomerDetails(customerDetails);
      
    }
  
    let handleSubmit = (e)=>{
      e.preventDefault();
      const custDetails={...customerDetails};
      console.log(custDetails);
      Axios.post(`http://localhost:8080/slotmanagement/addSlots`,{"date":customerDetails.date,
      "center":{"email":customerDetails.email},
      "totalSlot":customerDetails.slots
  })
      .then((response)=>{
        console.log(response)
        setAfterAdded(true)
        setAfterSuccess("Slot Added Successfully")

      }).catch((error)=>{console.log(error)})

    }

    function GoBack(){
      navigate("/ServiceCenter",{
        state: {
           name: user
            }
          })
    }

        

    return(
        <div>

<div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-danger" type="button" onClick={Logout}>Logout</button>
        </div>


            <h3>Add servicing slots for date</h3>
            
            
    <div>
<form  class="was-validated" onSubmit={handleSubmit}>
  <div class="col-md-4">
    <label for="Date" class="form-label">Date:</label>
    <input type="Date" class="form-control" id="date" placeholder="Enter Date" name="date" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  <div class="col-md-4">
    <label for="slot" class="form-label">Enter Number of slots:</label>
    <input type="number" class="form-control" id="slot" placeholder="Number of slots" name="slots" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  
  <div class="col-md-4">
    <label for="email" class="form-label">Username:</label>
    <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
  </div>
  
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
    </div>
    {afterSuccess}


    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-danger" type="button" onClick={GoBack}>Back</button>
        </div>




            {/**Logout button to destroy jwt token and navigate to home page*/}
          
        </div>
    );
}