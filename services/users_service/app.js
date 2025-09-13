require('dotenv').config();
const express = require('express');
const usersRouter = require('./routes/users.routes');
const metricsRouter = require('./routes/metrics.routes');



const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.use('/metrics', metricsRouter)
app.use('/users', usersRouter);

module.exports = app;