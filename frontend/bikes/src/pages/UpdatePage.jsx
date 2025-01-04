import { useState } from 'react';
import { useParams } from 'react-router-dom';
import { bikeToService, bikeToStation } from '../api/service';
import { useBikeById } from '../hooks/useBikeById';

import { Typography, Stack, Paper, Button } from '@mui/material';
import Grid from '@mui/material/Grid2';

import FeedbackSnackbar from '../components/FeedbackSnackbar';
import BikeData from '../components/cards/BikeData';
import BikeForm from '../components/forms/BikeForm';

import ArrowCircleUpIcon from '@mui/icons-material/ArrowCircleUp';
import BuildOutlinedIcon from '@mui/icons-material/BuildOutlined';

export default function UpdatePage() {
    const { id } = useParams()
    const [bike, setBike] = useBikeById(id)
    const [snack, setSnack] = useState({ open: false, text: "", severity: "" })

    const handleReturn = (request) => {
        bikeToStation({ bikeId: bike.id, stationId: request.stationId }).then((result) => {
            setBike(result)
            setSnack({ open: true, text: "Kolo uspešno posodobljeno!", severity: "success" })
        }).catch((err) => {
            setSnack({ open: true, text: "Napaka pri posodobitvi kolesa, poskusite znova!", severity: "error" })
        });
    }
    const handleService = () => {
        bikeToService({ bikeId: bike.id, stationId: bike.stationId }).then((result) => {
            setBike(result)
            setSnack({ open: true, text: "Kolo uspešno posodobljeno!", severity: "success" })
        }).catch((err) => {
            setSnack({ open: true, text: "Napaka pri posodobitvi kolesa, poskusite znova!", severity: "error" })
        });
    }


    return bike && (
        <Grid container component={Paper} textAlign={"center"} height={800}>
            <BikeData bike={bike} />
            <Grid size={5} padding={3} component={Stack} justifyContent={"space-around"}>
                <Typography variant='h2'>Update Bike</Typography>
                {
                    (bike.stationId == "service")
                        ? <BikeForm bike={bike} onSubmit={handleReturn} submitText={"Update Bike"} submitIcon={<ArrowCircleUpIcon />} />
                        : <Button fullWidth color='warning' onClick={handleService} startIcon={<BuildOutlinedIcon />}>Service Bike</Button>
                }
            </Grid>
            <FeedbackSnackbar severity={snack.severity} setOpen={setSnack} open={snack.open}>{snack.text}</FeedbackSnackbar>
        </Grid>
    )

}