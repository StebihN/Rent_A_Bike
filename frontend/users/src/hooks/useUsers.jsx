import { useState, useEffect } from 'react'
import { getAllUsers } from '../api/service'

export default function useUsers() {
    const [users, setUsers] = useState([])

    useEffect(() => {
        getAllUsers()
            .then((result) => {
                setUsers(result)
            })
            .catch((err) => {
                console.log(err)
            });
    })

    return [users, setUsers]
}