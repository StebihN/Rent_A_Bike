import { Typography, Paper } from '@mui/material';
import Grid from '@mui/material/Grid2';

import DirectionsBikeIcon from '@mui/icons-material/DirectionsBike';
import { formatTime } from '../../utils/formatTime';

export default function BikeData({ bike }) {
    const { minutes, seconds } = formatTime(bike.totalTimeRented)

    return (
        <Grid container size={7} spacing={3} padding={3} bgcolor={"primary.main"} color={"secondary.main"} justifyContent={"center"} alignItems={"center"}>
            <Grid size={12}>
                <DirectionsBikeIcon sx={{ fontSize: "12rem" }} />
                <Typography variant='h2'>Bike {bike.id}</Typography>
            </Grid>
            <Grid size={4} component={Paper} padding={3}>
                <Typography fontWeight={'bold'}>{minutes} : {seconds}</Typography>
                <Typography >Travel Time</Typography>
            </Grid>
            <Grid size={4} component={Paper} padding={3}>
                <Typography fontWeight={'bold'}>{bike.timesRented}x</Typography>
                <Typography >Rented</Typography>
            </Grid>
            <Grid size={4} component={Paper} padding={3}>
                <Typography fontWeight={'bold'}>{bike.rating}</Typography>
                <Typography >Rating</Typography>
            </Grid>
        </Grid>
    )
}