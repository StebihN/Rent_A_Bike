import axios from 'axios'
import Cookies from 'js-cookie'

export const rentals = axios.create({
    baseURL: 'http://localhost:3000/gateway/rentals',
    timeout: 5000,
})

rentals.interceptors.request.use((config) =>{
    const token = Cookies.get('token')
    if( token ){
        config.headers.Authorization = token
    }

    return config
})