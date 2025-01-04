import React from 'react';
import ReactDOM from "react-dom/client";

import { createBrowserRouter, Outlet, RouterProvider } from 'react-router-dom';
import { createTheme, ThemeProvider, CssBaseline, } from '@mui/material';

import AdminNavigation from "./components/navigation/AdminNavigation"
import Navigation from "./components/navigation/Navigation"

import BikesAdminViewPage from 'bikes/ViewPage'
import BikeCreatePage from 'bikes/CreatePage'
import BikeUpdatePage from 'bikes/UpdatePage'
import BikesUserViewPage from 'bikes/UserViewPage';

import UsersAdminViewPage from 'users/ViewPage'
import UsersCreatePage from 'users/CreatePage'
import UsersUpdatePage from 'users/UpdatePage'
import LoginPage from 'users/LoginPage'
import RegisterPage from 'users/RegisterPage'

import UserViewPage from 'stations/UserViewPage';
import StationsAdminViewPage from 'stations/ViewPage'
import StationsCreatePage from 'stations/CreatePage'
import StationsUpdatePage from 'stations/UpdatePage'

import RentProvider from 'host/RentProvider';
import AuthProvider from 'host/AuthProvider';
import ProtectedRoute from './components/ProtectedRoute';

const App = () => {
    const theme = createTheme({
        palette: {
            primary: {
                main: "#2e7d32"
            },
            secondary: {
                main: "#fff"
            },
            text: {
                primary: "#2e7d32",
                secondary: "rgba(0, 0, 0, 0.6)",
            }
        },
        typography: {
            fontFamily: [
                "Geist, seriff"
            ],
        },
        components: {
            MuiTextField: {
                defaultProps: {
                    fullWidth: true,
                    color: "primary"
                }
            },
            MuiButton: {
                defaultProps: {
                    variant: "contained",
                },
                styleOverrides: {
                    root: {
                        textTransform: "none",
                    }
                }
            },
            MuiTableHead: {
                styleOverrides: {
                    root: {
                        backgroundColor: "#2e7d32",
                        textTransform: "uppercase",
                        "& th":{
                            color: "white"
                        }
                    },
                }
            },
            MuiTableCell: {
                styleOverrides: {
                    root: {
                        textAlign: "center",
                    }
                }
            },
            MuiCssBaseline: {
                styleOverrides: {
                    body: {
                        boxSizing: 'border-box',
                        margin: 0
                    },
                    "#app": {
                        height: "100vh",
                        maxWidth: "1200px",
                        margin: "auto",
                        padding: "24px",
                        display: "flex",
                        flexDirection: "column",
                        justifyContent: "space-between",

                    }
                }
            }

        },
    });

    const Layout = () => (
        <ThemeProvider theme={theme}>
            <CssBaseline />
            <ProtectedRoute />
        </ThemeProvider>

    )

    const StartLayout = () => (
        <ThemeProvider theme={theme}>
            <CssBaseline />
            <Outlet />
        </ThemeProvider>
    )

    const router = createBrowserRouter([
        {
            element: <StartLayout />,
            errorElement: <p>Error</p>,
            children: [
                {
                    path: "login",
                    element: <LoginPage />
                },
                {
                    path: "register",
                    element: <RegisterPage />
                },
            ]

        },
        {
            element: <Layout />,
            errorElement: <p>error</p>,
            children: [
                {
                    path: "",
                    element:
                        <>
                            <UserViewPage bikes={BikesUserViewPage} />
                            <Navigation />
                        </>

                },
                {
                    path: "user/:id",
                    element:
                        <>
                            <UsersUpdatePage />
                            <Navigation />
                        </>
                },
                {
                    path: "admin",
                    children: [
                        {
                            path: "users",
                            children: [
                                {
                                    path: "",
                                    element:
                                        <>
                                            <UsersAdminViewPage />
                                            <AdminNavigation />
                                        </>
                                },
                                {
                                    path: "create",
                                    element:
                                        <>
                                            <UsersCreatePage />
                                            <AdminNavigation />
                                        </>
                                },
                                {
                                    path: "edit/:id",
                                    element:
                                        <>
                                            <UsersUpdatePage />
                                            <AdminNavigation />
                                        </>

                                }
                            ]
                        },
                        {
                            path: "bikes",
                            children: [
                                {
                                    path: "",
                                    element:
                                        <>
                                            <BikesAdminViewPage />
                                            <AdminNavigation />
                                        </>
                                },
                                {
                                    path: "create",
                                    element:
                                        <>
                                            <BikeCreatePage />
                                            <AdminNavigation />
                                        </>
                                },
                                {
                                    path: "edit/:id",
                                    element:
                                        <>
                                            <BikeUpdatePage />
                                            <AdminNavigation />
                                        </>
                                }
                            ]
                        },
                        {
                            path: "stations",
                            children: [
                                {
                                    path: "",
                                    element:
                                        <>
                                            <StationsAdminViewPage />
                                            <AdminNavigation />
                                        </>
                                },
                                {
                                    path: "create",
                                    element:
                                        <>
                                            <StationsCreatePage />
                                            <AdminNavigation />
                                        </>
                                },
                                {
                                    path: "edit/:id",
                                    element:
                                        <>
                                            <StationsUpdatePage />
                                            <AdminNavigation />
                                        </>
                                }
                            ]
                        }
                    ]
                },

            ]
        },
    ])
    return (
        <AuthProvider>
            <RentProvider>
                <RouterProvider router={router} />
            </RentProvider>
        </AuthProvider>

    )
}


ReactDOM.createRoot(document.getElementById('app')).render(
    <App />
)
