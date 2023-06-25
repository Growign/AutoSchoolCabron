import React from "react";
import "bootstrap/dist/css/bootstrap.min.css"
import "../../css/AboutCourses.css"
import {Link} from "react-router-dom";

export default function AboutCourses() {
    return (
        <div className={"container-xxl courses my-6 py-6 pb-0"}>
            <div className={"container"}>
                <div className={"text-center mx-auto mb-5 wow fadeInUp"}
                     style={{"maxWidth": "500px"}}
                >
                    <h6 className={"primary text-uppercase mb-2 font-6"}>Tranding Courses</h6>
                    <h1 className={"display-6 mb-4"}>Our Courses Upskill You With Driving Training</h1>
                </div>
                <div className={"row g-4 justify-content-center"}>
                    {/* Courses   */}
                    <div className="col-lg-4 col-md-6 wow fadeInUp">
                        <div className="courses-item d-flex flex-column bg-white overflow-hidden h-100">
                            <div className="text-center p-4 pt-0 text-color-grey">
                                <div className="d-inline-block bg-warning text-white fs-5 py-1 px-4 mb-4">6000₴</div>
                                <h5 className="mb-3 font-6">Category A</h5>
                                <p>It will allow driving motorcycles, including some with sidecars, or other two-wheeled
                                    vehicles that have
                                    an 50сс engine or more and an electric motor with 4 kW or more power</p>
                                <ol className="breadcrumb justify-content-center mb-0">
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-signal primary me-2"></i>From 16 y.o.
                                    </li>
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-calendar-alt primary me-2"></i>6 Week
                                    </li>
                                </ol>
                            </div>
                            <div className="position-relative mt-auto">
                                <img className="img-fluid" src="/A.png" alt=""/>
                                <div className="courses-overlay">
                                    <Link className="btn btn-outline-warning border-2" to="/courses">Read More</Link>
                                </div>
                            </div>
                        </div>
                    </div>
                    {/*    */}
                    <div className="col-lg-4 col-md-6 wow fadeInUp">
                        <div className="courses-item d-flex flex-column bg-white overflow-hidden h-100">
                            <div className="text-center p-4 pt-0 text-color-grey">
                                <div className="d-inline-block bg-warning text-white fs-5 py-1 px-4 mb-4">8000₴</div>
                                <h5 className="mb-3 font-6">Category B</h5>
                                <p>It will allow driving vehicles with a maximum authorized mass not exceeding 3,500
                                    kilograms (7,700 lb) and a seating capacity of eight in addition to the driver's
                                    seat</p>
                                <ol className="breadcrumb justify-content-center mb-0">
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-signal primary me-2"></i>From 18 y.o.
                                    </li>
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-calendar-alt primary me-2"></i>8 Week
                                    </li>
                                </ol>
                            </div>
                            <div className="position-relative mt-auto">
                                <img className="img-fluid" src="/B.png" alt=""/>
                                <div className="courses-overlay">
                                    <Link className="btn btn-outline-warning border-2" to="/courses">Read More</Link>
                                </div>
                            </div>
                        </div>
                    </div>
                    {/*    */}
                    <div className="col-lg-4 col-md-6 wow fadeInUp">
                        <div className="courses-item d-flex flex-column bg-white overflow-hidden h-100">
                            <div className="text-center p-4 pt-0 text-color-grey">
                                <div className="d-inline-block bg-warning text-white fs-5 py-1 px-4 mb-4">7000₴</div>
                                <h5 className="mb-3 font-6">Category C</h5>
                                <p>It will allow driving vehicles intended for the carriage of goods, the maximum
                                    permissible weight of which exceeds 7,500 kilograms (16,500 pounds)</p>
                                <ol className="breadcrumb justify-content-center mb-0">
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-signal primary me-2"></i>From 18 y.o.
                                    </li>
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-calendar-alt primary me-2"></i>10 Week
                                    </li>
                                </ol>
                            </div>
                            <div className="position-relative mt-auto">
                                <img className="img-fluid" src="/C.png" alt=""/>
                                <div className="courses-overlay">
                                    <Link className="btn btn-outline-warning border-2" to="/courses">Read More</Link>
                                </div>
                            </div>
                        </div>
                    </div>
                    {/* End Courses   */}
                </div>
            </div>
        </div>
    );
}