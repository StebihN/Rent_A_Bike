import { Link } from 'react-router-dom';

import { IconButton, TableRow, TableCell } from '@mui/material';

import DeleteOutlinedIcon from '@mui/icons-material/DeleteOutlined';
import EditOutlinedIcon from '@mui/icons-material/EditOutlined';
import { formatTime } from '../../utils/formatTime';
import useStationById from '../../hooks/useStationById';

export default function BikeRow({ bike, index, onDelete }) {
    const { minutes, seconds } = formatTime(bike.totalTimeRented)
    const { station } = useStationById(bike.stationId)

    const handleDelete = () => {
        onDelete({bikeId: bike.id, stationId: bike.stationId})
    }

    return (
        <TableRow>
            <TableCell>{index + 1}</TableCell>
            <TableCell>Bike {bike.id}</TableCell>
            <TableCell>{station}</TableCell>
            <TableCell>{bike.rating}</TableCell>
            <TableCell>{bike.timesRented}</TableCell>
            <TableCell>{minutes} : {seconds}</TableCell>
            <TableCell>
                <IconButton color='error' onClick={handleDelete}><DeleteOutlinedIcon /></IconButton>
                <IconButton color='info' component={Link} to={`/admin/bikes/edit/${bike.id}`} state={{ bike: bike }}><EditOutlinedIcon /></IconButton>

            </TableCell>
        </TableRow>
    )
}