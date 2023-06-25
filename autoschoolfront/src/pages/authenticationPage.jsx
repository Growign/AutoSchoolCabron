import React from "react";
import {NavLink} from "react-router-dom";
import SignInForm from "../Components/AuthenticationPage/SignInForm";
import SignUpForm from "../Components/AuthenticationPage/SignUpForm";

export default function AuthenticationPage() {
    return (
        <div className="container blank my-5">
            <div className="appForm">
                <div className="pageSwitcher justify-content-center">
                    <NavLink
                        to="/login"
                        className="pageSwitcherItem"
                    >
                        Sign In
                    </NavLink>
                    <NavLink
                        to="/sign-up"
                        className="pageSwitcherItem"
                    >
                        Sign Up
                    </NavLink>
                </div>
                    {window.location.pathname === "/login" ? <SignInForm/> : <SignUpForm/>}
            </div>
        </div>
    );
}