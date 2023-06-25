import React from "react";
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap-icons/font/bootstrap-icons.css"
import {Link} from "react-router-dom";
export default function ErrorPage(){
    return(
        <div className="container-xxl py-6 wow fadeInUp">
            <div className="container text-center">
                <div className="row justify-content-center">
                    <div className="col-lg-6 text-color-grey">
                        <i className="bi bi-exclamation-triangle display-1 primary"></i>
                        <h1 className="display-1"style={{"fontWeight":"700"}}>Error</h1>
                        <h1 className="mb-4 font-6">Something gone wrong...</h1>
                        <p className="mb-4 text-color-grey">We’re sorry, the page you have looked for does not exist in our website!
                            Maybe go to our home page or try to use a search?</p>
                        <Link className="btn btn-warning py-3 px-5" to="/">Go Back To Home</Link>
                    </div>
                </div>
            </div>
        </div>
    );
}