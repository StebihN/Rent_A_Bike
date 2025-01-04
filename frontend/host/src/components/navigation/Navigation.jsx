import { useEffect, useState } from "react";
import { Button, Card, Stack, BottomNavigation, BottomNavigationAction, Dialog } from "@mui/material"
import { jwtDecode } from 'jwt-decode'

import { useAuth } from "host/AuthProvider"
import { useRent } from "host/RentProvider"

import Timer from "../Timer";
import BikeReturnPage from 'bikes/ReturnPage'

import HomeOutlinedIcon from '@mui/icons-material/HomeOutlined';
import PersonOutlineOutlinedIcon from '@mui/icons-material/PersonOutlineOutlined';
import LogoutOutlinedIcon from '@mui/icons-material/LogoutOutlined';
import SettingsIcon from '@mui/icons-material/Settings';

export default function Navigation() {
    const { isRented, setIsRented } = useRent()
    const { token, setToken } = useAuth();
    const [open, setOpen] = useState(false)

    useEffect(() => {
        closeDialog()
    }, [isRented])

    const openDialog = () => {
        setOpen(true)
    }

    const closeDialog = () => {
        setOpen(false)
    }

    const handleLogout = () => {
        setToken();
        setIsRented();
    };

    return (
        <Stack alignItems={"center"} spacing={1}>
            {isRented &&
                <Stack component={Card} direction={"row"} spacing={1} alignItems={"center"} sx={{ bgcolor: "#2e7d32", padding: 1 }}>
                    <Timer rentedOn={isRented.rentedOn} />
                    <Button onClick={openDialog}> Return Bike</Button>
                    <Dialog open={open} onClose={closeDialog}><BikeReturnPage /></Dialog>
                </Stack>
            }
            <BottomNavigation showLabels component={Card}>
                <BottomNavigationAction href={"/"} icon={<HomeOutlinedIcon />} label="Home" />
                <BottomNavigationAction href={"/user/" + jwtDecode(token).id} icon={<PersonOutlineOutlinedIcon />} label="Profile" />
                <BottomNavigationAction href={"/admin/stations"} icon={<SettingsIcon />} label="Settings" />
                <BottomNavigationAction showLabel onClick={() => handleLogout()} icon={<LogoutOutlinedIcon />} label="Logout" />
            </BottomNavigation>

        </Stack>
    )
}