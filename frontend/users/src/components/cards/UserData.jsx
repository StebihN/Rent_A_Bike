import { Typography, Paper } from '@mui/material';
import Grid from '@mui/material/Grid2';

import AccountCircleIcon from '@mui/icons-material/AccountCircle';

export default function UserData({ user }) {
    return (
        <Grid container size={7} spacing={3} bgcolor={"primary.main"} color={"secondary.main"} justifyContent={"center"} alignItems={"center"}>
            <Grid size={12}>
                <AccountCircleIcon sx={{ fontSize: "12rem" }} />
                <Typography variant='h2'>{user.name} {user.surname}</Typography>
                <Typography>{user.email}</Typography>
            </Grid>
            <Grid size={4} component={Paper} padding={3}  >
                <Typography fontWeight={'bold'}>{user.bikesRented}</Typography>
                <Typography>Bikes Rented</Typography>
            </Grid>
        </Grid>
    )
}