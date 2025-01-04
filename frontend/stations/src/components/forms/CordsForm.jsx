import { useState } from 'react';
import { validate } from '../../utils/validation';

import { Stack, Button, TextField, } from '@mui/material';

import SearchIcon from '@mui/icons-material/Search';

export default function CordsForm({ onSubmit }) {
    const [address, setAddress] = useState("")
    const [errors, setErrors] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();

        const errors = validate({ address })
        if (Object.keys(errors).length > 0) {
            setErrors(errors)
            return
        }

        onSubmit(address)
    }

    return (
        <Stack component={"form"} onSubmit={handleSubmit} spacing={3} direction={"row"} alignItems={"center"}>
            <TextField
                label="Address"
                name={"address"}
                value={address}
                onChange={(e) => setAddress(e.target.value)}
                error={errors.addressError ? true : false}
                helperText={errors.addressError}
            />
            <Button type="submit" startIcon={<SearchIcon />}>Search</Button>
        </Stack>
    )
}