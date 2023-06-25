import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import './index.css';
import MainPage from "./pages/main";
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import RootLayout from "./Components/layout/RootLayout";
import ErrorPage from "./pages/errorPage";
import AuthenticationPage from "./pages/authenticationPage";
import CoursesGrid from "./Components/CoursesPage/CoursesGrid";
import Profile from "./Components/ProfilePage/Profile";
import RequireAuth from "./hooks/requireAuth";
import QuizPage from "./pages/quizPage";
import ActivePage from "./pages/activePage";
import AdminPage from "./pages/adminPage";
import AboutUsPage from "./pages/aboutUsPage";
import TeachersPage from "./pages/teachersPage";


const router = createBrowserRouter([
    {
        path: "/",
        element: <RootLayout/>,
        errorElement: <ErrorPage/>,
        children: [
            {
                path: "/",
                element: <MainPage/>
            },
            {
                path:"mistake",
                element: <ErrorPage/>
            },
            {
                path: "courses",
                element: <CoursesGrid/>
            },
            {
                path: "about",
                element: <AboutUsPage/>
            },
            {
                path: "login",
                element: <AuthenticationPage/>
            },
            {
                path: "sign-up",
                element: <AuthenticationPage/>
            },
            {
                path: "activate",
                element: <ActivePage/>
            },
            {
                path: "profile",
                element: <RequireAuth url={"profile"}/>,
                children: [
                    {
                        path: "",
                        element: <Profile/>,
                    },
                ]
            },
            {
                path: "quiz",
                element: <QuizPage/>
            },
            {
                path: "teachers",
                element: <TeachersPage/>
            },
            {
                path: "admin",
                element: <RequireAuth url={"admin"}/>,
                children: [
                    {
                        path: "",
                        element: <AdminPage/>,
                    },
                ]
            }
        ]
    },
]);

export default function App() {
    return (
        <RouterProvider router={router}/>
    )
};
