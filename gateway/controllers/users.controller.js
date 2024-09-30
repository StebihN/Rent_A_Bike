const axios = require('axios');
const generateJwt = require('../util/generateJwt')

exports.getUserById = (req, res) => {
    axios.get("http://localhost:3001/users/get/" + req.params.id)
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
    axios.get("http://localhost:3001/users/get")
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
    axios.post("http://localhost:3001/users/login", user)
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
    axios.post("http://localhost:3001/users/create", user)
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
exports.updateUserById = (req, res) => {
    const user = {
        name: req.body.name,
        surname: req.body.surname,
        email: req.body.email,
        password: req.body.password
    };
    axios.put("http://localhost:3001/users/update/" + req.params.id, user)
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
    axios.delete("http://localhost:3001/users/delete/" + req.params.id)
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
    axios.delete("http://localhost:3001/users/delete")
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