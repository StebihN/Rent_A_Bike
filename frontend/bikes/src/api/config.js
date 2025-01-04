import axios from 'axios'
import Cookies from 'js-cookie'

export const bikes = axios.create({
    baseURL: process.env.GATEWAY_URI + '/bikes',
    timeout: 5000,
})

export const stations = axios.create({
    baseURL: process.env.GATEWAY_URI + '/stations',
    timeout: 5000,
})

bikes.interceptors.request.use((config) =>{
    const token = Cookies.get('token')
    if( token ){
        config.headers.Authorization = token
    }

    return config
})

stations.interceptors.request.use((config) =>{
    const token = Cookies.get('token')
    if( token ){
        config.headers.Authorization = token
    }

    return config
})