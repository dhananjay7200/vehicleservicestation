import React,{useState}  from 'react'
import Axios from 'axios'
import { Link, Outlet } from "react-router-dom"



export default function ForgetPassword() {
  let [resetDetails, setResetDetails] = useState({email:'',password:'',securityAnswer:''});
  let [onSucess, setOnSucess]=useState(false);
  let [onFail , setOnFail]=useState('');


  let handleChange = (e) => {
    
    let name = e.target.name;
    let value = e.target.value;
    resetDetails[name] = value;
    setResetDetails(resetDetails);
    
  }

 function handle(e){
  e.preventDefault();
  
  console.log(resetDetails);
  Axios.post(`http://localhost:8080/customer/forgetPaswword/${resetDetails.email}/${resetDetails.securityAnswer}`).then((response)=>{console.log(response)
                                      setOnSucess(true)                          }).catch((error)=>{console.log(error); setOnFail("Sorry invalid input!!")})
}


  return (
    <div>

<div >
      <div class="row align-items-center justify-content-center
          min-vh-100">
        <div class="col-12 col-md-8 col-lg-4">
       
              <div class="mb-4">
                <h5>Forgot Password?</h5>
                <p class="mb-2">Enter your registered email ID and Security answer to reset the password
                </p>
              </div>
              <form>
                <div class="mb-3">
                  <label for="email" class="form-label">Email</label>
                  <input type="email" id="email" class="form-control" name="email" placeholder="Email"
                    required onChange={handleChange} />
                </div>
                <div class="mb-3">
                  <label for="text" class="form-label">your nick name</label>
                  <input type="text" id="security_question" class="form-control" name="securityAnswer" placeholder="security_question"
                    required onChange={handleChange}/>
                </div>
             
                <div class="mb-3 d-grid">
                  <button type="submit" class="btn btn-primary" onClick={handle}>
                    Reset Password
                  </button>
                </div>
              
              {onFail}
              {onSucess && <Reset details={resetDetails} ></Reset>}
              </form>
            </div>
          </div>
        </div>
      
    </div>
  )
}


export function Reset(props){
  let [password , setPassword]=useState(props.details.password);
  let [onSucess, setOnSucess]=useState(false);
  let [message, setMessage]=useState('');
  

  let handleChange = (e) => {
      console.log(e.target.value);
     setPassword(e.target.value)
 }


 let handle = (e) => {
  e.preventDefault();
  
  console.log(e)
  Axios.post(`http://localhost:8080/customer/setpassword/${props.details.email}/${password}`).then((response)=>{console.log(response)
                                      setOnSucess(true); setMessage('Password update successfully!')                         }).catch((error)=>{console.log(error); })
}



  return(
    <div>
         <div class="mb-3">
                  <label for="text" class="form-label">New Password</label>
                  <input type="text" id="password" class="form-control" name="password" placeholder="password"
                    required onChange={handleChange}/>
                </div>
                <div class="mb-3 d-grid">
                  <button type="submit" class="btn btn-primary" onClick={handle}>
                    Set new password
                  </button>
                </div>

                {message}
                {onSucess && <a><Link to="/Login" >Click here to Login</Link></a>}


    </div>
  )
}
