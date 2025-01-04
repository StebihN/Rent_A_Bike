import axios from 'axios'
import Cookies from 'js-cookie'

export const users = axios.create({
    baseURL: process.env.GATEWAY_URI + '/users',
    timeout: 5000,
})

users.interceptors.request.use((config) =>{
    const token = Cookies.get('token')
    if( token ){
        config.headers.Authorization = token
    }

    return config
})
