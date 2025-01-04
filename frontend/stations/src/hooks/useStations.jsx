import { useEffect, useState } from "react";
import { getAllStations } from "../api/service";
import { useRent } from "host/RentProvider"

export default function useStations() {
    const [stations, setStations] = useState([])
    const { isRented } = useRent()

    useEffect(() => {
        getAllStations().then((result) => {
            setStations(result)
        }).catch((err) => {
            console.log(err.message)
        });
    }, [isRented]);

    return [stations, setStations]
}