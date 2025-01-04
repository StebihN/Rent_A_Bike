import { useState } from 'react';
import { validate } from '../../utils/validation';

import { Stack, Button, TextField } from '@mui/material';
import useForm from '../../hooks/useForm';

import { fetchCoordinates } from '../../api/service';
import CordsForm from './CordsForm';
import FeedbackSnackbar from '../FeedbackSnackbar';

export default function StationForm({ station, onSubmit, submitText, submitIcon }) {
    const [formData, setFormData] = useForm(station)
    const [errors, setErrors] = useState('');

    const [snack, setSnack] = useState({ open: false, text: "", severity: "" })

    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData((prevFormData) => ({ ...prevFormData, [name]: value }));
    };

    const handleReset = () => {
        setFormData((prevFormData) => ({ ...prevFormData, latitude: "", longitude: "" }));
    }

    const handleSubmit = (event) => {
        event.preventDefault();

        const errors = validate(formData)
        if (Object.keys(errors).length > 0) {
            setErrors(errors)
            return
        }

        const request = {  
            ...formData,
        }

        onSubmit(request)

    }

    const handleCordsSubmit = (address) => {
        return fetchCoordinates(address).then((result) => {
            if (result.length == 0) {
                throw ({ kind: "unkown" })
            }
            setFormData((prevFormData) => ({ ...prevFormData, latitude: result[0].lat, longitude: result[0].lon }));
        }).catch((err) => {
            if (err.kind == "unkown") {
                setSnack({ open: true, text: "Unknown location, try again!", severity: "error" })
            }
            else {
                setSnack({ open: true, text: "An error occured, try again", severity: "error" })
            }
        });
    }

    return (
        <Stack spacing={3} height={"100%"}>
            {
                (formData.latitude)
                    ? <Button sx={{ alignSelf: "flex-end" }} onClick={handleReset}>New Location</Button>
                    : <CordsForm onSubmit={handleCordsSubmit} />
            }
            <iframe
                src={`https://www.google.com/maps?${(formData.latitude) ? "q=" + formData.latitude + "," + formData.longitude : ""}&hl=es;z=14&output=embed`}
                width={"100%"}
                height={"100%"}
                frameBorder={0}
                allowFullScreen={true}
                tabIndex={0} />
            <Stack component={"form"} onSubmit={handleSubmit} spacing={3}>
                <TextField
                    label="Name"
                    name={"name"}
                    value={formData.name}
                    onChange={handleChange}
                    error={errors.nameError ? true : false}
                    helperText={errors.nameError}
                />

                <TextField
                    type="number"
                    label="No. of Spots"
                    name={"slotCount"}
                    value={formData.slotCount}
                    onChange={handleChange}
                    error={errors.slotCountError ? true : false}
                    helperText={errors.slotCountError}
                />
                <Button type={"submit"} startIcon={submitIcon}>{submitText}</Button>
            </Stack>
            <FeedbackSnackbar severity={snack.severity} setOpen={setSnack} open={snack.open}>{snack.text}</FeedbackSnackbar>
        </Stack>
    )
}