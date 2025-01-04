import { Snackbar, Alert } from '@mui/material'

export default function FeedbackSnackbar({children, severity, setOpen, open}) {

    const handleClose = (reason) => {
	    if (reason === 'clickaway') {
	        return;
	    }
	    setOpen(false);
	};

    return(
        <Snackbar open={open} autoHideDuration={6000} onClose={handleClose}>
			<Alert
				onClose={handleClose}
				severity={severity}
				variant="filled"
				sx={{ width: '100%' }}
			>
				{children}
			</Alert>
		</Snackbar>
    )
}