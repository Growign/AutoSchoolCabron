import React, {useEffect, useState} from "react";
import axios from "axios";
import {useSearchParams} from "react-router-dom";

export default function ActiveComponent() {
    const [state, setState] = useState({
        name: "",
        surname: "",
        age: "",
        categoryIds: 0
    })
    const [searchParams] = useSearchParams();
    const [isActive, setIsActive] = useState(false);

    useEffect(() => {
            const fetchActivateCodeInfo = async () => {
                try {
                    await axios(`http://localhost:8080/api/v1/activate?activationCode=` + searchParams.get("activationCode"), {withCredentials: true});
                } catch (e) {
                    setIsActive(true);
                }
            }
            fetchActivateCodeInfo()
        }, // eslint-disable-next-line
        []);


    const handleChange = async (event) => {
        const value = event.target.type === 'number' ? parseInt(event.target.value) : event.target.value;
        setState({
            ...state,
            [event.target.name]: value
        });
    }
    const handleChangeOption = async (event) => {
        const value = event.target.id === 'categoryIds' ? [parseInt(event.target.value)] : event.target.value;
        setState({
            ...state,
            [event.target.name]: value
        });
    }
    const handleSubmit = async (event) => {
        event.preventDefault();
        if (state.age !== "" && state.lastname !== "" && state.categoryIds !== 0 && state.firstname !== "") {
            await axios.post("http://localhost:8080/api/v1/activate?activationCode=" + searchParams.get("activationCode"), state, {withCredentials: true})
                .then(res => {
                        window.location.href = "/profile"
                    }
                );
            //TODO: зробити переадресацію || виключити її і зробити кнопку?
        }
    }

    if (isActive) {
        return (
            <div className={"container text-center bg-danger"} style={{"borderRadius": "20px", "maxWidth": "380px","marginTop":"70px","marginBottom":"70px"}}>
                <p style={{"color": "white", "marginBottom": "0px", "paddingTop": "10px"}}>Link is not active</p>
                <p style={{"color": "white", "paddingBottom": "10px"}}></p></div>);
    }

    return (
        <div className="container blank my-5">
            <div className="appForm">
                <div className="formCenter">
                    <form onSubmit={handleSubmit} className="formFields w-75 m-auto">
                        <div className="formField ">
                            <label className="formFieldLabel" htmlFor="name">
                                First name
                            </label>
                            <input
                                type="text"
                                id="name"
                                className="formFieldInput"
                                placeholder="Enter your first name"
                                name="name"
                                value={state.name}
                                onChange={handleChange}
                                minLength={3}
                            />
                        </div>
                        <div className="formField">
                            <label className="formFieldLabel" htmlFor="surname">
                                Last Name
                            </label>
                            <input
                                type="text"
                                id="surname"
                                className="formFieldInput"
                                placeholder="Enter your last name"
                                name="surname"
                                value={state.surname}
                                onChange={handleChange}
                                minLength={3}
                            />
                        </div>
                        <div className="formField">
                            <label className="formFieldLabel" htmlFor="age">
                                Age
                            </label>
                            <input
                                type="number"
                                id="age"
                                className="formFieldInput"
                                placeholder="Enter your age"
                                name="age"
                                value={state.age}
                                onChange={handleChange}
                                minLength={4}
                            />
                        </div>
                        <div className="formField">
                            <label className="formFieldLabel" htmlFor="categoryIds">
                                Category
                            </label>
                            <select className="formFieldInput" id="categoryIds" name="categoryIds"
                                    value={state.categoryIds}
                                    onChange={handleChangeOption}>
                                <option value="">Select category</option>
                                <option value="1">A</option>
                                <option value="2">A1</option>
                                <option value="3">B</option>
                                <option value="4">B1</option>
                                <option value="5">C</option>
                                <option value="6">C1</option>
                                <option value="7">CE</option>
                                <option value="8">D</option>
                                <option value="9">DE</option>
                            </select>
                        </div>
                        <div className="formField">
                            <button className="formFieldButton">Active</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}