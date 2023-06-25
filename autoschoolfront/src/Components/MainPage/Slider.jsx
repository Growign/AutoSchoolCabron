import React from "react";
import {Carousel} from "react-bootstrap";
import "../../css/slider.css";
import "animate.css"
import {Link} from "react-router-dom";

// TODO: зробити анімацію тексту.

export default function Slider(){
    return (
        <div className={"container-fluid p-0 fadeIn"}>
            <Carousel pause={false} indicators={false}>
                <Carousel.Item interval={5000}>
                    <img
                        className="d-block w-100"
                        src="/firstSlider.jpg"
                        alt="First slide"
                    />
                    <Carousel.Caption>
                        <div className={"container"}>
                            <div className={"row justify-content-center"}>
                                <div className={"col-lg-7"}>
                                    <h1 className={"display-2 text-light mb-5 animate__bounce"}>Expert Instructors</h1>
                                    <Link to="" className={"btn btn-warning py-sm-3 px-sm-5"}>Learn More</Link>
                                    <Link to="/courses" className={"btn btn-light py-sm-3 px-sm-5 ms-3"}>Our Courses</Link>
                                </div>
                            </div>
                        </div>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item interval={5000}>
                    <img
                        className="d-block w-100"
                        src="/secondSlider.jpg"
                        alt="Second slide"
                    />
                    <Carousel.Caption>
                        <div className={"container"}>
                            <div className={"row justify-content-center"}>
                                <div className={"col-lg-7"}>
                                    <h1 className={"display-2 text-light mb-5 slideInDown animate__slideInDown"}>Comprehensive Curriculum</h1>
                                    <Link to={""} className={"btn btn-warning py-sm-3 px-sm-5"}>Learn More</Link>
                                    <Link to="/courses" className={"btn btn-light no-radius py-sm-3 px-sm-5 ms-3"}>Our Courses</Link>
                                </div>
                            </div>
                        </div>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item interval={5000}>
                    <img
                        className="d-block w-100"
                        src="/secondSlider.jpg"
                        alt="Third slide"
                    />
                    <Carousel.Caption>
                        <div className={"container"}>
                            <div className={"row justify-content-center"}>
                                <div className={"col-lg-7"}>
                                    <h1 className={"display-2 text-light mb-5"}>Test Preparation</h1>
                                    <Link to={""} className={"btn btn-warning py-sm-3 px-sm-5"}>Learn More</Link>
                                    <Link to="/courses" className={"btn btn-light no-radius py-sm-3 px-sm-5 ms-3"}>Our Courses</Link>
                                </div>
                            </div>
                        </div>
                    </Carousel.Caption>
                </Carousel.Item>
            </Carousel>
        </div>
    );
}