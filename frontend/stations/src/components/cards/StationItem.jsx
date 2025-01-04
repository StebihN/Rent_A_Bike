import * as React from 'react';

import { Paper, Stack, Button, Typography, Box } from '@mui/material';

import PedalBikeIcon from '@mui/icons-material/PedalBike';
import LocalParkingOutlinedIcon from '@mui/icons-material/LocalParkingOutlined';
import LocationOnIcon from '@mui/icons-material/LocationOn';

export default function StationItem({ station, bikes }) {
    const [open, setOpen] = React.useState(false)
    const Bikes = bikes

    const toggleView = () => {
        setOpen(!open)
    }

    const InfoCard = ({ icon: Icon, value }) => (
        <Stack
            component={Paper}
            bgcolor="primary.main"
            direction="row"
            padding={"6px 16px"}
            alignItems="center"
            justifyContent="center"
            spacing={1}
        >
            <Icon color="secondary" />
            <Typography color="secondary">{value}</Typography>
        </Stack>
    );

    return (
        <Stack component={Paper} justifyContent={"space-between"} height={"100%"}>
            {open ?
                <Bikes stationId={station.id} />
                :
                <iframe
                    src={`https://www.google.com/maps?q=${station.latitude},${station.longitude}&hl=es;z=14&output=embed`}
                    width={"100%"}
                    height={"100%"}
                    frameBorder={0}
                    allowFullScreen={true}
                    tabIndex={0} />
            }
            <Box>
                <Typography variant='h3' paddingInline={3}>{station.name}</Typography>
                <Stack direction={'row'} margin={3} justifyContent={"space-between"} alignItems={"center"}>
                    <Stack direction="row" spacing={3}>
                        <InfoCard icon={PedalBikeIcon} value={station.bikeCount} />
                        <InfoCard icon={LocalParkingOutlinedIcon} value={station.slotCount - station.bikeCount} />
                    </Stack>
                    <Button
                        variant='contained'
                        startIcon={open ? <LocationOnIcon /> : <PedalBikeIcon />}
                        onClick={() => toggleView()}
                    >
                        {open ? "View Location" : "View Bikes"}
                    </Button>
                </Stack>
            </Box>
        </Stack>
    )
}