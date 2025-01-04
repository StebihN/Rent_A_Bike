import { useState } from 'react';
import { Link } from 'react-router-dom';

import { createUser } from '../api/service';

import { Paper, Typography, Stack } from '@mui/material';
import Grid from '@mui/material/Grid2';

import FeedbackSnackbar from '../components/FeedbackSnackbar';
import UserForm from '../components/forms/UserForm';

import DirectionsBikeIcon from '@mui/icons-material/DirectionsBike';
import LoginIcon from '@mui/icons-material/Login';

export default function RegisterPage() {
    const [snack, setSnack] = useState({ open: false, text: "", severity: "" })

    const handleSubmit = (user) => {
        createUser(user)
            .then((result) => {
                setSnack({ open: true, text: "Sign up successful", severity: "success" })
            })
            .catch((err) => {
                if (err.response.status === 412) {
                    setSnack({ open: true, text: "User with this email already exists", severity: "error" })
                } else {
                    setSnack({ open: true, text: "An Error occured, try again!", severity: "error" })
                }
            });
    }

    return (
        <Grid container component={Paper} marginBlock={"auto"} textAlign={"center"} height={800}>
            <Grid size={7} padding={3} bgcolor={"primary.main"} color={"secondary.main"} alignContent={"center"}>
                <DirectionsBikeIcon sx={{ fontSize: "12rem" }} />
                <Typography variant={'h1'}>Rent-A-Bike</Typography>
            </Grid>
            <Grid size={5} padding={3} component={Stack} justifyContent={"space-around"}>
                <Typography variant={'h2'}>Sign up</Typography>
                <UserForm onSubmit={handleSubmit} submitText={"Sign up"} submitIcon={<LoginIcon />} fields={{ name: true, surname: true, email: true, password: true }} />
                <Typography>Have an account <Link to="/login">Log in</Link></Typography>
            </Grid>
            <FeedbackSnackbar severity={snack.severity} setOpen={setSnack} open={snack.open}>{snack.text}</FeedbackSnackbar>
        </Grid>
    )
}