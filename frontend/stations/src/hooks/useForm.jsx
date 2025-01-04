import { useEffect, useState } from "react";

export default function useForm(station) {
    const [formData, setFormData] = useState({ name: "", slotCount: "", latitude: "", longitude: "" })

    useEffect(() => {
        if (station) {
            setFormData({ name: station.name, slotCount: String(station.slotCount), latitude: String(station.latitude), longitude: String(station.longitude) })
        }
    }, []);

    return  [formData, setFormData ]
}