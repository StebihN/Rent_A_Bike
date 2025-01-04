import { useState } from 'react';

import { createStation } from '../api/service';

import { Stack, Typography, Paper } from '@mui/material'

import FeedbackSnackbar from '../components/FeedbackSnackbar';
import StationForm from '../components/forms/StationForm';

import AddIcon from '@mui/icons-material/Add';

export default function CreatePage() {
	const [snack, setSnack] = useState({ open: false, text: "", severity: "" })

	const handleSubmit = (station) => {
		console.log(station)
		createStation(station).then(() => {
			setSnack({ open: true, text: "Station created successfully", severity: "success" })
		}).catch((err) => {
			setSnack({ open: true, text: "Error whilst trying to create a station, try again!", severity: "error" })
		});
	}

	return (
		<Stack spacing={3} padding={3} component={Paper} height={800}>
			<Typography variant='h2'>Add A Station</Typography>
			<StationForm onSubmit={handleSubmit} submitText={"Add Station"} submitIcon={<AddIcon />}/>
			<FeedbackSnackbar severity={snack.severity} setOpen={setSnack} open={snack.open}>{snack.text}</FeedbackSnackbar>
		</Stack>
	)
}