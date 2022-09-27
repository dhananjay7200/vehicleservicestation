import React, { useState } from 'react';
import { useLocation, useNavigate } from "react-router-dom";
import Axios from 'axios';
import Logout from './authenticate/Logout';
import JwtDecode from 'jwt-decode'


export default function SeeAllBooking()
{
  const navigate = useNavigate();
  const location = useLocation();
  const [token, setToken] = useState(localStorage.getItem("token"));
  Axios.defaults.headers.common["Authorization"] = token;
  let decodedToken=JwtDecode( Axios.defaults.headers.common["Authorization"]);   // decoding the token
  const user=decodedToken.sub;

   
    let [arr,setarr] = useState(location.state.name)     //got array of objects containing booking objects

      
      const all_list = arr.map((e)=>{ return(
       <tr> <td>{e.bookingDate}</td>
        <td>{e.bookingId}</td>
        <td>{e.modelNo}</td>
        <td>{e.planName}</td>
        <td>{e.totalCost}</td>
        <td>{e.vehicleRegNo}</td></tr>)
      }) 



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
           
            <h3>All Bookings for Today</h3>
<div>
              
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Booking Date </th>
        <th>Booking Id </th>
        <th>Model No </th>
        <th>Plan Name </th>
        <th>Total cost </th>
        <th>vehicle Reg No </th>
      </tr>
    </thead>
    <tbody>
      
       {all_list}
      
       
    </tbody>
  </table>
</div>


<div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-danger" type="button" onClick={GoBack}>Back</button>
        </div>

            
        
        </div>
    );
}