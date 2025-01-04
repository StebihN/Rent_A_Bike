const mysql = require("mysql2")
const debug = require('debug')('users-service:database');

const connection = mysql.createConnection({
    host: process.env.MYSQL_HOST,
    user: process.env.MYSQL_USER,
    password: process.env.MYSQL_PASS,
    database: process.env.MYSQL_DB,
    port: process.env.MYSQL_PORT
});

connection.connect(error => {
    if (error) {
        debug(`connectionRequest Failed ${error.stack}`)
    } else {
        debug("Successfully connected to the database.");
    }
});



module.exports = connection