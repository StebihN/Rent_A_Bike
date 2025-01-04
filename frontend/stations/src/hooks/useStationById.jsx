import { useEffect, useState } from "react";
import { getStationById } from "../api/service";

export default function useStationById(id) {
    const [station, setStation] = useState(null)

    useEffect(() => {
        getStationById(id).then((result) => {
            setStation(result)
        }).catch((err) => {
            console.log(err.message)
        });
    }, []);

    return {station}
}