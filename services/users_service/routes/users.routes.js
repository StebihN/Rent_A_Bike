const router = require("express").Router()
const validate = require("../middleware/validation")
const validateAuth = require("../middleware/validationAuth")
const controller = require("../controllers/users.controller")


router.get('/get', controller.getAll);
router.get('/get/:id', controller.getById);

router.post('/login', validateAuth, controller.auth);
router.post('/create', validate, controller.create);

router.put('/update/:id', validate, controller.updateById);
router.delete('/delete', controller.deleteAll);
router.delete('/delete/:id', controller.deleteById);


module.exports = router;
