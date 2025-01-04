
import {Link} from 'react-router-dom'
import { IconButton, TableCell, TableRow } from '@mui/material';

import DeleteOutlinedIcon from '@mui/icons-material/DeleteOutlined';
import EditOutlinedIcon from '@mui/icons-material/EditOutlined';

export default function UserRow({ user, index, onDelete }) {

    const handleDelete = () => {
        onDelete(user.id)
    }

    return (
        <TableRow>
            <TableCell>{index + 1}</TableCell>
            <TableCell>{user.name}</TableCell>
            <TableCell>{user.surname}</TableCell>
            <TableCell>{user.email}</TableCell>
            <TableCell>{user.bikesRented}</TableCell>
            <TableCell>
                <IconButton color='error' onClick={handleDelete}><DeleteOutlinedIcon /></IconButton>
                <IconButton color='info' component={Link} to={`/admin/users/edit/${user.id}`}><EditOutlinedIcon /></IconButton>
            </TableCell>
        </TableRow>
    )
}