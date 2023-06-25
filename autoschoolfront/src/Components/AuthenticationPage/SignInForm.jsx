import React, {useState} from "react";
import {Link} from "react-router-dom";
import "../../css/Authentication.css";
import axios from "axios";


function SignInForm() {

    const [state, setState] = useState({
        email: "",
        password: ""
    })

    const handleChange = async (event) => {
        const {id, value} = event.target
        setState(prevState => ({
            ...prevState,
            [id]: value
        }))
    }

    const handleSubmit = async (event) => {
        event.preventDefault();
        axios.post("http://localhost:8080/api/v1/authenticate", state, {withCredentials: true})
            .then(res => {
                    window.location.href = "/profile"
                }
            )
    }

    return (
        <div className="formCenter">
            <form className="formFields w-75 m-auto" onSubmit={handleSubmit}>
                <div className="formField">
                    <label className="formFieldLabel" htmlFor="email">
                        E-Mail Address
                    </label>
                    <input
                        type="email"
                        id="email"
                        className="formFieldInput"
                        placeholder="Enter your email"
                        name="email"
                        value={state.email}
                        onChange={handleChange}
                    />
                </div>

                <div className="formField">
                    <label className="formFieldLabel" htmlFor="password">
                        Password
                    </label>
                    <input
                        type="password"
                        id="password"
                        className="formFieldInput"
                        placeholder="Enter your password"
                        name="password"
                        value={state.password}
                        onChange={handleChange}
                    />
                </div>

                <div className="formField buttonWithText justify-content-center">
                    <div className="w-100">
                        <button className="formFieldButton justify-content-center">Sign In</button>
                    </div>
                    <p className="textOr">Or</p>
                    <Link to="/sign-up" className="formFieldLink text-center">
                        Create an account
                    </Link>
                </div>
            </form>
        </div>
    );
}

export default SignInForm;
