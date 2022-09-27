import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'
import bike from '../images/bssb.png'
import { Link, Outlet } from "react-router-dom"
import '../CSS/homepage.css'

export default function HomePage() {
  return(<div>
    

    <div class="container">
        <div class="row">
            <div class="col-md-4 mb-md-0 mb-3">
                <div class="card d-flex flex-column align-items-center justify-content-center">
                    <div class="inner-content d-flex flex-column align-items-center justify-content-center">
                        <div class="img-container rounded-circle">
                            <img src={require("../images/img_avatar-png-2.png")}
                                alt="" class="rounded-circle"/>
                        </div>
                        <div class="h3">Dhananjay Khuje</div>
                        <p class="designation text-muted text-uppercase">FullStack Developer</p>
                    </div>
                    <ul
                        class="social-links d-flex align-items-center justify-content-around list-unstyled w-100 fs-5 m-0 p-0">
                        <li><a href="#"><span class="fab fa-facebook"></span></a></li>
                        <li><a href="#"><span class="fab fa-twitter"></span></a></li>
                        <li><a href="#"><span class="fab fa-google-plus"></span></a></li>
                        <li><a href="#"><span class="fab fa-linkedin-in"></span></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-4 mb-md-0 mb-3">
                <div class="card d-flex flex-column align-items-center justify-content-center">
                    <div class="inner-content d-flex flex-column align-items-center justify-content-center">
                        <div class="img-container rounded-circle">
                            <img src={require("../images/img_avatar-png-2.png")}
                                alt="" class="rounded-circle"/>
                        </div>
                        <div class="h3">Bhavanjay Depe</div>
                        <p class="designation text-muted text-uppercase">FullStack Developer</p>
                    </div>
                    <ul
                        class="social-links d-flex align-items-center justify-content-around list-unstyled w-100 fs-5 m-0 p-0">
                        <li><a href="#"><span class="fab fa-facebook"></span></a></li>
                        <li><a href="#"><span class="fab fa-twitter"></span></a></li>
                        <li><a href="#"><span class="fab fa-google-plus"></span></a></li>
                        <li><a href="#"><span class="fab fa-linkedin-in"></span></a></li>
                    </ul>
                </div>
            </div>
           
           
            
        </div>
    </div>
             
</div>)
}
