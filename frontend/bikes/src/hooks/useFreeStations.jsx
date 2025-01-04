import { useEffect, useState } from "react";
import { getFreeStations } from "../api/service";

export default function useFreeStations() {
    const [stations, setStations] = useState([])

    useEffect(() => {
        getFreeStations().then((result) => {
            setStations(result)
        }).catch((err) => {
            console.log(err.message)
        });
    }, []);

    return [stations, setStations]
}