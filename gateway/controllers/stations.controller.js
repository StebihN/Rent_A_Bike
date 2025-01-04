const stations = require("../config/stations")

exports.getStations = (req, res) => {
    stations.get("/get/all")
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

exports.getFreeStations = (req, res) => {
    stations.get("/get/free")
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
    stations.get("/get/" + req.params.id)
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
        id: req.body.id,
        name: req.body.name,
        latitude: req.body.latitude,
        longitude: req.body.longitude,
        slotCount: req.body.slotCount,
    }
    stations.post("/create", station)
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
        name: req.body.name,
        latitude: req.body.latitude,
        longitude: req.body.longitude,
        slotCount: req.body.slotCount,
        bikeCount: req.body.bikeCount
    }

    stations.put("/update", station)
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
    stations.delete("/delete/" + req.params.id)
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
    stations.delete("/delete/all")
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

exports.return = (req, res) => {

    stations.patch("/return/" + req.params.id)
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

exports.rent = (req, res) => {
    stations.patch("/rent/" + req.params.id)
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