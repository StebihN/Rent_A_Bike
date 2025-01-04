const usersRouter = require("express").Router()
const usersController = require("../controllers/users.controller")
const auth = require("../middleware/auth")


usersRouter.post("/login", usersController.login)
usersRouter.post("/create", usersController.createUser)

usersRouter.use(auth)

usersRouter.get("/all", usersController.getUsers)
usersRouter.get("/by_id/:id", usersController.getUserById)

usersRouter.put("/update/:id", usersController.updateUserById)
usersRouter.patch("/update/rent/:id", usersController.updateRent)
usersRouter.put("/update/password/:id", usersController.updatePasswordById)

usersRouter.delete("/delete/all", usersController.deleteAll)
usersRouter.delete("/delete/by_id/:id", usersController.deleteUserById)


module.exports = usersRouter