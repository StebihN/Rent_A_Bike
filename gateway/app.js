var express = require('express');
var app = express();

const bikesRouter = require("./routes/bikes.router")
const stationsRouter = require("./routes/stations.router")
const usersRouter = require("./routes/users.router")

app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.use("/gateway/stations", stationsRouter)
app.use("/gateway/bikes", bikesRouter)
app.use("/gateway/users", usersRouter)


module.exports = app;
