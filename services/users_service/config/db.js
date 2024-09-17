const mysql = require("mysql2")
const debug = require('debug')('users-service:database');

const connection = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "root",
    database: "users",
    port: "3306"
});

connection.connect(error => {
    if (error) {
        debug(`connectionRequest Failed ${error.stack}`)
    } else {
        debug("Successfully connected to the database.");
    }
});



module.exports = connection