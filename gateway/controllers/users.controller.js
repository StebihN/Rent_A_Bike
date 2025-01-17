const users = require("../config/users")
const generateJwt = require('../util/generateJwt')

exports.getUserById = (req, res) => {
    users.get("/get/" + req.params.id)
        .then((response) => {
            res.status(200).send(response.data);
        })
        .catch(error => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        })
}
exports.getUsers = (req, res) => {
    users.get("/get")
        .then((response) => {
            res.status(200).send(response.data);
        })
        .catch(error => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        })
}
exports.login = (req, res) => {
    const user = {
        email: req.body.email,
        password: req.body.password
    };
    users.post("/login", user)
        .then((response) => {
            res.status(200).send({ token: generateJwt(response.data) });
        })
        .catch(error => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        })
}

exports.createUser = (req, res) => {
    const user = {
        name: req.body.name,
        surname: req.body.surname,
        email: req.body.email,
        password: req.body.password
    };
    users.post("/create", user)
        .then((response) => {
            res.status(201).send(response.data);
        })
        .catch(error => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        })
}

exports.updateRent = (req, res) => {
    users.patch("/update/rent/" + req.params.id)
        .then((response) => {
            res.status(204).send(response.data);
        })
        .catch((error) => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        });
}

exports.updateUserById = (req, res) => {
    const user = {
        name: req.body.name,
        surname: req.body.surname,
        email: req.body.email,
    };
    users.put("/update/" + req.params.id, user)
        .then((response) => {
            res.status(203).send(response.data);
        })
        .catch(error => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        })
}

exports.updatePasswordById = (req, res) => {
    const password = {
        oldPassword: req.body.oldPassword,
        newPassword: req.body.newPassword
    };
    
    users.put("/update/password/" + req.params.id, password)
        .then((response) => {
            res.status(203).send(response.data);
        })
        .catch(error => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        })
}

exports.deleteUserById = (req, res) => {
    users.delete("/delete/" + req.params.id)
        .then((response) => {
            res.status(200).send(response.data);
        })
        .catch(error => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        })
}

exports.deleteAll = (req, res) => {
    users.delete("/delete")
        .then((response) => {
            res.status(200).send(response.data);
        })
        .catch(error => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        })
}

