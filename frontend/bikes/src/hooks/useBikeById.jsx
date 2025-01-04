import { useEffect, useState } from "react";
import { getBikeById } from "../api/service";

export const useBikeById = (id) => {
    const [bike, setBike] = useState(null)

    useEffect(() => {
        getBikeById(id).then((result) => {
            setBike(result)
        }).catch((err) => {
            console.log(err.message)
        });
    }, [])

    return [bike, setBike]
}