import { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';

import { loginUser } from '../api/service';
import { useAuth } from 'host/AuthProvider';

import { Paper, Typography, Stack } from '@mui/material';
import Grid from '@mui/material/Grid2';

import UserForm from '../components/forms/UserForm';
import FeedbackSnackbar from '../components/FeedbackSnackbar';

import DirectionsBikeIcon from '@mui/icons-material/DirectionsBike';
import LoginIcon from '@mui/icons-material/Login';

export default function LoginPage() {
    const [snack, setSnack] = useState({ open: false, text: "", severity: "" })

    const { setToken } = useAuth()
    const navigate = useNavigate()

    const handleSubmit = async (user) => {
        try {
            const response = await loginUser(user)
            setSnack({ open: true, text: "Prijava uspešna", severity: "success" })
            setToken(response.token)
            navigate("/")
        } catch (error) {
            if (error.response.status === 401) {
                setSnack({ open: true, text: "Email or password wrong", severity: "error" })
            }
            else if (error.response.status === 404) {
                setSnack({ open: true, text: "User with provided credentials doesn't exist", severity: "error" })
            }
            else {
                setSnack({ open: true, text: "An Error occured during login, please try again later!", severity: "error" })
            }
        }
    }

    return (
        <Grid container component={Paper} marginBlock={"auto"} textAlign={"center"} height={800}>
            <Grid size={7} padding={3} bgcolor={"primary.main"} color={"secondary.main"} alignContent={"center"}>
                <DirectionsBikeIcon sx={{ fontSize: "12rem" }} />
                <Typography variant={'h1'}>Rent-A-Bike</Typography>
            </Grid>
            <Grid size={5} padding={3} component={Stack} justifyContent={"space-around"}>
                <Typography variant={'h2'}>Login</Typography>
                <UserForm onSubmit={handleSubmit} submitText={"Login"} submitIcon={<LoginIcon />} fields={{ email: true, password: true }} />
                <Typography>Don't have an account? <Link to={"/register"}>Sign up</Link></Typography>
            </Grid>
            <FeedbackSnackbar severity={snack.severity} setOpen={setSnack} open={snack.open}>{snack.text}</FeedbackSnackbar>
        </Grid>
    )
}