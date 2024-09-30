const axios = require('axios');

exports.getStations = (req, res) => {
    axios.get("http://localhost:8080/stations/get/all")
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

exports.getStationById = (req, res) => {
    axios.get("http://localhost:8080/stations/get/" + req.params.id)
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

exports.createStation = (req, res) => {
    const station = {
        city: req.body.city,
        street: req.body.street,
        latitude: req.body.latitude,
        longitude: req.body.longitude,
        slotCount: req.body.slotCount,
        bikeCount: req.body.bikeCount
    }
    axios.post("http://localhost:8080/stations/create", station)
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

exports.updateStationById = (req, res) => {
    let station = {
        id: req.body.id,
        city: req.body.city,
        street: req.body.street,
        latitude: req.body.latitude,
        longitude: req.body.longitude,
        slotCount: req.body.slotCount,
        bikeCount: req.body.bikeCount
    }
    axios.put("http://localhost:8080/stations/update", station)
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

exports.deleteStationById = (req, res) => {
    axios.delete("http://localhost:8080/stations/delete/" + req.params.id)
        .then((response) => {
            res.status(204).send(response.data)
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
    axios.delete("http://localhost:8080/stations/delete/all")
        .then((response) => {
            res.status(204).send(response.data)
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

exports.addBike = (req, res) => {
    const request = {
        id: req.body.id,
        stationId: req.body.stationId
    }
    axios.post("http://localhost:8080/stations/add", request)
        .then((response) => {
            res.status(203).send(response.data)
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

exports.removeBike = (req, res) => {
    const request = {
        id: req.body.id,
        stationId: req.body.stationId
    }
    axios.post("http://localhost:8080/stations/remove", request)
        .then((response) => {
            res.status(203).send(response.data)
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