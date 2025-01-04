const axios = require('axios')

const stations = axios.create({
    baseURL: process.env.STATIONS_URI,
    timeout: 5000,
})

module.exports = stations