import { Link } from 'react-router-dom';
import { IconButton, TableRow, TableCell } from '@mui/material';

import DeleteOutlinedIcon from '@mui/icons-material/DeleteOutlined';
import EditOutlinedIcon from '@mui/icons-material/EditOutlined';

export default function StationRow({ station, index, onDelete }) {

    const handleDelete = () => {
        onDelete(station.id)
    }

    return (
        <TableRow key={station.city + " " + index}>
            <TableCell>{index + 1}</TableCell>
            <TableCell>{station.name}</TableCell>
            <TableCell>{station.slotCount}</TableCell>
            <TableCell>{station.bikeCount}</TableCell>
            <TableCell>
                <IconButton color='error' onClick={handleDelete}><DeleteOutlinedIcon /></IconButton>
                <IconButton color='info' component={Link} to={`/admin/stations/edit/${station.id}`}><EditOutlinedIcon /></IconButton>
            </TableCell>
        </TableRow>
    )
}