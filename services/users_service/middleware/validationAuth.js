const { checkSchema, validationResult } = require("express-validator");

const schemaAuth = {
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
    },
    password:{
        exists:{
            errorMessage: "password is required!"
        },
        notEmpty:{
            errorMessage: "password must not be empty!"
        },
    }
}

const validateAuth = () => {
    return [
        checkSchema(schemaAuth),
        (req, res, next) => {
            const errors = validationResult(req);
            if(!errors.isEmpty()){
                return res.status(422).json({errors: errors.mapped()})
            }
            next()
        }
    ]
}

module.exports = validateAuth()
