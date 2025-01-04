import { useEffect, useState } from "react";
import { getBikeByLocation } from "../api/service";

export const useBikesAtStation = (stationId, isRented) => {
    const [bikes, setBikes] = useState([])
    
    useEffect(() => {
        getBikeByLocation(stationId).then((result) => {
            setBikes(result.bikes)
        }).catch((err) => {
            console.log(err.message)
        });
    }, [stationId, isRented])

    return [bikes, setBikes]
}