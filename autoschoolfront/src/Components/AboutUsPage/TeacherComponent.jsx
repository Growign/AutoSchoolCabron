import React, {Fragment, useEffect, useState} from "react";
import axios from "axios";
import "../../css/multipleSelect.css"

export default function TeacherComponent() {
    //LOAD
    const [isLoading, setIsLoading] = useState(true);
    const [isAdmin, setIsAdmin] = useState(false);
    const [isPracticalTeacherLoading, setPracticalTeacherIsLoading] = useState(true);
    //CHANGE
    const [theoryTeacherChanges, setTheoryTeacherChanges] = useState([]);
    const [isTheoryTeacherEditMode, setTheoryTeacherIsEditMode] = useState(false);
    const [practicalTeacherChanges, setPracticalTeacherChanges] = useState([]);
    const [isPracticalTeacherEditMode, setPracticalTeacherIsEditMode] = useState(false);
    //GET
    const [teachers, setTeachers] = useState([]);
    const [practicalTeachers, setPracticalTeachers] = useState([]);

    const fetchUsersData = async () => {
        try {
            const response = await axios.get("http://localhost:8080/TheoryTeacher?sort=Id", {withCredentials: true});
            if (response.status === 200) {
                setTeachers(response.data);
                setIsLoading(false);
            }
        } catch (e) {
            console.error(e);
        }
    };
    const fetchPracticalTeacherData = async () => {
        try {
            const response = await axios.get("http://localhost:8080/practicalTeachers?sort=Id", {withCredentials: true});
            if (response.status === 200) {
                setPracticalTeachers(response.data);
                setPracticalTeacherIsLoading(false);
            }
        } catch (e) {
            console.error(e);
        }
    };
    useEffect(() => {
        const fetchUserInfo = async () => {
            const data = await fetch(`http://localhost:8080/api/v1/check-auth`, {credentials: 'include'});
            if (await data.text() === "ADMIN") {
                console.log(isAdmin)
                setIsAdmin(true);
            }
        };
        fetchUserInfo();
    }, []);
    useEffect(() => {
            fetchUsersData();
            fetchPracticalTeacherData();
        }, // eslint-disable-next-line
        []);
    useEffect(() => {
    }, [theoryTeacherChanges, isTheoryTeacherEditMode]);
    useEffect(() => {
        if (isPracticalTeacherEditMode) {
            let multiselect_block = document.querySelectorAll(".multiselect_block");
            multiselect_block.forEach((parent) => {
                let label = parent.querySelector(".field_multiselect");
                let select = parent.querySelector(".field_select");
                let text = label.innerHTML;
                select.addEventListener("change", function (element) {
                    let selectedOptions = this.selectedOptions;
                    label.innerHTML = "";
                    for (let option of selectedOptions) {
                        let button = document.createElement("button");
                        button.type = "button";
                        button.className = "btn_multiselect";
                        button.textContent = option.text;
                        button.onclick = (_) => {
                            option.selected = false;
                            button.remove();
                            if (!select.selectedOptions.length) {
                                label.innerHTML = text;
                            }
                        };
                        label.append(button);
                    }
                });
            });
        }
    }, [practicalTeacherChanges, isPracticalTeacherEditMode]);
    const handleTheoryTeacherEditButton = () => {
        setTheoryTeacherIsEditMode(!isTheoryTeacherEditMode);
    }
    const handleChangeTheory = (userId) => (event) => {
        const {name, value} = event.target;
        setTheoryTeacherChanges((prevChanges) => ({
            ...prevChanges,
            [userId]: {
                ...prevChanges[userId],
                [name]: value,
            },
        }));
    };
    const updateTheoryTeacher = (teacherId, theoryTeacherChanges) => {
        fetch(`http://localhost:8080/TheoryTeacher/${teacherId}`, {
            credentials: 'include',
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(theoryTeacherChanges)
        })
            .then()
            .catch((error) => {
                console.error('Error:', error);
            });
    }
    const handleTheoryTeacherSaveButton = () => {
        // eslint-disable-next-line
        const updatePromises = Object.keys(theoryTeacherChanges).map(teacher => {
            return updateTheoryTeacher(teacher, theoryTeacherChanges[teacher]);
        });
        try {
            Promise.all(updatePromises);
        } catch (error) {
        }
        window.location.reload()
    }
    const handlePracticalTeacherEditButton = () => {
        setPracticalTeacherIsEditMode(!isPracticalTeacherEditMode);
    }
    const handleChangePractical = (teacherId) => (event) => {
        const {name, value} = event.target;
        setPracticalTeacherChanges((prevChanges) => ({
            ...prevChanges,
            [teacherId]: {
                ...prevChanges[teacherId],
                [name]: value,
            },
        }));
    };
    const updatePracticalTeacher = (teacherId, practicalTeachers) => {
        fetch(`http://localhost:8080/practicalTeachers/${teacherId}`, {
            credentials: 'include',
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(practicalTeachers)
        }).then()
            .catch((error) => {
                console.error('Error:', error);
            });
    }
    const handlePracticalTeacherSaveButton = () => {
        // eslint-disable-next-line
        const updatePromises = Object.keys(practicalTeacherChanges).map(teacher => {
            return updatePracticalTeacher(teacher, practicalTeacherChanges[teacher]);
        });
        try {
            Promise.all(updatePromises);
        } catch (error) {
        }
        window.location.reload()
    }
    const handleChangeOption = (teacherId) => (event) => {
        const selectedOptions = Array.from(event.target.selectedOptions).map(
            (option) => option.value
        );
        setPracticalTeacherChanges((prevChanges) => ({
            ...prevChanges,
            [teacherId]: {
                ...prevChanges[teacherId],
                categoryIds: selectedOptions,
            },
        }));
    }

    return (
        <>
            <h2 className={"text-center font-6 mt-3"}>Вчителі теорії</h2>
            {isAdmin ? <>
                <div style={{"paddingLeft": "18%"}}>
                    <button className={isTheoryTeacherEditMode ? "btn-success btn" : "btn-success btn d-none"}
                            style={{"padding": "1% 4%", "marginBottom": "10px", "float": "left"}}
                            onClick={handleTheoryTeacherSaveButton}>Зберегти
                    </button>
                </div>
                <div style={{"paddingLeft": "18%"}}>
                    <button className={isTheoryTeacherEditMode ? "btn-danger btn" : "btn-warning btn"}
                            style={{"padding": "1% 4%", "marginBottom": "10px", "marginLeft": "10px"}}
                            onClick={handleTheoryTeacherEditButton}>{isTheoryTeacherEditMode ? "Відмінити" : "Редагувати"}</button>
                </div>
            </> : <></>
            }
            <div className="table">
                <table style={{"margin": "auto", "borderCollapse": "initial"}}>
                    <thead>
                    <tr>
                        <th>№</th>
                        <th>Прізвище</th>
                        <th>Ім'я</th>
                    </tr>
                    </thead>
                    {isLoading === true ? <p>Завантаження...</p>
                        :
                        <tbody className="tbody">
                        {teachers.content.map((teacher, index) => (
                            <tr key={index}>
                                <td>{teacher.id}</td>
                                <td>{
                                    isTheoryTeacherEditMode ?
                                        <input type="text" id="surname" className="userDataInput"
                                               style={{"borderColor": "#ffc107", "width": "100%"}}
                                               placeholder="Edit your surname" name="surname"
                                               value={theoryTeacherChanges[teacher.id]?.surname || teacher.surname}
                                               onChange={handleChangeTheory(teacher.id)}/> : teacher.surname}</td>
                                <td>{
                                    isTheoryTeacherEditMode ?
                                        <input type="text" id="surname" className="userDataInput"
                                               style={{"borderColor": "#ffc107", "width": "100%"}}
                                               placeholder="Edit your name" name="name"
                                               value={theoryTeacherChanges[teacher.id]?.name || teacher.name}
                                               onChange={handleChangeTheory(teacher.id)}/> : teacher.name}</td>
                            </tr>
                        ))}
                        </tbody>
                    }
                </table>
            </div>
            <h2 className={"text-center font-6 mt-5"}>Вчителі Практики</h2>
            {isAdmin ? <>
                <div style={{"paddingLeft": "18%"}}>
                    <button className={isPracticalTeacherEditMode ? "btn-success btn" : "btn-success btn d-none"}
                            style={{"padding": "1% 4%", "marginBottom": "10px", "float": "left"}}
                            onClick={handlePracticalTeacherSaveButton}>Зберегти
                    </button>
                </div>
                <div style={{"paddingLeft": "18%"}}>
                    <button className={isPracticalTeacherEditMode ? "btn-danger btn" : "btn-warning btn"}
                            style={{"padding": "1% 4%", "marginBottom": "10px", "marginLeft": "10px"}}
                            onClick={handlePracticalTeacherEditButton}>{isPracticalTeacherEditMode ? "Відмінити" : "Редагувати"}</button>
                </div>
            </> : <></>}
            <div className="table">
                <table className={"mb-5"} style={{"margin": "auto", "borderCollapse": "initial"}}>
                    <thead>
                    <tr>
                        <th>№</th>
                        <th>Прізвище</th>
                        <th>Ім'я</th>
                        <th>Категорія</th>
                        <th>Машина</th>
                    </tr>
                    </thead>
                    {isPracticalTeacherLoading === true ? <p>Завантаження...</p>
                        :
                        <tbody className="tbody">
                        {practicalTeachers.content.map((teacher, index) => (
                            <tr key={index}>
                                <td>{teacher.id}</td>
                                <td>{isPracticalTeacherEditMode ?
                                    <input type="text" id="surname" className="userDataInput"
                                           style={{"borderColor": "#ffc107", "width": "100%"}}
                                           placeholder="Edit your surname" name="surname"
                                           value={practicalTeacherChanges[teacher.id]?.surname || teacher.surname}
                                           onChange={handleChangePractical(teacher.id)}/> : teacher.surname}</td>
                                <td>{isPracticalTeacherEditMode ?
                                    <input type="text" id="name" className="userDataInput"
                                           style={{"borderColor": "#ffc107", "width": "100%"}}
                                           placeholder="Edit your name" name="name"
                                           value={practicalTeacherChanges[teacher.id]?.name || teacher.name}
                                           onChange={handleChangePractical(teacher.id)}/> : teacher.name}</td>
                                <td>{isPracticalTeacherEditMode ?
                                    <div className="form_label">
                                        <div className="multiselect_block">
                                            <label htmlFor="select-1"
                                                   className="field_multiselect">Категорія</label>
                                            <input id="checkbox-1" className="multiselect_checkbox"
                                                   type="checkbox"/>
                                            <label htmlFor="checkbox-1" className="multiselect_label"></label>
                                            <select multiple className="field_select" id="categoryIds"
                                                    name="categoryIds"
                                                    defaultValue={
                                                        teacher.categories.map((category) => category.id)
                                                    }
                                                    onChange={handleChangeOption(teacher.id)}>
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
                                    </div>
                                    :
                                    teacher.categories.map((category, index) => (
                                        <Fragment key={index}>"{category.category}" </Fragment>))}</td>
                                <td>{teacher.cars.map((car, index) => (
                                    <Fragment key={index}>"{car.brand} {car.model}" </Fragment>))}</td>
                            </tr>
                        ))}
                        </tbody>
                    }
                </table>
            </div>
        </>
    );
}