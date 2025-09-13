const metricsRouter = require("express").Router()
const metricsController = require("../controllers/metrics.controller")

metricsRouter.get("", metricsController.getMetrics)

module.exports = metricsRouter