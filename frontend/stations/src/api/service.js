import { stations,coordinates } from "./config"

export const getAllStations = async () => {
    try {
        const response = await stations.get("/all")
        return response.data
    } catch (error) {
        console.log(error.message)
        throw error
    }
}

export const getFreeStations = async () => {
    try {
        const response = await stations.get("/free")
        return response.data
    } catch (error) {
        console.log(error.message)
        throw error
    }
}

export const getStationById = async (stationId) => {
    try {
        const response = await stations.get(`/by_id/${stationId}`)
        return response.data
    } catch (error) {
        throw error
    }
}

export const updateStation = async (station) => {
    try {
        const response = await stations.put("/update", station)
        return response.data
    } catch (error) {
        throw error
    }
}

export const createStation = async (station) => {
    try {
        const response = await stations.post("/create", station)
        return response.data
    } catch (error) {
        throw error
    }
}

export const deleteAllStations = async () => {
    try {
        const response = await stations.delete("/delete/all")
        return response.data
    } catch (error) {
        throw error
    }
}

export const deleteStationById = async (stationId) => {
    try {
        const response = await stations.delete(`/delete/by_id/${stationId}`)
        return response.data
    } catch (error) {
        throw error
    }
}

export const addBike = async (bike) => {
    try {
        const response = await stations.post("/add" , bike)
        return response.data
    } catch (error) {
        throw error
    }
}

export const removeBike = async (bike) => {
    try {
        const response = await stations.post("/remove" , bike)
        return response.data
    } catch (error) {
        throw error
    }
}

export const fetchCoordinates = async (address) => {
    try {
        const response = await coordinates.get(`/search?q=${address}&api_key=6654ec77a5b3b811934340pho29006a`)
        return response.data
    } catch (error) {
        console.error("Error getting coordinates", error)
        throw error
    }

}