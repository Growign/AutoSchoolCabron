import React, {useState} from "react";
import {Link} from "react-router-dom";
import "../../css/Authentication.css";
import axios from "axios";

export default function SignUpForm() {
    const [state, setState] = useState({
        email: "",
        password: "",
        ConfirmPassword: "",
        hasAgreed: false,
        hasPosted: false
    })

    const handleChange = async (event) => {
        const {name, value, type, checked} = event.target;
        setState(prevState => ({
            ...prevState,
            [name]: type === "checkbox" ? checked : value
        }));
    }
    const handleSubmit = async (event) => {
        event.preventDefault();
        if (state.hasAgreed === true && state.password === state.ConfirmPassword) {
            let register = await axios.post("http://localhost:8080/api/v1/register", state, {withCredentials: true});
            if(register.status === 200){
                setState({...state, hasPosted: true});
            }
        }else{
            console.log("зробити чернову плашку")
        }
    }

    if(state.hasPosted){
        return <div className={"m-auto text-center bg-success"} style={{"borderRadius":"20px","maxWidth":"280px"}}>
            <p style={{"color":"white", "marginBottom":"0px","paddingTop":"10px"}}>Please verify your account!</p>
            <p style={{"color":"white","paddingBottom":"10px"}}>Check email</p></div>
    }

    return (
        <div className="formCenter">
            <form onSubmit={handleSubmit} className="formFields w-75 m-auto">
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
                        minLength={5}
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
                        minLength={4}
                    />
                </div>
                <div className="formField">
                    <label className="formFieldLabel" htmlFor="ConfirmPassword">
                        Confirm password
                    </label>
                    <input
                        type="password"
                        id="ConfirmPassword"
                        className="formFieldInput"
                        placeholder="Enter your password again"
                        name="ConfirmPassword"
                        value={state.ConfirmPassword}
                        onChange={handleChange}
                        minLength={4}
                    />
                </div>
                <div className="formField" style={{"marginBottom": "25px"}}>
                    <label className="formFieldCheckboxLabel">
                        <input
                            className="formFieldCheckbox"
                            type="checkbox"
                            name="hasAgreed"
                            value={state.hasAgreed}
                            onChange={handleChange}
                        />
                        I agree all statements in{" "}
                        <Link to="null" className="formFieldTermsLink">
                            terms of service
                        </Link>
                    </label>
                </div>
                <div className="formField">
                    <button className="formFieldButton">Sign Up</button>
                </div>
            </form>
        </div>
    );
}
