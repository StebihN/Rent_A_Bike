import { useState } from 'react';

import { createBike } from '../api/service';

import { Stack, Typography,Paper } from "@mui/material";

import FeedbackSnackbar from '../components/FeedbackSnackbar';
import BikeForm from '../components/forms/BikeForm';

import AddIcon from '@mui/icons-material/Add';

export default function CreatePage() {
    const [snack, setSnack] = useState({ open: false, text: "", severity: "" })

    const handleSubmit = (bike) => {
        createBike(bike).then((result) => {
            setSnack({ open: true, text: "Bike created successfully!", severity: "success" })
        }).catch((err) => {
            setSnack({ open: true, text: "Error whilst trying to create a new bike, try again!", severity: "error" })
        });
    }

    return (
        <Stack spacing={3} padding={3} component={Paper} height={800}>
            <Typography variant='h2'>Add a Bike</Typography>
            <BikeForm onSubmit={handleSubmit} submitText={"Add Bike"} submitIcon={<AddIcon />} />
            <FeedbackSnackbar severity={snack.severity} setOpen={setSnack} open={snack.open}>{snack.text}</FeedbackSnackbar>
        </Stack>
    )
}
