const rentalsRouter = require("express").Router()
const rentalsController = require("../controllers/rentals.controller")
const auth = require("../middleware/auth")

rentalsRouter.use(auth)

rentalsRouter.get("/get/user/:id", rentalsController.getRentalByUserId)
rentalsRouter.get("/exists/:id", rentalsController.existsByUserId)
rentalsRouter.get("/get/all", rentalsController.getAllRentals)
rentalsRouter.get("/get/:id", rentalsController.getRentalById)
rentalsRouter.put("/update/:id", rentalsController.updateRental)
rentalsRouter.post("/create", rentalsController.createRental) 
rentalsRouter.delete("/delete/:id", rentalsController.deleteRentalById)
rentalsRouter.delete("/delete/all", rentalsController.getDeleteAllRentals)

module.exports = rentalsRouter