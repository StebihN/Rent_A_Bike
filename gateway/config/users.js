const axios = require('axios')

const users = axios.create({
    baseURL: process.env.USERS_URI,
    timeout: 5000,
})

module.exports = users