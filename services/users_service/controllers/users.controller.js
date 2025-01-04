const User = require("../models/users.model")
const UserDTOResponse = require("../dto/users.dto_response")
const UserDTORequest = require("../dto/users.dto_request")
const UserDTORequestUpdate = require("../dto/users.dto_request_update")
const UserDTORequestUpdatePassword = require("../dto/users.dto_request_update_password")


exports.getAll = (req, res) => {
    User.getAll((err, users) => {
        if (err) {
            res.status(500).send({
                message:
                    err.message || "Some error occurred while retrieving users."
            });
        }
        else {
            const usersDTO = users.map(user => new UserDTOResponse(user))
            res.status(200).send(usersDTO)
        };
    })
}

exports.getById = (req, res) => {
    User.getById(req.params.id, (err, user) => {
        if (err) {
            if (err.kind === "not_found") {
                res.status(404).send({
                    message: `User with id ${req.params.id} not found.`
                });
            } else {
                res.status(500).send({
                    message: "Error retrieving user with id " + req.params.id
                });
            }
        }
        else {
            const userDTO = new UserDTOResponse(user)
            res.status(200).send(userDTO)
        };
    })
}

exports.create = (req, res) => {
    const userRequest = new UserDTORequest({
        name: req.body.name,
        surname: req.body.surname,
        email: req.body.email,
        password: req.body.password,
    });

    User.create(userRequest, (err, newUser) => {
        if (err) {
            if (err.kind === "duplicate_entry") {
                res.status(412).send({
                    message: `User with email: ${userRequest.email} already exists.`
                });
            } else {
                res.status(500).send({
                    message: "Some error occurred while creating the User."
                });
            }
        }
        else {
            const userDTO = new UserDTOResponse(newUser)
            res.status(201).send(userDTO);
        };
    })
}
exports.updateRent = (req, res) => {
    User.updateRent(req.params.id, (err, data) => {
        if (err) {
            if (err.kind === "not_found") {
                res.status(404).send({
                    message: `User with id ${req.params.id} not found.`
                });
            }
            else {
                res.status(500).send({
                    message: "Error updating rent count for user with id " + req.params.id
                });
            }
        }else{
            res.status(204).send()
        }
    })
}
exports.updateById = (req, res) => {
    const userRequest = new UserDTORequestUpdate({
        name: req.body.name,
        surname: req.body.surname,
        email: req.body.email,
    });

    User.updateById(req.params.id, userRequest, (err, updatedUser) => {
        if (err) {
            if (err.kind === "not_found") {
                res.status(404).send({
                    message: `User with id ${req.params.id} not found.`
                });

            }
            else if (err.kind === "duplicate_entry") {
                res.status(412).send({
                    message: `User with email: ${userRequest.email} already exists.`
                });
            }
            else {
                res.status(500).send({
                    message: "Error updating user with id " + req.params.id
                });
            }
        } else {
            res.status(204).send(updatedUser)
        };
    })
}

exports.updatePasswordById = (req, res) => {
    const userRequest = new UserDTORequestUpdatePassword({
        oldPassword: req.body.oldPassword,
        newPassword: req.body.newPassword
    })

    User.updatePasswordById(req.params.id, userRequest, (err, updatedUser) => {
        if (err) {
            if (err.kind === "not_found") {
                res.status(404).send({
                    message: `User with id ${req.params.id} not found.`
                });
            }
            else if (err.kind === "wrong_password") {
                res.status(401).send({
                    message: `wrong password.`
                });
            }
            else {
                res.status(500).send({
                    message: "Error updating user with id " + req.params.id
                });
            }
        } else {
            res.status(204).send()
        };
    })
}

exports.deleteById = (req, res) => {
    User.deleteById(req.params.id, (err, data) => {
        if (err) {
            if (err.kind === "not_found") {
                res.status(404).send({
                    message: `user with id ${req.params.id} not found.`
                });
            } else {
                res.status(500).send({
                    message: "Could not delete user with id " + req.params.id
                });
            }
        } else {
            res.status(200).send({ message: `User with id ${req.params.id} deleted successfully!` })
        };
    })
}

exports.deleteAll = (req, res) => {
    User.deleteAll((err, data) => {
        if (err) {
            res.status(500).send({
                message:
                    err.message || "Some error occurred while removing users."
            });
        }
        else {
            res.status(200).send({ message: `Deleted ${data.affectedRows} users!` });
        }
    })
}

exports.auth = (req, res) => {
    User.auth(req.body.email, req.body.password, (err, user) => {
        if (err) {
            if (err.kind === "wrong_password") {
                res.status(401).send({
                    message: `wrong password.`
                });
            }
            else if (err.kind === "not_found") {
                res.status(404).send({
                    message: `user not found.`
                });
            }
            else {
                res.status(500).send({
                    message: "Error retrieving user"
                });
            }
        } else {
            const userDTO = new UserDTOResponse(user)
            res.status(200).send(userDTO)
        }
    })
}

