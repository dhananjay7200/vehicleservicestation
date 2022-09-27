import React ,{useEffect} from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter,Route, Routes } from "react-router-dom"
import './index.css';
//import App from './App';
import reportWebVitals from './reportWebVitals';
import 'bootstrap/dist/css/bootstrap.min.css'
import Login from './components/Login';
import Registration from './components/Registration';
import Home from './components/Home';
import Customer from './components/Customer';
import ServiceCenter from './components/ServiceCenter';
import Admin from './components/Admin';
import AboutUs from './components/AboutUs';
import HomePage from './components/HomePage';
import Reviews from './components/Reviews';
import EndGame from './components/EndGame';
import SeeAllBooking from './components/SeeAllBooking';
import AddBooking from './components/AddBooking';
import UpdateBooking from './components/UpdateBooking';
import BookingHistory from './components/BookingHistory';
import DeleteBooking from './components/DeleteBooking';
import AddPlan from './components/AddPlan';
import ForgetPassword from './components/ForgetPassword';

import UpdateRegistration from './components/UpdateRegistration';








export default function AppForRoutes(){

  


 
  return(
 
    <BrowserRouter>
        <Routes>

            <Route path="/" element={<Home></Home>}>
            <Route path="home" element={<HomePage></HomePage>}></Route>
            <Route path="aboutus" element={<AboutUs></AboutUs>}></Route>
            <Route path="login" element={<Login></Login>}></Route>
            <Route path="registration" element={<Registration></Registration>}></Route>
            <Route path="Customer" element={<Customer></Customer>} />
            <Route path="ServiceCenter" element={<ServiceCenter></ServiceCenter>} />
            <Route path="Admin" element={<Admin></Admin>} />
            <Route path="EndGame" element={<EndGame></EndGame>}></Route>
            <Route path="ForgetPassword" element={<ForgetPassword></ForgetPassword>}></Route>
            <Route path="review" element={<Reviews></Reviews>}></Route>
            <Route path="seeallbooking" element={<SeeAllBooking></SeeAllBooking>}/>
            <Route path="addbooking" element={<AddBooking></AddBooking>}/>
            <Route path="updatebooking" element={<UpdateBooking></UpdateBooking>}/>
            <Route path="bookinghistory" element={<BookingHistory></BookingHistory>}/>
            <Route path="deletebooking" element={<DeleteBooking></DeleteBooking>}/>
            <Route path="AddPlan" element={<AddPlan></AddPlan>}/>
            <Route path="UpdateRegistration" element={<UpdateRegistration></UpdateRegistration>}/>



            
            </Route>
        </Routes>
    </BrowserRouter>
 );
      }

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>

    <AppForRoutes />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
