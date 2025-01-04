import { useState } from 'react';
import { validate } from '../../utils/validation';

import { Stack, Button, TextField } from '@mui/material'

import useForm from '../../hooks/useForm';

export default function UserForm({ user, onSubmit, submitText, submitIcon, fields }) {
    const [formData, setFormData] = useForm(user, fields)
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
            {fields.name &&
                <TextField
                    label="Name"
                    name="name"
                    value={formData.name}
                    onChange={handleChange}
                    error={errors.nameError ? true : false}
                    helperText={errors.nameError}

                />}
            {fields.surname &&
                < TextField
                    label="Surname"
                    name="surname"
                    value={formData.surname}
                    onChange={handleChange}
                    error={errors.surnameError ? true : false}
                    helperText={errors.surnameError}
                />}
            {fields.email &&
                <TextField
                    label="Email"
                    name="email"
                    value={formData.email}
                    onChange={handleChange}
                    error={errors.emailError ? true : false}
                    helperText={errors.emailError}
                />}
            {fields.password &&
                <TextField
                    type="password"
                    label="Password"
                    name="password"
                    value={formData.password}
                    onChange={handleChange}
                    error={errors.passwordError ? true : false}
                    helperText={errors.passwordError}
                />}

            <Button type={"submit"} startIcon={submitIcon}>{submitText}</Button>
        </Stack>
    )
}