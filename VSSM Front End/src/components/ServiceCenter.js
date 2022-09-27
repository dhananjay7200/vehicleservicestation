import React from 'react';
import { useState } from 'react';
import { useLocation, useNavigate } from "react-router-dom";
import Axios from 'axios';
import Logout from './authenticate/Logout';


export default function ServiceCenter() {
  
  const navigate = useNavigate();
  const location = useLocation();
  let [isData,setisData] = useState('');
  let [noData,setnoData] = useState('');
  let [myData,setmyData] = useState({});

  

  function seeHandler(e)
  { 
    let d = new Date(); //current date to fetch todaye bookings
    
      let str1 = (d.getDate());
      let str2 = (d.getMonth()+1);
      let str3 = (d.getFullYear());
      let date = str3+"-0"+str2+"-"+str1;
      console.log(date);
      
     
    Axios.get(`http://localhost:8080/booking/getTodaysBooking/${location.state.name}/${date}`)
                              .then((response)=>{
                                 console.log("got data..!");
                                 console.log("got data from server=",response.data);
                                if(response.data)
                                {
                                  setisData(true);
                                  setmyData(response.data);
                                  console.log(typeof(response.data))

                                  navigate("/SeeAllBooking",
                                  {
                                    state:{
                                     name: response.data
                                    }
                                  })

                                }
                                else
                                {
                                  setnoData("Sorry no data Available..");

                                }
                               
                                })
                              .catch((error)=>{console.log(error)})

     
  }
  function addHandler(e)
  { 
    let user = location.state.name
    console.log(user);
    console.log("Add details==");
    navigate("/AddBooking", {
      state: {
          sname:user
          }
        })
    
    
  }
  function updateHandler()
  {
    console.log("update details");
    let user = location.state.name
    
    navigate("/UpdateBooking", {
      state: {
          sname:user
          }
        })
  }
  function deleteHandler()
  {
    console.log("del details");
    
    let user = location.state.name
    navigate("/DeleteBooking", {
      state: {
          sname:user
          }
        })
  }
  function showHistoryHandler()
  {
    console.log("history of details");
    
    let user = location.state.name
    navigate("/BookingHistory", {
      state: {
          sname:user
          }
        })
  }
  function updateRegistrationHandler()
  {
    console.log("update reg  details");
    let user = location.state.name
    navigate("/UpdateRegistration", {
      state: {
          sname:user
          }
        })
  }
  function showReviewHandler()
  {
    console.log("show review details");
    let user = location.state.name
    navigate("/reviews", {
      state: {
          sname:user
          }
        })
  }
  function AddPlanHandler()
  {
    console.log("add plan for service provider");
    navigate("/AddPlan",{
      
    })

  }
  
  
  return (
    <div>
  
    <div class="container mt-3">

      {/**Logout button to destroy jwt token and navigate to home page*/}
  <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-danger" type="button" onClick={Logout}>Logout</button>
        </div>
  
  {/**get customer name from jwt token */}
 
  <div class="card mb-3" style={{width:`350px`,height:`100px`}}>
  <div class="row no-gutters">
    <div class="col-md-4">
      <img src={require("../images/img_avatar-png-2.png")} class="card-img" alt="..."/>
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">HI, {location.state.name}</h5>
      </div>
    </div>
  </div>
</div>







  
  <table class="table table-hover">
    <thead>
      <tr>
        <th>See Today's Bookings  </th>
        <th><button type="submit" class="btn btn-primary" onClick={seeHandler}>Show</button></th>
        
      </tr>
    </thead>

    <thead>
      <tr>
        <th>Add Servicing slots </th>
        <th><button type="submit" class="btn btn-primary" onClick={addHandler}>Add</button></th>
      </tr>
    </thead>

    <thead>
      <tr>
        <th>Update Servicing slots </th>
        <th><button type="submit" class="btn btn-primary" onClick={updateHandler}>Update</button></th>
      </tr>
    </thead>

    <thead>
      <tr>
        <th>Delete Bookings </th>
        <th><button type="submit" class="btn btn-primary" onClick={deleteHandler}>Delete</button></th>
      </tr>
    </thead>

    {/*<thead>
      <tr>
        <th>Show Bookings History </th>
        <th><button type="submit" class="btn btn-primary" onClick={showHistoryHandler}>Show</button></th>
      </tr>
    </thead>*/}

    <thead>
      <tr>
        <th>Update Registration Details </th>
        <th><button type="submit" class="btn btn-primary" onClick={updateRegistrationHandler}>Update</button></th>
      </tr>
  </thead>

    <thead>
      <tr>
        <th>Add Servicing Plans </th>
        <th><button type="submit" class="btn btn-primary" onClick={AddPlanHandler}>Add</button></th>
      </tr>
    </thead>

    {/*<thead>
      <tr>
        <th>See All Reviews And Comments </th>
        <th><button type="submit" class="btn btn-primary" onClick={showReviewHandler}>Show</button></th>
        
      </tr>
</thead>*/}
    <thead>
    <tr>
     
    
       
    </tr>
    </thead>
  </table>

  {noData}
  
</div>




    </div>

      
      
      
  )
}

