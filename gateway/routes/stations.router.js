const stationsRouter = require("express").Router()
const stationsController = require("../controllers/stations.controller")
const auth = require("../middleware/auth")

stationsRouter.use(auth)

stationsRouter.get("/all", stationsController.getStations)
stationsRouter.get("/free", stationsController.getFreeStations)
stationsRouter.get("/by_id/:id", stationsController.getStationById)
stationsRouter.post("/create", stationsController.createStation)
stationsRouter.put("/update", stationsController.updateStationById)
stationsRouter.delete("/delete/all", stationsController.deleteAll)
stationsRouter.delete("/delete/by_id/:id", stationsController.deleteStationById)

stationsRouter.patch("/return/:id", stationsController.return)
stationsRouter.patch("/rent/:id", stationsController.rent)

module.exports = stationsRouter