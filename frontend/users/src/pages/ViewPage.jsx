
import { useState } from 'react';
import { Link } from 'react-router-dom'
import { deleteUserById } from '../api/service';

import { Stack, Paper, Button, Table, TableBody, TableCell, TablePagination, TableHead, TableRow } from '@mui/material';

import useUsers from '../hooks/useUsers';

import UserRow from '../components/cards/UserRow';
import FeedbackSnackbar from '../components/FeedbackSnackbar';

import AddIcon from '@mui/icons-material/Add';
import ManageAccountsIcon from '@mui/icons-material/ManageAccounts';

export default function ViewPage() {
    const [users, setUsers] = useUsers()
    const [page, setPage] = useState(0);
    const [snack, setSnack] = useState({ open: false, text: "", severity: "" })

    const handleDelete = (id) => {
        deleteUserById(id).then((result) => {
            setUsers(users.filter((user) => user.id !== id))
        }).catch((err) => {
            setSnack({ open: true, text: "An error ocurred whilst trying to delete the user!", severity: "error" })
        });
    }

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    return (
        <Stack component={Paper} >
            <Stack padding={3} direction={"row"} justifyContent={"space-between"}>
                <ManageAccountsIcon fontSize='large' />
                <Button startIcon={<AddIcon />} component={Link} to={'/admin/users/create'}>Add user</Button>
            </Stack>
            <Table>
                <TableHead>
                    <TableRow>
                        <TableCell>#</TableCell>
                        <TableCell>Name</TableCell>
                        <TableCell>Surname</TableCell>
                        <TableCell>Email</TableCell>
                        <TableCell>Rent Count</TableCell>
                        <TableCell>Options</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {(users.length > 0)
                        ? users.slice(page * 8, page * 8 + 8).map((user, index) => (
                            <UserRow key={user.name + " " + index} user={user} index={index} onDelete={handleDelete} />
                        ))
                        : <TableRow>
                            <TableCell>No users available</TableCell>
                            <TableCell />
                            <TableCell />
                            <TableCell />
                            <TableCell />
                            <TableCell />
                        </TableRow>
                    }
                </TableBody>
            </Table>
            <TablePagination component={"div"} count={users.length} rowsPerPage={8} rowsPerPageOptions={[]} page={page} onPageChange={handleChangePage} />
            <FeedbackSnackbar severity={snack.severity} setOpen={setSnack} open={snack.open}>{snack.text}</FeedbackSnackbar>
        </Stack>
    )
}