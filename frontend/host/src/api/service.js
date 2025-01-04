import { rentals } from "./config"

export const getRentByUserId = async (userId) => {
    try {
        const response = await rentals.get(`/get/user/${userId}`)
        return response.data
    } catch (error) {
        throw error
    }
}