import { useState } from 'react';
import { Link } from 'react-router-dom';
import { deleteStationById } from '../api/service';

import { Stack, Button, TablePagination, Table, TableHead, TableBody, TableRow, TableCell, Paper } from '@mui/material';

import useStations from '../hooks/useStations';

import StationRow from '../components/cards/StationRow';
import FeedbackSnackbar from '../components/FeedbackSnackbar';

import AddIcon from '@mui/icons-material/Add';
import PlaceIcon from '@mui/icons-material/Place';

export default function ViewPage() {
    const [stations, setStations] = useStations()
    const [page, setPage] = useState(0);
    const [snack, setSnack] = useState({ open: false, text: "", severity: "" })


    const handleDelete = (id) => {
        deleteStationById(id).then((result) => {
            setStations(stations.filter((station) => station.id !== id))
        }).catch((err) => {
            if (err.status == 409) {
                setSnack({ open: true, text: "You need to remove all bikes from the station before deleting it!", severity: "warning" })
            } else {
                setSnack({ open: true, text: "An error ocurred whilst trying to delete the station!", severity: "error" })
            }
        });
    }

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    return (
        <Stack component={Paper}>
            <Stack padding={3} direction={"row"} justifyContent={"space-between"}>
                <PlaceIcon fontSize='large' />
                <Button startIcon={<AddIcon />} component={Link} to={"/admin/stations/create"}>Add Station</Button>
            </Stack>
            <Table >
                <TableHead >
                    <TableRow>
                        <TableCell>#</TableCell>
                        <TableCell>Name</TableCell>
                        <TableCell>No. of spots</TableCell>
                        <TableCell>No. of bikes</TableCell>
                        <TableCell>Options</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody >
                    {(stations.length > 0)
                        ? stations.slice(page * 8, page * 8 + 8).map((station, index) => (
                            <StationRow station={station} index={index} onDelete={handleDelete} key={station.city + " " + index} />
                        ))
                        : <TableRow>
                            <TableCell>No stations available</TableCell>
                            <TableCell />
                            <TableCell />
                            <TableCell />
                            <TableCell />
                        </TableRow>
                    }
                </TableBody>
            </Table>
            <TablePagination component={"div"} count={stations.length} rowsPerPage={8} rowsPerPageOptions={[]} page={page} onPageChange={handleChangePage} />
            <FeedbackSnackbar severity={snack.severity} setOpen={setSnack} open={snack.open}>{snack.text}</FeedbackSnackbar>
        </Stack>
    )
}