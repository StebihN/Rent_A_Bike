import { Paper, Stack, Rating, Button, Typography, } from '@mui/material';

import DirectionsBikeIcon from '@mui/icons-material/DirectionsBike';

const itemStyle = {
    borderLeftColor: "#2e7d32",
    borderLeftWidth: 3,
    borderLeftStyle: "solid",
    padding: 3,
    overflow: "initial"
}

export default function BikeItem({ bike, onRent }) {
    const handleRent = (bikeId) => {
        onRent(bikeId)
    }
    return (
        <Stack direction={"row"} alignItems={"center"} justifyContent={"space-around"} textAlign={"center"} component={Paper} sx={itemStyle} >
            <Stack alignItems={"center"}>
                <DirectionsBikeIcon fontSize={"large"} />
                <Typography >Bike {bike.id}</Typography>
            </Stack>
            <Rating readOnly value={bike.rating} precision={0.5} />
            <Button onClick={() => handleRent(bike.id)}>Rent</Button>
        </Stack>
    )
}