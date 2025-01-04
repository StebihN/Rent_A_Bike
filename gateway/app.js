const cors = require('cors');
var express = require('express');
var app = express();
require('dotenv').config();

const bikesRouter = require("./routes/bikes.router")
const stationsRouter = require("./routes/stations.router")
const usersRouter = require("./routes/users.router")
const rentalsRouter = require("./routes/rentals.router");

app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cors({
    origin: '*'
}));


app.use("/gateway/stations", stationsRouter)
app.use("/gateway/bikes", bikesRouter)
app.use("/gateway/users", usersRouter)
app.use("/gateway/rentals", rentalsRouter)


module.exports = app;
