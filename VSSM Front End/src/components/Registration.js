import React,{useState} from 'react'
import Axios from 'axios'
import Login from './Login'
import {useNavigate} from 'react-router-dom';
import { Link, Outlet } from "react-router-dom"
import '../CSS/r.css'



export default function Registration() {

  let [customerDetails, setCustomerDetails] = useState({firstName: '',lastName: '',mobileNo: '',email: '',password: '',securityAnswer:'', role:'CUSTOMER'});
  const [onGettingRegister, setOnGettingRegister] = useState(false);
  let [onSucess, setOnSucess]=useState('');
  let handleChange = (e) => {
    
    let name = e.target.name;
    let value = e.target.value;
    customerDetails[name] = value;
    setCustomerDetails(customerDetails);
    
  }

  let handleSubmit = (e)=>{
    e.preventDefault();
    const custDetails={...customerDetails};
    console.log(customerDetails);
    Axios.post('http://localhost:8080/customer/register',customerDetails).then((response)=>{console.log(response)
                                                                  setOnGettingRegister(true)
                                                                setOnSucess('Registration Successful!!')}).catch((error)=>{console.log(error)})
  }


  return (
    <div>

{/*<h4 class="text-center mt-4 mb-4" >Register</h4>
  <form class="was-validated" onSubmit={handleSubmit}>
  <div class="col-md-4">
    <label for="firstName" class="form-label">First Name:</label>
    <input type="text" class="form-control" id="firstName" placeholder="Enter Firstname" name="firstName" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill field.</div>
  </div>
  <div class="col-md-4">
    <label for="lastName" class="form-label">Last Name:</label>
    <input type="text" class="form-control" id="lastName" placeholder="Enter Lastname" name="lastName" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill field.</div>
  </div>
  <div class="col-md-4">
    <label for="mobileNo" class="form-label">Mobile No:</label>
    <input type="number" class="form-control" id="mobileNo" placeholder="Enter Mobile No" name="mobileNo" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill field.</div>
  </div>
  <div class="col-md-4">
    <label for="email" class="form-label">Username:</label>
    <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill field.</div>
  </div>
  <div class="col-md-4">
    <label for="password" class="form-label">Password:</label>
    <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" onChange={handleChange} required/>
    <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill field.</div>
  </div>
   
  <div class="form-group form-row">
                                            <div class="col-md-4">
                                                <label class="custom-control custom-checkbox checkbox-lg">
                                                    <input type="checkbox" class="custom-control-input" id="customCheck1"/>
                                                    <div class="custom-control-label" for="customCheck1">I agree with <a href="#" target="_blank">terms and conditions</a></div>
                                                </label>
                                            </div>
                                        </div>
                                        <hr class="mt-3 mb-4"/>
                                        <div class="col-4">
                                            <div class="d-flex flex-wrap justify-content-between align-items-center">
                                                <button class="btn btn-primary mt-3 mt-sm-0" type="submit">Register</button>
                                            </div>
                                        </div>
  </form>  */}


<div>
    <div class="card">
        <div class="row g-0">
            <div class="col-md-6">
                <div class="h-100 d-flex justify-content-center align-items-center">
                    <div class="py-4 px-3">
                        <h4>Signup</h4>
                      <form onSubmit={handleSubmit}>
                        <div class="row g-2 mt-1">
                        <div class="col-md-4">
                           <label for="firstName" class="form-label">First Name:</label>
                           <input type="text" class="form-control" id="firstName" placeholder="Enter Firstname" name="firstName" onChange={handleChange} required/>
                           <div class="valid-feedback">Valid.</div>
                           <div class="invalid-feedback">Please fill field.</div>
                        </div>
                        <div class="col-md-4">
                          <label for="lastName" class="form-label">Last Name:</label>
                          <input type="text" class="form-control" id="lastName" placeholder="Enter Lastname" name="lastName" onChange={handleChange} required/>
                          <div class="valid-feedback">Valid.</div>
                          <div class="invalid-feedback">Please fill field.</div>
                       </div>
                       <div class="col-md-4">
                          <label for="mobileNo" class="form-label">Mobile No:</label>
                          <input type="number" class="form-control" id="mobileNo" placeholder="Enter Mobile No" name="mobileNo" onChange={handleChange} required/>
                          <div class="valid-feedback">Valid.</div>
                          <div class="invalid-feedback">Please fill field.</div>
                       </div>
                      </div>
                      <div class="row mt-2">
                        <div class="col-md-12">
                            <label for="email" class="form-label">Email:</label>
                            <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" onChange={handleChange} required/>
                            <div class="valid-feedback">Valid.</div>
                            <div class="invalid-feedback">Please fill field.</div>
                        </div>
                      </div>
                     {/* <div class="row mt-2 mb-2">
                        <div class="col-md-12">
                          <label for="password" class="form-label">Password:</label>
                          <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" onChange={handleChange} required/>
                          <div class="valid-feedback">Valid.</div>
                          <div class="invalid-feedback">Please fill field.</div>
                        </div>
                      </div> <span class=""></span>
                      <div class="row mt-2 mb-2">
                        <div class="col-md-12">
                          <label for="security_question" class="form-label">Nick Name:</label>
                          <input type="password" class="form-control" id="security_question" placeholder="security_question" name="securityAnswer" onChange={handleChange} required/>
                          <div class="valid-feedback">Valid.</div>
                          <div class="invalid-feedback">Please fill field.</div>
                        </div>
                      </div>*/}



                      <div class="row g-2 mt-1">
                        <div class="col-md-6">
                        <label for="password" class="form-label">Password:</label>
                          <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" onChange={handleChange} required/>
                          <div class="valid-feedback">Valid.</div>
                          <div class="invalid-feedback">Please fill field.</div>
                        </div>
                        <div class="col-md-6">
                        <label for="security_question" class="form-label">Nick Name:</label>
                          <input type="password" class="form-control" id="security_question" placeholder="security_question" name="securityAnswer" onChange={handleChange} required/>
                          <div class="valid-feedback">Valid.</div>
                          <div class="invalid-feedback">Please fill field.</div>
                       </div>
                       
                      </div>
                  















                      
                        <div class="row mt-2">
                            <div class="col-md-12"> <button class="btn btn-primary w-100 signup-button" type="submit">Signup</button>
                           
                            </div>
                        </div>
                        <div class="member mt-1"> <span>Already a member?</span> <a class="text-decoration-none"
                                href="#">Signin</a> </div>
                  </form>
                  <h5>{onSucess}</h5>

                  {onGettingRegister && <a><Link to="/Login" >Click here to Login</Link></a>}     
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div>
                    <div >
                        <h6>Welcome Vehicle Service Station Application</h6>
                        <span>Vision To Service</span>
                    </div>
                    <div> <span></span> <span></span> <span></span> <span></span>
                        <span> </span> <span></span> <span></span>
                        <span></span> <span>  </span> <span></span> </div>
                </div>
            </div>
        </div>
    </div>
    <div class="parallelogram"> <span></span> <span></span> <span></span> </div>
</div>









                              
{/*<h2>{onSucess}</h2>

{onGettingRegister && <a><Link to="/Login" >Click here to Login</Link></a>}*/}
    </div>


  )
}
