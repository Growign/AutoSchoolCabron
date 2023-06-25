import React from "react";
import "bootstrap/dist/css/bootstrap.min.css"
import "animate.css"
import {Link} from "react-router-dom";

//TODO: порівняти кнопки

export default function AboutUs() {
    return (
        <div className={"container-xxl py-6"}>
            <div className={"container"}>
                <div className={"row g-5"}>
                    <div className={"col-lg-6 wow fadeInUp"}
                         style={{"visibility": "visible", "animationDelay": "0.1s", "animationName": "fadeInUp"}}>
                        <div className={"position-relative overflow-hidden ps-5 pt-5 h-100"}
                             style={{"minHeight": "400px"}}>
                            <img className={"position-absolute w-100 h-100"} src={"/about.jpg"}
                                 style={{"objectFit": "cover"}} alt={""}/>
                        </div>
                    </div>
                    <div className={"col-lg-6 fadeInUp"}
                         style={{"visibility": "visible", "animationDelay": "0.5s", "animationName": "fadeInUp"}}>
                        <div className={"h-100 text-color-grey"}>
                            <h6 className={"primary text-uppercase mb-2 font-6"}>About Us</h6>
                            <h1 className={"display-6 mb-4"}>We Help Students To Pass Test & Get A License On The First
                                Try</h1>
                            <p>Our driving school is committed to offering top-notch instruction to aspiring drivers of
                                all ages and experience levels. With a focus on safe and confident driving, we create a
                                supportive learning environment that empowers our students to gain the knowledge,
                                skills, and confidence necessary to become responsible drivers for life. Our experienced
                                and certified instructors bring their expertise and exceptional teaching abilities to
                                every lesson, ensuring that each student receives personalized attention and
                                guidance.</p>
                            <p className="mb-4"></p>
                            <div className="row g-2 mb-4 pb-2">
                                <div className="col-sm-6">
                                    <i className="fa fa-check primary me-2"></i>Fully Licensed
                                </div>
                                <div className="col-sm-6">
                                    <i className="fa fa-check primary me-2"></i>Online Tracking
                                </div>
                                <div className="col-sm-6">
                                    <i className="fa fa-check primary me-2"></i>Afordable Fee
                                </div>
                                <div className="col-sm-6">
                                    <i className="fa fa-check primary me-2"></i>Best Trainers
                                </div>
                            </div>
                            <div className="row g-4">
                                <div className="col-sm-6">
                                    <Link className="btn btn-warning py-3 px-5" to="/#">Read More</Link>
                                </div>
                                <div className="col-sm-6">
                                    <Link
                                        className="d-inline-flex align-items-center btn btn-outline-warning border-2 p-2"
                                        to="tel:+380000000000">
                                    <span className="flex-shrink-0 btn-square bg-warning">
                                        <i className="fa fa-phone-alt text-white"></i>
                                    </span>
                                        <span className="px-3">+380 00 000 00 00</span>
                                    </Link>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}