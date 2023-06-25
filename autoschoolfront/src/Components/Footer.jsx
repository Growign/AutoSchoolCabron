import React from "react";
import "bootstrap/dist/css/bootstrap.min.css"
import "../css/Footer.css"
import {Link} from "react-router-dom";

export default function Footer() {
    return (
        <footer className="container-fluid bg-dark text-light footer mb-0 py-6 wow fadeIn">
            <div className="container">
                <div className="row g-5">
                    <div className="col-lg-3 col-md-6">
                        <h4 className="text-white mb-4 font-6">Get In Touch</h4>
                        <h2 className="primary mb-4 font-6"><i className="fa fa-car text-white me-2"></i>Carbon</h2>
                        <p className="mb-2"><i className="fa fa-map-marker-alt me-3"></i>123 Street, New York, USA</p>
                        <p className="mb-2"><i className="fa fa-phone-alt me-3"></i>+012 345 67890</p>
                        <p className="mb-2"><i className="fa fa-envelope me-3"></i>info@example.com</p>
                    </div>
                    <div className="col-lg-3 col-md-6">
                        <h4 className="text-light mb-4 font-6">Quick Links</h4>
                        <Link className="btn btn-link" to="/">About Us</Link>
                        <Link className="btn btn-link" to="/">Contact Us</Link>
                        <Link className="btn btn-link" to="/">Our Services</Link>
                        <Link className="btn btn-link" to="/">Terms &amp; Condition</Link>
                        <Link className="btn btn-link" to="/">Support</Link>
                    </div>
                    <div className="col-lg-3 col-md-6">
                        <h4 className="text-light mb-4 font-6">Popular Links</h4>
                        <Link className="btn btn-link" to="/">About Us</Link>
                        <Link className="btn btn-link" to="/">Contact Us</Link>
                        <Link className="btn btn-link" to="/">Our Services</Link>
                        <Link className="btn btn-link" to="/">Terms &amp; Condition</Link>
                        <Link className="btn btn-link" to="/">Support</Link>
                    </div>
                    <div className="col-lg-3 col-md-6">
                        <h4 className="text-light mb-4 font-6">Newsletter</h4>
                        <form action="">
                            <div className="input-group">
                                <input type="text" className="form-control p-3 border-0"
                                       placeholder="Your Email Address"/>
                                <button className="btn btn-warning">Sign Up</button>
                            </div>
                        </form>
                        <h6 className="text-white mt-4 mb-3 font-6">Follow Us</h6>
                        <div className="d-flex pt-2">
                            <Link className="btn btn-square btn-outline-light me-1" to="/"><i
                                className="fab fa-twitter"></i></Link>
                            <Link className="btn btn-square btn-outline-light me-1" to="/"><i
                                className="fab fa-facebook-f"></i></Link>
                            <Link className="btn btn-square btn-outline-light me-1" to="/"><i
                                className="fab fa-youtube"></i></Link>
                            <Link className="btn btn-square btn-outline-light me-0" to="/"><i
                                className="fab fa-linkedin-in"></i></Link>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    );
}