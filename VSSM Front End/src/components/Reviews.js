import React,{useEffect,useState}from 'react'
import '../CSS/rev.css'
import axios from 'axios'

export default function Reviews() {
    const [cities,setCities]=useState([]);
    const [serviceCenters,setServiceCenters]=useState([]);
    const [city, setCity] = useState("");

    const [onGettingReview,setOnGettingReview]=useState(false);
    const [ratingObj,setRatingObj]=useState([]);




    useEffect(() => { 
        axios.get("http://localhost:8080/center/getCities").then((response) => {
        setCities(response.data);
      }).catch((error) => {console.log(error);});}, []);

      function getServiceCenters(event){
        console.log(event.target.value);
        setCity(event.target.value)
        axios.get(`http://localhost:8080/center/getCenterByCity/${event.target.value}`).then((response)=>{console.log(response.data)
                                                         setServiceCenters(response.data.map(city=>{return city})); 
                                                        console.log(response.data.map(e => {
                                                          return (e.name);
                                                        }))}).catch((error)=>{console.log(error)})
      }

      function getReviews(e){
        console.log("hiiiiii")
        console.log(e.target.value);
       
        axios.get(`http://localhost:8080/review/getCenterReview/${city}/${e.target.value}`).then((response)=>{console.log(response.data)
                setOnGettingReview(true); setRatingObj(response.data)
       }).catch((error)=>{console.log(error)})
      }


  return (
    <div>
{/*<div class="container-fluid px-3 px-sm-5 my-5 text-center">
    <h4 class="mb-5 font-weight-bold">What Our Customers Say</h4>
    <div class="owl-carousel owl-theme">
        <div class="item first prev">
            <div class="card border-0 py-3 px-4">
                <div class="row justify-content-center">
                    <img src="https://i.imgur.com/gazoShk.jpg" class="img-fluid profile-pic mb-4 mt-3" style={{width:`150px`,height:`150px`}}/>
                </div>
                <h6 class="mb-3 mt-2">Marielle Haag</h6>
                <p class="content mb-5 mx-2">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim.</p>
            </div>
        </div>
        <div class="item show">
            <div class="card border-0 py-3 px-4">
                <div class="row justify-content-center">
                    <img src="https://i.imgur.com/oW8Wpwi.jpg" class="img-fluid profile-pic mb-4 mt-3" style={{width:`150px`,height:`150px`}}/>
                </div>
                <h6 class="mb-3 mt-2">Ximena Vegara</h6>
                <p class="content mb-5 mx-2">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim.</p>
            </div>
        </div>
        <div class="item next">
            <div class="card border-0 py-3 px-4">
                <div class="row justify-content-center">
                    <img src="https://i.imgur.com/ndQx2Rg.jpg" class="img-fluid profile-pic mb-4 mt-3" style={{width:`150px`,height:`150px`}}/>
                </div>
                <h6 class="mb-3 mt-2">John Paul</h6>
                <p class="content mb-5 mx-2">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim.</p>
            </div>
        </div>
        <div class="item last">
            <div class="card border-0 py-3 px-4">
                <div class="row justify-content-center">
                    <img src="https://i.imgur.com/T5aOhwh.jpg" class="img-fluid profile-pic mb-4 mt-3" style={{width:`150px`,height:`150px`}}/>
                </div>
                <h6 class="mb-3 mt-2">William Doe</h6>
                <p class="content mb-5 mx-2">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim.</p>
            </div>
        </div>
    </div>
  </div>*/}
  {/*<section class="home-testimonial">
    <div class="container-fluid">
        <div class="row d-flex justify-content-center testimonial-pos">
            <div class="col-md-12 pt-4 d-flex justify-content-center">
                <h3>Testimonials</h3>
            </div>
            <div class="col-md-12 d-flex justify-content-center">
                <h2>Explore the customers experience</h2>
            </div>
        </div>
        <section class="home-testimonial-bottom">
            <div class="container testimonial-inner">
                <div class="row d-flex justify-content-center">
                    <div class="col-md-4 style-3">
                        <div class="tour-item ">
                            <div class="tour-desc bg-white">
                                <div class="tour-text color-grey-3 text-center">&ldquo;Great service really loved it.&rdquo;</div>
                                <div class="d-flex justify-content-center pt-2 pb-2"><img class="tm-people" src={require("../images/img_avatar-png-2.png")} alt=""/></div>
                                <div class="link-name d-flex justify-content-center">Katrina Kaif</div>
                                <div class="link-position d-flex justify-content-center">Customer</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 style-3">
                        <div class="tour-item ">
                            <div class="tour-desc bg-white">
                                <div class="tour-text color-grey-3 text-center">&ldquo;Mast applicaion hai.&rdquo;</div>
                                <div class="d-flex justify-content-center pt-2 pb-2"><img class="tm-people" src={require("../images/img_avatar-png-2.png")} alt=""/></div>
                                <div class="link-name d-flex justify-content-center">Priyanka Chopra</div>
                                <div class="link-position d-flex justify-content-center">Service Center Manager</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 style-3">
                        <div class="tour-item ">
                            <div class="tour-desc bg-white">
                                <div class="tour-text color-grey-3 text-center">&ldquo;Easy to book servicing.&rdquo;</div>
                                <div class="d-flex justify-content-center pt-2 pb-2"><img class="tm-people" src={require("../images/img_avatar-png-2.png")} alt=""/></div>
                                <div class="link-name d-flex justify-content-center">Kareena Kapoor</div>
                                <div class="link-position d-flex justify-content-center">Customer</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>    
        </section>



    
    </div>    
</section>*/}
 <div class="col-md-12 d-flex justify-content-center">
                <h2>Explore the customers experience</h2>
            </div>
<table class="table">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">Select Your City:</th>
      <td><select class="select" placeholder="Example placeholder" onChange={getServiceCenters}>
        <option>select city</option>
      {
        cities.map(city => {
          return (<option value={city}>{city}</option>);
        })
      }
      </select></td>
    </tr>
    <tr>
      <th scope="row">Select ServiceCenter:</th>
      <td><select class="select" placeholder="Example placeholder" onChange={getReviews}>
      <option>select center</option>
      {
      serviceCenters.map(center => {
          return <option value={center}>{center}</option>;
        })
      }
      </select></td>
    </tr>
  </tbody>
    </table>


        {onGettingReview && <ShowReview revObj={ratingObj}></ShowReview>}

    </div>
  )
}


export function ShowReview(props){


    const tableRows=props.revObj.map((element)=>{
        return( 
          <tr>
            <td>
            {element.rating}/5
            </td>
            <td>{element.comment}</td>
          <td>
          </td>
        </tr>)
      
      })



    return(
        <div>


<table class="table table-dark table-striped">
            <thead>
              <tr>    
                <th>Ratings </th>
                <th>Reviews</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              {tableRows}
            </tbody>
</table> 

        </div>
    )
}