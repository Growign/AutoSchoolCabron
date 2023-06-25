import React, {useEffect, useState} from "react";
import {Button, Navbar, Container} from "react-bootstrap";
import {NavLink, Link} from "react-router-dom";
import "../css/Navbar.css"
import getRefreshTokens from "../hooks/getRefreshTokens";

export default function NavBar() {

    const [userInfo, setUserInfo] = useState(302);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        const fetchUserInfo = async () => {
            const data = await fetch(`http://localhost:8080/api/v1/check-auth`, {credentials: 'include'});
            if (!data.redirected) {
                setUserInfo(data);
            } else if (await getRefreshTokens() === true) {
                setUserInfo(data);
            }
            if (await data.text() === "ADMIN") {
                setIsLoading(false);
            }
        };
        fetchUserInfo();
    }, []);

    return (
        <header>
            <Navbar className="navbar navbar-expand-lg navbar-light sticky-top p-0 navbar-greyp" variant="dark"
                    expand="lg">
                <Container>
                    <NavLink className={"py-4 px-lg-5 me-2 align-items-center l-height navbar-brand"} to="/">
                        <h2 className={"me-0 fa logo-text font-6"}><i className="fa fa-car text-warning me-2"></i>Carbon
                        </h2></NavLink>
                    <div className={"ms-auto"}>
                        <Navbar.Toggle className={"ms-auto"} aria-controls="basic-navbar-nav"/>
                    </div>
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Container className={"p-0"}>
                            <div className="navbar-nav p-lg-0">
                                <NavLink className={"nav-item nav-link"} to="/">Home</NavLink>
                                <NavLink className={"nav-item nav-link"} to="/courses">Courses</NavLink>
                                <NavLink className={"nav-item nav-link"} to="/quiz">Quiz</NavLink>
                                <NavLink className={"nav-item nav-link"} to="/about">About</NavLink>
                                <NavLink className={"nav-item nav-link"} to="/teachers">Вчителі</NavLink>
                                {!isLoading ?
                                    <NavLink className={"nav-item nav-link"} to="/admin">Admin</NavLink>
                                    :
                                    <></>
                                }
                            </div>
                        </Container>
                    </Navbar.Collapse>
                    <div className={"ps-2 mx-2"}>
                        {userInfo.status === 200 ?
                            <Link to={"/profile"}>
                                <Button variant={"light"}
                                        className={"loggin-btn btn btn-warning px-lg-5 btn"}
                                >Profile</Button>
                            </Link>
                            :
                            <Link to={"/login"}>
                                <Button variant={"light"}
                                        className={"loggin-btn btn btn-warning px-lg-5 btn"}
                                >Login</Button>
                            </Link>
                        }
                    </div>
                </Container>
            </Navbar>
        </header>
    );
}