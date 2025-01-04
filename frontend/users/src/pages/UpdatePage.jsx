import { useState } from 'react';
import { useParams } from 'react-router-dom'
import { updatePassword, updateUser } from '../api/service';
import useUserById from '../hooks/useUserById';

import { Typography, Stack, Paper, IconButton } from '@mui/material';
import Grid from '@mui/material/Grid2';

import FeedbackSnackbar from '../components/FeedbackSnackbar';
import UserData from '../components/cards/UserData';
import UserForm from '../components/forms/UserForm';
import PasswordForm from '../components/forms/PasswordForm';

import ArrowCircleUpIcon from '@mui/icons-material/ArrowCircleUp';
import PersonIcon from '@mui/icons-material/Person';
import PasswordIcon from '@mui/icons-material/Password';


export default function UpdatePage() {
    const { id } = useParams()
    const { user } = useUserById(id)
    const [snack, setSnack] = useState({ open: false, text: "", severity: "" })

    const [tab, setTab] = useState(0)

    const handleChange = (value) => {
        setTab(value)
    }

    const handleSubmit = (updatedUser) => {
        updateUser(user.id, updatedUser).then(() => {
            setSnack({ open: true, text: "Profile update successful", severity: "success" })
        }).catch((err) => {
            if (err.response.status === 412) {
                setSnack({ open: true, text: "User with provided email already exists!", severity: "error" })
            } else {
                setSnack({ open: true, text: "An error occured, try again!", severity: "error" })
            }
        });
    }

    const handlePasswordSubmit = (updatedPassword) => {
        updatePassword(user.id, updatedPassword)
            .then(() => {
                setSnack({ open: true, text: "Password update successful", severity: "success" })
            })
            .catch((err) => {
                if (err.response.status === 401) {
                    setSnack({ open: true, text: "Wrong password!", severity: "error" })
                } else {
                    setSnack({ open: true, text: "An error occured, try again!", severity: "error" })
                }
            });
    }

    return user && (
        <Grid container component={Paper} textAlign={"center"} height={800}>
            <UserData user={user} />
            <Grid size={5} padding={3} component={Stack} justifyContent={"space-around"}>
                <div>
                    <Typography variant='h2'>Update profile</Typography>
                    <Stack direction={"row"} justifyContent={"center"}>
                        <IconButton onClick={() => handleChange(0)} color={tab == 0 ? "primary" : "default"}><PersonIcon /></IconButton>
                        <IconButton onClick={() => handleChange(1)} color={tab == 1 ? "primary" : "default"}><PasswordIcon /></IconButton>
                    </Stack>
                </div>
                {(tab == 0) && <UserForm user={user} onSubmit={handleSubmit} submitText={"Update profile"} submitIcon={<ArrowCircleUpIcon />} fields={{ name: true, surname: true, email: true }} />}
                {(tab == 1) && <PasswordForm onSubmit={handlePasswordSubmit} />}
            </Grid>
            <FeedbackSnackbar severity={snack.severity} setOpen={setSnack} open={snack.open}>{snack.text}</FeedbackSnackbar>
        </Grid>
    )
}