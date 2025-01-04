import { useState } from 'react';
import { validate } from '../../utils/validation';

import { Stack, Button, FormControl, InputLabel, Select, FormHelperText, MenuItem } from '@mui/material';

import useFreeStations from "../../hooks/useFreeStations";

export default function BikeForm({ onSubmit, submitText, submitIcon }) {
    const [formData, setFormData] = useState({ stationId: "" })
    const [errors, setErrors] = useState('');

    const [stations] = useFreeStations();

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
        <Stack component="form" onSubmit={handleSubmit}>
            <FormControl>
                <InputLabel>Station</InputLabel>
                <Select
                    name={"stationId"}
                    value={formData.stationId}
                    onChange={handleChange}
                    error={errors.stationIdError ? true : false}
                >
                    {stations.map((station, index) => (<MenuItem key={station.name + " " + index} value={station.id}>{station.name}</MenuItem>))}
                </Select>
                <FormHelperText>{errors.stationError}</FormHelperText>
            </FormControl>
            <Button type={"submit"} startIcon={submitIcon}>{submitText}</Button>
        </Stack>
    )
}