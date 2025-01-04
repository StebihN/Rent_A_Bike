import axios from 'axios'
import Cookies from 'js-cookie'


export const stations = axios.create({
    baseURL: process.env.GATEWAY_URI + '/stations',
    timeout: 5000,

})

stations.interceptors.request.use((config) =>{
    const token = Cookies.get('token')
    if( token ){
        config.headers.Authorization = token
    }

    return config
})


export const coordinates = axios.create({
    baseURL: 'https://geocode.maps.co',
    timeout: 5000,
})