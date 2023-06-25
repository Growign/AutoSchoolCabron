import React from "react";
import "bootstrap/dist/css/bootstrap.min.css"
import "animate.css"

export default function AboutUs() {
    return (
        <div className={"container-xxl py-3"}>
            <div className={"container"}>
                <div className={"row g-5"}>
                    <h2 className={"text-center"}>About Us</h2>
                    <p>
                        Welcome to Carbon, your premier destination for comprehensive and professional
                        driver education. With a passion for safe and confident driving, we are dedicated to providing
                        top-notch instruction to aspiring drivers of all ages and experience levels.

                        At Carbon, we understand that learning to drive is a milestone in everyone's
                        life. That's why we strive to create a supportive and empowering learning environment, where our
                        students can gain the knowledge, skills, and confidence needed to become responsible drivers for
                        a lifetime.
                    </p>
                    <h4 className={"text-center"} style={{"color":"#ffc107"}}>Why Choose Us?</h4>
                    <ul>
                        <li style={{"color":"black", "marginBottom":"1%"}}>
                            Experienced and Certified Instructors: Our team of highly skilled and certified driving
                            instructors
                            brings a wealth of knowledge and expertise to every lesson. They are not only experts in the
                            rules
                            of the road but also possess exceptional teaching abilities, ensuring that each student
                            receives
                            personalized attention and guidance.
                        </li>
                        <li style={{"color":"black", "marginBottom":"1%"}}>
                            Comprehensive Curriculum: We offer a comprehensive curriculum designed to cover all aspects
                            of safe
                            and defensive driving techniques. From classroom sessions to behind-the-wheel training, we
                            equip our
                            students with the necessary skills to navigate any driving situation with confidence.
                        </li>
                        <li style={{"color":"black", "marginBottom":"1%"}}>
                            State-of-the-Art Facilities: Our driving school is equipped with state-of-the-art facilities
                            and
                            modern training vehicles, featuring the latest safety features. We believe that learning in
                            a
                            comfortable and technologically advanced environment enhances the learning experience and
                            prepares
                            our students for real-world driving scenarios.
                        </li>
                        <li style={{"color":"black", "marginBottom":"1%"}}>
                            Flexibility and Convenience: We understand that life can be busy, which is why we offer
                            flexible
                            scheduling options to accommodate our students' needs. Whether you're a high school student,
                            working
                            professional, or a senior citizen, we have classes and lesson times to fit your schedule.
                        </li>
                        <li style={{"color":"black", "marginBottom":"1%"}}>
                            Exceptional Customer Service: Providing outstanding customer service is our top priority.
                            Our
                            friendly and knowledgeable staff is here to assist you throughout your journey, from
                            answering your
                            questions to helping you with the enrollment process. We are committed to ensuring your
                            experience
                            with us is positive and rewarding.
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    );
}