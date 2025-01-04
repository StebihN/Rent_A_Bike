import { useState } from 'react';
import { Link } from 'react-router-dom'
import { deleteBikeById } from '../api/service';

import { Stack, Button, Paper, Table, TableHead, TableBody, TableRow, TableCell, TablePagination } from '@mui/material';
import useBikes from '../hooks/useBikes';

import BikeRow from '../components/cards/BikeRow';
import FeedbackSnackbar from '../components/FeedbackSnackbar';

import AddIcon from '@mui/icons-material/Add';
import DirectionsBikeIcon from '@mui/icons-material/DirectionsBike';

//cant delete rented or service bikes
export default function ViewPage() {
    const [bikes, setBikes] = useBikes();

    const [page, setPage] = useState(0);
    const [snack, setSnack] = useState({ open: false, text: "", severity: "" })

    const handleDelete = (bike) => {
        deleteBikeById(bike).then((result) => {
            setBikes(bikes.filter((item) => item.id !== bike.bikeId))
        }).catch((err) => {
            setSnack({ open: true, text: "An error ocurred whilst trying to delete the bike!", severity: "error" })
        });
    }

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    return (
        <Stack component={Paper} >
            <Stack padding={3} direction={"row"} justifyContent={"space-between"}>
                <DirectionsBikeIcon fontSize='large' />
                <Button startIcon={<AddIcon />} component={Link} to={"/admin/bikes/create"}>Add Bike</Button>
            </Stack>
            <Table  >
                <TableHead >
                    <TableRow >
                        <TableCell >#</TableCell>
                        <TableCell>Name</TableCell>
                        <TableCell>Station</TableCell>
                        <TableCell>Rating</TableCell>
                        <TableCell>Rent Count</TableCell>
                        <TableCell>Driving Time</TableCell>
                        <TableCell>Options</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {(bikes.length > 0)
                        ? bikes.slice(page * 8, page * 8 + 8).map((bike, index) => (
                            <BikeRow key={bike.name + " " + index} bike={bike} index={index} onDelete={handleDelete} />
                        ))
                        : <TableRow>
                            <TableCell>No bikes available</TableCell>
                            <TableCell/>
                            <TableCell/>
                            <TableCell/>
                            <TableCell/>
                            <TableCell/>
                            <TableCell/>
                        </TableRow>
                    }

                </TableBody>
            </Table>
            <TablePagination component={"div"} count={bikes.length} rowsPerPage={8} rowsPerPageOptions={[]} page={page} onPageChange={handleChangePage} />
            <FeedbackSnackbar severity={snack.severity} setOpen={setSnack} open={snack.open}>{snack.text}</FeedbackSnackbar>
        </Stack>
    )
}