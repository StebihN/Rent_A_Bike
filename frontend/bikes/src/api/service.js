import { bikes, stations } from "./config"

export const getAllBikes = async () => {
    try {
        const response = await bikes.get("/all")
        return response.data
    } catch (error) {
        throw error
    }
}

export const getBikeByLocation = async (locationId) => {
    try {
        const response = await bikes.get(`/by_location/${locationId}`)
        return response.data
    } catch (error) {
        throw error
    }
}

export const getBikeById = async (bikeId) => {
    try {
        const response = await bikes.get(`/by_id/${bikeId}`)
        return response.data
    } catch (error) {
        throw error
    }
}

export const updateBike = async (bike) => {
    try {
        const response = await bikes.put("/update", bike)
        return response.data
    } catch (error) {
        throw error
    }
}

export const createBike = async (bike) => {
    try {
        const response = await bikes.post("/create", bike)
        return response.data
    } catch (error) {
        throw error
    }
}

export const deleteAllBikes = async () => {
    try {
        const response = await bikes.delete("/delete/all")
        return response.data
    } catch (error) {
        throw error
    }
}

export const deleteBikeById = async (bike) => {
    try {
        const response = await bikes.post(`/delete/by_id/${bike.bikeId}`, bike)
        return response.data
    } catch (error) {
        throw error
    }
}

export const deleteBikeByLocation = async (locationId) => {
    try {
        const response = await bikes.delete(`/delete/by_location/${locationId}`)
        return response.data
    } catch (error) {
        throw error
    }
}

export const bikeToService = async (bike) => {
    try {
        const response = await bikes.post(`/to_service`, bike)
        return response.data
    } catch (error) {
        throw error
    }
}

export const bikeToStation = async (bike) => {
    try {
        const response = await bikes.post(`/to_station`, bike)
        return response.data
    } catch (error) {
        throw error
    }
}

export const rentBike = async (bike) => {
    try {
        const response = await bikes.post(`/rent`, bike)
        return response.data
    } catch (error) {
        throw error
    }
}

export const returnBike = async (bike) => {
    try {
        const response = await bikes.post(`/return`, bike)
        return response.data
    } catch (error) {
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