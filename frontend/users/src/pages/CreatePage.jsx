import { useState } from 'react';

import { createUser } from '../api/service';

import { Stack, Typography, Paper } from '@mui/material'

import FeedbackSnackbar from '../components/FeedbackSnackbar';
import UserForm from '../components/forms/UserForm';

import AddIcon from '@mui/icons-material/Add';

export default function CreatePage() {
    const [snack, setSnack] = useState({ open: false, text: "", severity: "" })

    const handleSubmit = (user) => {
        return createUser(user)
            .then(() => {
                setSnack({ open: true, text: "User added successfully", severity: "success" })
            })
            .catch((err) => {
                if (err.response.status === 412) {
                    throw ("User with provided email already exists")
                } else {
                    setSnack({ open: true, text: "Error whilst trying to create a new user, try again!", severity: "error" })
                }
            });

    }

    return (
        <Stack spacing={3} padding={3} component={Paper} height={800}>
            <Typography variant='h2'>Add a New User</Typography>
            <UserForm onSubmit={handleSubmit} submitText={"Add User"} submitIcon={<AddIcon />} fields={{name:true, surname:true, email:true, password:true}}/>
            <FeedbackSnackbar severity={snack.severity} setOpen={setSnack} open={snack.open}>{snack.text}</FeedbackSnackbar>
        </Stack>
    )
}