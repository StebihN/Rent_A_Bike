const bikeRouter = require("express").Router()
const bikesController = require("../controllers/bikes.controller")

bikeRouter.get("/all", bikesController.getAllBikes)
bikeRouter.get("/by_location/:location", bikesController.getByLocation)
bikeRouter.get("/by_id/:id", bikesController.getById)
bikeRouter.post("/create", bikesController.create)
bikeRouter.put("/update", bikesController.updateById)
bikeRouter.put("/update/rating", bikesController.updateRatingById)
bikeRouter.delete("/delete/all", bikesController.deleteAll)
bikeRouter.delete("/delete/by_location/:location", bikesController.deleteByLocation)
bikeRouter.delete("/delete/by_id/:id", bikesController.deleteById)

module.exports = bikeRouter