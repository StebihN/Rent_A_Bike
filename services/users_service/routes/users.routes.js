const router = require("express").Router()
const validate = require("../middleware/validation")
const validateAuth = require("../middleware/validationAuth")
const validateUpdate = require("../middleware/validationUpdate")
const controller = require("../controllers/users.controller")


router.get('/get', controller.getAll);
router.get('/get/:id', controller.getById);

router.post('/login', validateAuth, controller.auth);
router.post('/create', validate, controller.create);

router.put('/update/:id', validateUpdate, controller.updateById);
router.patch('/update/rent/:id', controller.updateRent);
router.put('/update/password/:id', controller.updatePasswordById);

router.delete('/delete', controller.deleteAll);
router.delete('/delete/:id', controller.deleteById);


module.exports = router;
