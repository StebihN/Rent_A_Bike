const usersRouter = require("express").Router()
const usersController = require("../controllers/users.controller")

usersRouter.get("/all", usersController.getUsers)
usersRouter.get("/by_id/:id", usersController.getUserById)
usersRouter.post("/login", usersController.login)
usersRouter.post("/create", usersController.createUser)
usersRouter.put("/update/:id", usersController.updateUserById)
usersRouter.delete("/delete/all", usersController.deleteAll)
usersRouter.delete("/delete/by_id/:id", usersController.deleteUserById)

module.exports = usersRouter