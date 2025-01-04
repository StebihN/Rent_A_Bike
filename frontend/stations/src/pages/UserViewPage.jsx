import { useState } from 'react';

import { IconButton, Stack, Typography, Paper } from '@mui/material';

import useStations from '../hooks/useStations';
import StationItem from '../components/cards/StationItem';

import ArrowBackIosNewIcon from '@mui/icons-material/ArrowBackIosNew';
import ArrowForwardIosIcon from '@mui/icons-material/ArrowForwardIos';
import CircleIcon from '@mui/icons-material/Circle';
import CircleOutlinedIcon from '@mui/icons-material/CircleOutlined';
import PlaceIcon from '@mui/icons-material/Place';

export default function UserViewPage({ bikes }) {
    const [stations] = useStations()
    const [selected, setSelected] = useState(0)

    const clamp = (val, min, max) => {
        return val > max ? min : val < min ? max : val;
    }

    const handleArrowClick = (forward) => {
        forward ? setSelected(clamp(selected + 1, 0, stations.length - 1)) : setSelected(clamp(selected - 1, 0, stations.length - 1))
    }


    return stations.length > 0
        ? (
            <Stack height={800}>
                <StationItem station={stations[selected]} bikes={bikes} />
                <Stack direction={"row"} justifyContent={"space-between"} alignItems={"center"} padding={3} >
                    <IconButton onClick={() => handleArrowClick(false)}><ArrowBackIosNewIcon color={"primary"} /></IconButton>
                    <div>
                        {stations.map((station, index) =>
                            (selected == index)
                                ? <CircleIcon key={"circle" + index} />
                                : <CircleOutlinedIcon key={"circle" + index} />
                        )}
                    </div>
                    <IconButton onClick={() => handleArrowClick(true)}><ArrowForwardIosIcon color={"primary"} /></IconButton>
                </Stack>
            </Stack>
        )
        : (
            <Stack height={800} component={Paper} alignItems={"center"} justifyContent={"center"}>
                <PlaceIcon sx={{fontSize: "12rem"}}/>
                <Typography>No Stations Are available at the moment. Try again later</Typography>
            </Stack>
        )

}