import React from "react";
import "bootstrap/dist/css/bootstrap.min.css"
import "../../css/AboutCourses.css"
import {Link} from "react-router-dom";

export default function CoursesGrid() {
    return (
        <div>
            <h1 className={"text-md-center mt-3 font-6"}>Courses</h1>
            <div className={"container my-5"}>
                <div className={"row g-4 justify-content-center"}>
                    {/* Courses */}
                    <div className="col-lg-4 col-md-6 wow fadeInUp">
                        <div className="courses-item d-flex flex-column bg-white overflow-hidden h-100">
                            <div className="text-center p-4 pt-0 text-color-grey">
                                <div className="d-inline-block bg-warning text-white fs-5 py-1 px-4 mb-4">5000₴</div>
                                <h5 className="mb-3 font-6">Category A1</h5>
                                <p>It will allow driving mopeds, scooters or other two-wheeled vehicles that have up to
                                    50сс engine and an electric motor up to 4 kW power</p>

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
                                <img className="img-fluid" src="/A1.png" alt=""/>
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
                                <h5 className="mb-3 font-6">Category B1</h5>
                                <p>It will allow driving quad and tricycles, motorcycles and other three-wheeled
                                    (four-wheeled) vehicles, the permitted maximum weight of which does not exceed 400
                                    kilograms</p>
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
                                <img className="img-fluid" src="/B1.png" alt=""/>
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
                                <h5 className="mb-3 font-6">Category C1</h5>
                                <p>It will allow driving vehicles intended for the carriage of goods, the maximum
                                    permissible weight from 3500 to 7500 kilograms (from 7700 to 16500 pounds)</p>
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
                                <img className="img-fluid" src="/C1.png" alt=""/>
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
                    {/*    */}
                    <div className="col-lg-4 col-md-6 wow fadeInUp">
                        <div className="courses-item d-flex flex-column bg-white overflow-hidden h-100">
                            <div className="text-center p-4 pt-0 text-color-grey">
                                <div className="d-inline-block bg-warning text-white fs-5 py-1 px-4 mb-4">7000₴</div>
                                <h5 className="mb-3 font-6">Category D1</h5>
                                <p>It will allow driving buses in which the number of seats, except for the driver's seat, does not exceed 16</p>
                                <ol className="breadcrumb justify-content-center mb-0">
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-signal primary me-2"></i>From 21 y.o.
                                    </li>
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-calendar-alt primary me-2"></i>12 Week
                                    </li>
                                </ol>
                            </div>
                            <div className="position-relative mt-auto">
                                <img className="img-fluid" src="/courses-3.jpg" alt=""/>
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
                                <h5 className="mb-3 font-6">Category D</h5>
                                <p>It will allow driving buses in which the number of seats, except for the driver's seat, exceed 16</p>
                                <ol className="breadcrumb justify-content-center mb-0">
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-signal primary me-2"></i>From 21 y.o.
                                    </li>
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-calendar-alt primary me-2"></i>10 Week
                                    </li>
                                </ol>
                            </div>
                            <div className="position-relative mt-auto">
                                <img className="img-fluid" src="/courses-3.jpg" alt=""/>
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
                                <h5 className="mb-3 font-6">Category BE</h5>
                                <p>It will allow driving vehicles category B with trailer, the permitted maximum weight of which exceeds 750 kilograms</p>
                                <ol className="breadcrumb justify-content-center mb-0">
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-signal primary me-2"></i>From 19 y.o.
                                    </li>
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-calendar-alt primary me-2"></i>8 Week
                                    </li>
                                </ol>
                            </div>
                            <div className="position-relative mt-auto">
                                <img className="img-fluid" src="/courses-2.jpg" alt=""/>
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
                                <h5 className="mb-3 font-6">Category C1E</h5>
                                <p>It will allow driving vehicles category C1 with trailer, the permitted maximum weight of which exceeds 750 kilograms</p>
                                <ol className="breadcrumb justify-content-center mb-0">
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-signal primary me-2"></i>From 19 y.o.
                                    </li>
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-calendar-alt primary me-2"></i>10 Week
                                    </li>
                                </ol>
                            </div>
                            <div className="position-relative mt-auto">
                                <img className="img-fluid" src="/courses-3.jpg" alt=""/>
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
                                <h5 className="mb-3 font-6">Category CE</h5>
                                <p>It will allow driving vehicles category C with trailer, the permitted maximum weight of which exceeds 750 kilograms</p>
                                <ol className="breadcrumb justify-content-center mb-0">
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-signal primary me-2"></i>From 19 y.o.
                                    </li>
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-calendar-alt primary me-2"></i>10 Week
                                    </li>
                                </ol>
                            </div>
                            <div className="position-relative mt-auto">
                                <img className="img-fluid" src="/courses-3.jpg" alt=""/>
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
                                <h5 className="mb-3 font-6">Category D1E</h5>
                                <p>It will allow driving vehicles category D1 with trailer, the permitted maximum weight of which exceeds 750 kilograms</p>
                                <ol className="breadcrumb justify-content-center mb-0">
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-signal primary me-2"></i>From 21 y.o.
                                    </li>
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-calendar-alt primary me-2"></i>10 Week
                                    </li>
                                </ol>
                            </div>
                            <div className="position-relative mt-auto">
                                <img className="img-fluid" src="/courses-3.jpg" alt=""/>
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
                                <h5 className="mb-3 font-6">Category DE</h5>
                                <p>It will allow driving vehicles category D with trailer, the permitted maximum weight of which exceeds 750 kilograms</p>
                                <ol className="breadcrumb justify-content-center mb-0">
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-signal primary me-2"></i>From 21 y.o.
                                    </li>
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-calendar-alt primary me-2"></i>10 Week
                                    </li>
                                </ol>
                            </div>
                            <div className="position-relative mt-auto">
                                <img className="img-fluid" src="/courses-3.jpg" alt=""/>
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
                                <h5 className="mb-3 font-6">Category T</h5>
                                <p>It will allow driving trams and trolleybuses</p>
                                <ol className="breadcrumb justify-content-center mb-0">
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-signal primary me-2"></i>From 21 y.o.
                                    </li>
                                    <li className="breadcrumb-item small"><i
                                        className="fa fa-calendar-alt primary me-2"></i>14 Week
                                    </li>
                                </ol>
                            </div>
                            <div className="position-relative mt-auto">
                                <img className="img-fluid" src="/courses-3.jpg" alt=""/>
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