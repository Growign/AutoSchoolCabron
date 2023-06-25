import React from "react";
import Slider from "../Components/MainPage/Slider";
import AboutUs from "../Components/MainPage/AboutUs";
import AboutCourses from "../Components/MainPage/AboutCourses";
export default function MainPage(){
    return (
        <>
            <Slider/>
            <AboutUs/>
            <AboutCourses/>
        </>
    );
}