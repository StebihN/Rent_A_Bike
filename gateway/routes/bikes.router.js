const bikeRouter = require("express").Router()
const bikesController = require("../controllers/bikes.controller")
const auth = require("../middleware/auth")

bikeRouter.use(auth)

bikeRouter.get("/all", bikesController.getAllBikes)
bikeRouter.get("/by_location/:location", bikesController.getByLocation)
bikeRouter.get("/by_id/:id", bikesController.getById)

bikeRouter.post("/create", bikesController.create)
bikeRouter.put("/update", bikesController.updateById)

bikeRouter.delete("/delete/all", bikesController.deleteAll)
bikeRouter.delete("/delete/by_location/:location", bikesController.deleteByLocation)
bikeRouter.post("/delete/by_id/:id", bikesController.deleteById)

bikeRouter.post("/to_service", bikesController.toService)
bikeRouter.post("/to_station", bikesController.toStation)

bikeRouter.post("/rent", bikesController.rentBike)
bikeRouter.post("/return", bikesController.returnBike)

module.exports = bikeRouter