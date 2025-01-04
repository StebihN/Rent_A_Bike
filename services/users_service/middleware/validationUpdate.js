const { checkSchema, validationResult } = require("express-validator");

const schema = {
    name:{
        exists:{
            errorMessage: "name is required!"
        },
        notEmpty:{
            errorMessage: "name must not be empty!"
        },
    },
    surname:{
        exists:{
            errorMessage: "surname is required!"
        },
        notEmpty:{
            errorMessage: "surname must not be empty!"
        },
    },
    email:{
        exists:{
            errorMessage: "email is required!"
        },
        notEmpty:{
            errorMessage: "email must not be empty!"
        },
        isEmail:{
            errorMessage: "email is not correct!"
        }
    }
}


const validateUpdate = () => {
    return [
        checkSchema(schema),
        (req, res, next) => {
            const errors = validationResult(req);
            if(!errors.isEmpty()){
                return res.status(422).json({errors: errors.mapped()})
            }
            next()
        }
    ]
}


module.exports = validateUpdate()
