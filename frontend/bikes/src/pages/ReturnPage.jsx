import { useState } from "react";
import { Button, Stack, Typography, } from "@mui/material";

import { returnBike } from "../api/service";
import { useRent } from "host/RentProvider"

import Rating from "@mui/material/Rating";

import BikeForm from "../components/forms/BikeForm";
import KeyboardReturnIcon from '@mui/icons-material/KeyboardReturn';

export default function Return() {
    const { isRented, setIsRented } = useRent()
    const [rating, setRating] = useState(0)
    const [disabled, setDisabled] = useState(true)

    const handleChange = (event) => {
        setRating(event.target.value);
    };

    const toggleDissable = () => {
        setDisabled(!disabled)
    }

    const handleSubmit = (request) => {
        const rental = {
            ...isRented,
            ...request,
            ...(!disabled && { rating: rating })
        }
        
        returnBike(rental).then((result) => {
            setIsRented()
        }).catch((err) => {
            console.log(err)
        });

    }

    return (
        <Stack padding={3} spacing={3}>
            <Typography variant="h2">Return Bike</Typography>
            <Stack direction={"row"} justifyContent={"space-between"}>
                <Button onClick={() => toggleDissable()}> Rate</Button>
                <Rating disabled={disabled} value={Number(rating)} name="rating" precision={0.5} onChange={handleChange}></Rating>
            </Stack>
            <BikeForm onSubmit={handleSubmit} submitText={"Return Bike"} submitIcon={<KeyboardReturnIcon />} />
        </Stack>
    )
}
