import { Typography, Paper } from '@mui/material';
import Grid from '@mui/material/Grid2';

import LocationOnIcon from '@mui/icons-material/LocationOn';

export default function StationData({ station }) {
    return (
        <Grid container size={7} spacing={3} padding={3} bgcolor={"primary.main"} color={"secondary.main"} justifyContent={"center"} alignItems={"center"}>
            <Grid size={12}>
                <LocationOnIcon sx={{ fontSize: "12rem" }} />
                <Typography variant='h2' >{station.name}</Typography>
            </Grid>
            <Grid size={4} component={Paper} padding={3}>
                <Typography fontWeight={'bold'}>{station.slotCount}</Typography>
                <Typography >Stations</Typography>
            </Grid>
            <Grid size={4} component={Paper} padding={3}>
                <Typography fontWeight={'bold'}>{station.bikeCount}</Typography>
                <Typography >Bikes Available</Typography>
            </Grid>
            <Grid size={4} component={Paper} padding={3}>
                <Typography fontWeight={'bold'}>{station.slotCount - station.bikeCount}</Typography>
                <Typography >Free Slots</Typography>
            </Grid>
        </Grid>
    )
}