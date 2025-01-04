import { useState, useEffect } from 'react'
import { getAllBikes } from '../api/service'

export default function useBikes() {
    const [bikes, setBikes] = useState([])

    useEffect(() => {
        getAllBikes().then((result) => {
            setBikes(result.bikes)
        }).catch((err) => {
            console.log(err.message)
        });
    }, []);

    return [bikes, setBikes]
}