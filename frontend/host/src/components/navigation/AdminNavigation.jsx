import { Card, Paper, Stack, Button, Typography, BottomNavigation, BottomNavigationAction } from "@mui/material"
import Grid from '@mui/material/Grid2';


import MenuList from '@mui/material/MenuList';
import MenuItem from '@mui/material/MenuItem';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';

import PlaceIcon from '@mui/icons-material/Place';
import PedalBikeIcon from '@mui/icons-material/PedalBike';
import PersonIcon from '@mui/icons-material/Person'
import HomeOutlinedIcon from '@mui/icons-material/HomeOutlined';;
import SettingsIcon from '@mui/icons-material/Settings';

export default function AdminNavigation() {

    const listItem = [
        {
            text: "Home",
            icon: <HomeOutlinedIcon />,
            to: "/"
        },
        {
            text: "Stations",
            icon: <PlaceIcon />,
            to: "/admin/stations"
        },
        {
            text: "Bikes",
            icon: <PedalBikeIcon />,
            to: "/admin/bikes"
        },
        {
            text: "Users",
            icon: <PersonIcon />,
            to: "/admin/users"
        },
    ]

    return (
        <Stack alignItems={"center"} spacing={1}>
            <BottomNavigation showLabels component={Card} >
                {listItem.map((list, index) => {
                    const { text, icon, to } = list;
                    return (
                        <BottomNavigationAction key={"menu item " + index} href={to} icon={icon} label={text} />
                    )
                })}
            </BottomNavigation>
        </Stack>
    )
}