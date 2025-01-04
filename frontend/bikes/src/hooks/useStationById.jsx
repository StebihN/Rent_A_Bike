import { useEffect, useState } from "react";
import { getStationById } from "../api/service";

export default function useStationById(id) {
    const [station, setStation] = useState(null)

    useEffect(() => {
        if (id == "rented" || id == "service") {
            setStation(id)
        } else {
            getStationById(id).then((result) => {
                setStation(result.name)
            }).catch((err) => {
                console.log(err.message)
            });
        }

    });

    return { station }
}
