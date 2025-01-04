import { useState } from 'react';

import { Stack, Typography } from '@mui/material';

import { rentBike } from '../api/service';

import { useBikesAtStation } from '../hooks/useBikesAtStation';
import BikeItem from '../components/cards/BikeItem';
import FeedbackSnackbar from '../components/FeedbackSnackbar'

import { jwtDecode } from 'jwt-decode'
import { useAuth } from "host/AuthProvider"
import { useRent } from "host/RentProvider"

import DirectionsBikeIcon from '@mui/icons-material/DirectionsBike';

export default function UserViewPage({ stationId }) {
    const { token } = useAuth()
    const { isRented, setIsRented } = useRent()
    const [bikes] = useBikesAtStation(stationId, isRented)
    const [snack, setSnack] = useState({ open: false, text: "", severity: "" })

    const handleRent = (bikeId) => {
        const rental = {
            userId: jwtDecode(token).id,
            bikeId: bikeId,
            rentedOn: Date.now(),
            stationId: stationId
        }
        rentBike(rental).then((result) => {
            setIsRented(result)
        }).catch((err) => {
            if(err.status == 409){
                setSnack({ open: true, text: "You can only rent one bike at a time", severity: "warning" })
            }
        });
    }

    return bikes.length > 0
        ? (
            <Stack spacing={3} padding={3} sx={{ overflowY: "auto" }}>
                {bikes.map((bike, index) => (
                    <BikeItem key={bike.name + " " + index} bike={bike} onRent={handleRent} />
                ))}
                <FeedbackSnackbar severity={snack.severity} setOpen={setSnack} open={snack.open}>{snack.text}</FeedbackSnackbar>
            </Stack>
        )
        : (
            <Stack spacing={3} padding={3} height={"100%"} alignItems={"center"} justifyContent={"center"}>
                <DirectionsBikeIcon sx={{fontSize: "12rem"}} />
                <Typography>No bikes available at the moment. Try another station.</Typography>
            </Stack>
        )
}