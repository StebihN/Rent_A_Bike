const stationsRouter = require("express").Router()
const stationsController = require("../controllers/stations.controller")

stationsRouter.get("/all", stationsController.getStations)
stationsRouter.get("/by_id/:id",stationsController.getStationById)
stationsRouter.post("/create", stationsController.createStation)
stationsRouter.put("/update", stationsController.updateStationById)
stationsRouter.delete("/delete/all", stationsController.deleteAll)
stationsRouter.delete("/delete/by_id/:id", stationsController.deleteStationById)
stationsRouter.post("/add", stationsController.addBike)
stationsRouter.post("/remove", stationsController.removeBike)

module.exports = stationsRouter