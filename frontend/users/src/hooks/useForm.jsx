import { useEffect, useState } from "react";

export default function useForm(user, fields) {
    const setFields = () => {
        let state = {}
        Object.keys(fields).forEach(key => {
            state = { ...state, [key]: "" }
        });
        return state
    }
    const [formData, setFormData] = useState(setFields)

    useEffect(() => {
        if (user) {
            setFormData({ name: user.name, surname: user.surname, email: user.email })
        }
    }, []);



    return [formData, setFormData]
}