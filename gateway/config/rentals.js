const axios = require('axios')

const rentals = axios.create({
    baseURL: process.env.RENTALS_URI,
    timeout: 5000,
})

module.exports = rentals