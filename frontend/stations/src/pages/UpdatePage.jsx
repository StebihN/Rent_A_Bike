import { useState } from 'react';
import { useParams } from 'react-router-dom';
import { updateStation } from '../api/service';
import useStationById from '../hooks/useStationById';

import { Typography, Stack, Paper } from '@mui/material';
import Grid from '@mui/material/Grid2';

import FeedbackSnackbar from '../components/FeedbackSnackbar';
import StationData from '../components/cards/StationData';
import StationForm from '../components/forms/StationForm';

import ArrowCircleUpIcon from '@mui/icons-material/ArrowCircleUp';


export default function UpdatePage() {
    const { id } = useParams()
    const { station } = useStationById(id)
    const [snack, setSnack] = useState({ open: false, text: "", severity: "" })

    const handleSubmit = (updatedStation) => {
        updateStation({ ...station, ...updatedStation }).then(() => {
            setSnack({ open: true, text: "Station updated successfully", severity: "success" })
        }).catch((err) => {
            if (err.status == 409) {
                setSnack({ open: true, text: "You need to remove all bikes from the station before updating it!", severity: "warning" })
            } else {
                setSnack({ open: true, text: "An error occured, try again!", severity: "error" })
            }
        });
    }

    return station && (
        <Grid container component={Paper} textAlign={"center"} height={800}>
            <StationData station={station} />
            <Grid size={5} padding={3} component={Stack} justifyContent={"space-around"}>
                <Stack spacing={3}>
                    <Typography variant='h2'>Update Station</Typography>
                    <StationForm station={station} onSubmit={handleSubmit} submitText={"Update Station"} submitIcon={<ArrowCircleUpIcon />} />
                </Stack>
            </Grid>
            <FeedbackSnackbar severity={snack.severity} setOpen={setSnack} open={snack.open}>{snack.text}</FeedbackSnackbar>
        </Grid>
    )
}