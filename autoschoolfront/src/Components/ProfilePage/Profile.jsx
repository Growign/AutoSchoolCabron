import React, {useEffect, useState} from "react";
import "../../css/profile.css";

export default function Profile() {

    const [userInfo, setUserInfo] = useState();

    const [isEditMode, setIsEditMode] = useState(false);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
            const fetchUserInfo = async () => {
                const response = await fetch(`http://localhost:8080/userData`, {credentials: 'include'});
                const data = await response.json();
                setUserInfo(data);
                setIsLoading(false);
            };
            fetchUserInfo();
        }, // eslint-disable-next-line
        []);

    const handleEditButton = () => {
        setIsEditMode(!isEditMode);
    }

    const handleUpdateUserData = async () => {
        fetch(`http://localhost:8080/student/${userInfo.id}`, {
            credentials: 'include',
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userInfo)
        })
            .then(window.location.reload())
            .catch((error) => {
                console.error('Error:', error);
            });
    }

    const handleCancelButton = ()=>{
        window.location.reload();
    }
    const handleChange = async (event) => {
        const value = event.target.type === 'number' ? parseInt(event.target.value) : event.target.value;
        setUserInfo({
            ...userInfo,
            [event.target.name]: value
        });
    }

    return (
        <div className="container py-5">
            <h1 className="display-6 mb-2 text-center">My profile</h1>
            <h2 className="mb-2 text-center">Self data</h2>
            <div className="row g-5 max-size m-auto">
                <div className="col-lg-6">
                    <div className="position-relative">
                        <div className="p-2" style={{"borderRadius": "30px"}}>
                            <button className="btn btn-warning w-100 d-flex mb-2">
                                <div>
                                    Category:
                                </div>
                                {isLoading ? <div>Loading...</div> :
                                    <div>
                                        {userInfo.categories[0]}
                                    </div>
                                }
                            </button>
                            <button className="btn btn-warning w-100 d-flex mb-2">
                                <div>
                                    Age:
                                </div>
                                {isLoading ? <div>Loading...</div> :
                                    isEditMode ?
                                        <input type="number" id="age" className="userDataInput"
                                               style={{"width": "20%", "color": "white", "borderColor": "white"}}
                                               placeholder="Edit your  age" name="age"
                                               value={userInfo.age} onChange={handleChange}
                                        />
                                        :
                                        <div>
                                            {userInfo.age}
                                        </div>
                                }
                            </button>
                        </div>
                    </div>
                </div>
                <div className="col-lg-6">
                    <div className="position-relative">
                        <div className="d-flex text-decoration-none text-black">
                            {/*<div className={"userIcon"}>*/}
                            {/*    <svg width="71" height="71">*/}
                            {/*        <rect fill="#fc0"*/}
                            {/*              width="71"*/}
                            {/*              height="71"/>*/}
                            {/*        <line stroke="white"*/}
                            {/*              x1="0" y1="0"*/}
                            {/*              x2="20" y2="20"/>*/}
                            {/*    </svg>*/}
                            {/*</div>*/}
                            <div>
                                {
                                    isEditMode ? <><label className="userDataSurname" htmlFor="surname">
                                            Прізвище
                                        </label>
                                            <label className="userDataName" htmlFor="name">
                                                Ім'я
                                            </label>
                                            <input type="text" id="surname" className="userDataInput"
                                                   style={{"width": "47%"}}
                                                   placeholder="Edit your Surname" name="surname"
                                                   value={userInfo.surname} onChange={handleChange}
                                            />
                                            <input type="text" id="name" className="userDataInput"
                                                   style={{"width": "46%", "marginLeft": "6%"}}
                                                   placeholder="Edit your Name" name="name"
                                                   value={userInfo.name} onChange={handleChange}
                                            /></> :
                                        <span className={"display-6 font-4"}
                                              style={{"fontSize": "26px"}}>{isLoading ?
                                            <div>Loading...</div> : userInfo.surname + " " + userInfo.name}</span>
                                }
                                {
                                    isEditMode ?
                                        <>
                                            <div>
                                                <button
                                                    className={isEditMode ? "btn-success btn" : "btn-success btn d-none"}
                                                    style={{"padding": "2% 5%", "marginTop": "10px", "float": "left"}}
                                                    onClick={handleUpdateUserData}>Save
                                                </button>
                                            </div>
                                            <div>
                                                <button className={isEditMode ? "btn-danger btn" : "btn-warning btn"}
                                                        style={{
                                                            "padding": "2% 5%",
                                                            "marginTop": "10px",
                                                            "marginLeft": "10px"
                                                        }}
                                                        onClick={handleCancelButton}>{"Cancel"}</button>
                                            </div>
                                        </>
                                        :
                                        <button className={"btn editProfile"} style={{"padding": "0px"}}
                                                onClick={handleEditButton}>Edit profile
                                        </button>
                                }
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}
