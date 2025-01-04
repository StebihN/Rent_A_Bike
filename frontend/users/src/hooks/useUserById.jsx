import { useState, useEffect } from 'react'
import { getUserById } from '../api/service'

export default function useUserById(id) {
    const [user, setUser] = useState(null)

    useEffect(() => {
        getUserById(id).then((result) => {
            setUser(result)
        }).catch((err) => {
            console.log(err.message)
        });
    }, []);

    return { user }
}