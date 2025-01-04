import { users, rentals } from "./config"

export const getAllUsers = async () => {
    try {
        const response = await users.get("/all")
        return response.data
    } catch (error) {
        throw error
    }
}


export const getUserById = async (userId) => {
    try {
        const response = await users.get(`/by_id/${userId}`)
        return response.data
    } catch (error) {
        throw error
    }
}

export const updateUser = async (userId, user) => {
    try {
        const response = await users.put(`/update/${userId}`, user)
        return response.data
    } catch (error) {
        throw error
    }
}

export const updatePassword = async (userId, password) => {
    try {
        const response = await users.put(`/update/password/${userId}`, password)
        return response.data
    } catch (error) {
        throw error
    }
}


export const loginUser = async (user) => {
    try {
        const response = await users.post("/login", user)
        return response.data
    } catch (error) {
        throw error
    }
}

export const createUser = async (user) => {
    try {
        const response = await users.post("/create", user)
        return response.data
    } catch (error) {
        throw error
    }
}

export const deleteAllUsers = async () => {
    try {
        const response = await users.delete("/delete/all")
        return response.data
    } catch (error) {
        throw error
    }
}

export const deleteUserById = async (userId) => {
    try {
        const response = await users.delete(`/delete/by_id/${userId}`)
        return response.data
    } catch (error) {
        throw error
    }
}

export const rent = async (userId) => {
    try {
        const response = await users.patch(`/update/${userId}/rent`)
        return response.data
    } catch (error) {
        throw error
    }
}

export const checkRent = async (userId) => {
    try {
        const response = await users.get(`/check/${userId}`)
        return response.data
    } catch (error) {
        throw error
    }
}
