import { useState } from 'react';
import { validate } from '../../utils/validation';

import { Stack, Button, TextField } from '@mui/material'

import ArrowCircleUpIcon from '@mui/icons-material/ArrowCircleUp';

export default function PasswordForm({ onSubmit }) {
    const [formData, setFormData] = useState({ oldPassword: "", newPassword: "" })
    const [errors, setErrors] = useState('');

    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData((prevFormData) => ({ ...prevFormData, [name]: value }));
    };


    const handleSubmit = (event) => {
        event.preventDefault();

        const errors = validate(formData)
        if (Object.keys(errors).length > 0) {
            setErrors(errors)
            return
        }

        const request = {
           ...formData
        }
        onSubmit(request)
    }
    return (
        <Stack component={"form"} onSubmit={handleSubmit} spacing={3}>

            <TextField
                type="password"
                label="Old Password"
                name="oldPassword"
                value={formData.oldPassword}
                onChange={handleChange}
                error={errors.oldPasswordError ? true : false}
                helperText={errors.oldPasswordError}
            />
            <TextField
                type="password"
                label="New Password"
                name="newPassword"
                value={formData.newPassword}
                onChange={handleChange}
                error={errors.newPasswordError ? true : false}
                helperText={errors.newPasswordError}
            />
            <Button type="submit" startIcon={<ArrowCircleUpIcon />}>Update Password</Button>
        </Stack>
    )
}