const rentals = require('../config/rentals')
const stations = require('../config/stations')
const users = require("../config/users")
const bikesClient = require('../config/proto/client')
const statusCodeMapper = require("../util/statusCodeMapper")


exports.getAllBikes = (req, res) => {
    bikesClient.GetAll({}, (err, bikes) => {
        if (err) {
            res.status(statusCodeMapper(err.code)).json({ message: err.details })
        } else {
            res.status(200).send(bikes)
        }
    });
}

exports.getByLocation = (req, res) => {
    bikesClient.getByLocation({ value: req.params.location }, (err, bikes) => {
        if (err) {
            res.status(statusCodeMapper(err.code)).json({ message: err.details })
        } else {
            res.status(200).send(bikes)
        }
    })
}

exports.getById = (req, res) => {
    bikesClient.getById({ value: req.params.id }, (err, bike) => {
        if (err) {
            res.status(statusCodeMapper(err.code)).json({ message: err.details })
        } else {
            res.status(200).send(bike)
        }
    })
}

exports.updateById = (req, res) => {
    const bikeRequest = {
        id: req.body.id,
        stationId: req.body.stationId,
        ...(req.body.rating) && { rating: req.body.rating },
        ...(req.body.totalTimeRented) && { totalTimeRented: req.body.totalTimeRented }
    }

    bikesClient.updateById(bikeRequest, (err, bike) => {
        if (err) {
            res.status(statusCodeMapper(err.code)).json({ message: err.details })
        } else {
            res.status(200).send(bike)
        }
    })
}



exports.create = async (req, res) => {
    try {
        await stations.patch("/return/" + req.body.stationId)
        bikesClient.create({ stationId: req.body.stationId }, (err, bike) => {
            if (err) {
                res.status(statusCodeMapper(err.code)).json({ message: err.details })
            } else {
                res.status(200).send(bike)
            }
        })
    } catch (error) {
        if (error.response) {
            res.status(error.response.status).json(error.response.data)
        } else if (error.request) {
            res.status(503).json({ message: "Service unavailable" });
        } else {
            res.status(500).json({ message: "Some error occured while processing request" });
        }
    }
}

exports.deleteAll = (req, res) => {
    bikesClient.deleteAll({}, (err, bike) => {
        if (err) {
            res.status(statusCodeMapper(err.code)).json({ message: err.details })
        } else {
            res.sendStatus(200)
        }
    })
}

exports.deleteByLocation = (req, res) => {
    bikesClient.deleteByLocation({ value: req.params.location }, (err, bike) => {
        if (err) {
            res.status(statusCodeMapper(err.code)).json({ message: err.details })
        } else {
            res.sendStatus(200)
        }
    })
}

exports.deleteById = async (req, res) => {
    try {
        await stations.patch("/rent/" + req.body.stationId)
        bikesClient.deleteById({ value: req.body.bikeId }, (err, bike) => {
            if (err) {
                res.status(statusCodeMapper(err.code)).json({ message: err.details })
            } else {
                res.sendStatus(200)
            }
        })
    } catch (error) {
        if (error.response) {
            res.status(error.response.status).json(error.response.data)
        } else if (error.request) {
            res.status(503).json({ message: "Service unavailable" });
        } else {
            res.status(500).json({ message: "Some error occured while processing request" });
        }
    }
}

exports.toService = async (req, res) => {
    try {
        await stations.patch("/rent/" + req.body.stationId)
        bikesClient.updateById({ id: req.body.bikeId, stationId: "service" }, (err, bike) => {
            if (err) {
                res.status(statusCodeMapper(err.code)).json({ message: err.details })
            } else {
                res.status(200).send(bike)

            }
        })

    } catch (error) {
        if (error.response) {
            res.status(error.response.status).json(error.response.data)
        } else if (error.request) {
            res.status(503).json({ message: "Service unavailable" });
        } else {
            res.status(500).json({ message: "Some error occured while processing request" });
        }
    }

}

exports.toStation = async (req, res) => {
    try {
        bikesClient.updateById({ id: req.body.bikeId, stationId: req.body.stationId }, (err, bike) => {
            if (err) {
                res.status(statusCodeMapper(err.code)).json({ message: err.details })
            } else {
                res.status(200).send(bike)

            }
        })

        await stations.patch("/return/" + req.body.stationId)
    } catch (error) {
        if (error.response) {
            res.status(error.response.status).json(error.response.data)
        } else if (error.request) {
            res.status(503).json({ message: "Service unavailable" });
        } else {
            res.status(500).json({ message: "Some error occured while processing request" });
        }
    }

}

exports.rentBike = async (req, res) => {
    try {
        await rentals.get("/exists/by_user/" + req.body.userId)
        await stations.patch("/rent/" + req.body.stationId)

        bikesClient.updateById({ id: req.body.bikeId, stationId: "rented" }, (error, bike) => {
            if (error) {
                res.status(statusCodeMapper(error.code)).json({ message: error.details })
            }
        })
        const rental = {
            userId: req.body.userId,
            bikeId: req.body.bikeId,
            rentedOn: req.body.rentedOn,
            stationId: req.body.stationId
        }
        const responseOne = await rentals.post("/create", rental)
        res.status(200).send(responseOne.data)
    } catch (error) {
        if (error.response) {
            res.status(error.response.status).json(error.response.data)
        } else if (error.request) {
            res.status(503).json({ message: "Service unavailable" });
        } else {
            res.status(500).json({ message: "Some error occured while processing request" });
        }
    }
}

exports.returnBike = async (req, res) => {
    try {
        const totalTimeRented = Date.now() - req.body.rentedOn
        await stations.patch("/return/" + req.body.stationId)

        bikesClient.updateById({ id: req.body.bikeId, stationId: req.body.stationId, totalTimeRented: totalTimeRented, ...(req.body.rating) && { rating: req.body.rating }, }, (error, bike) => {
            if (error) {
                res.status(statusCodeMapper(error.code)).json({ message: error.details })
            }
        })

        await users.patch("/update/rent/" + req.body.userId)
        await rentals.delete("/delete/" + req.body.id)
        res.status(200).send({ message: "success" })
    } catch (error) {
        if (error.response) {
            res.status(error.response.status).json(error.response.data)
        } else if (error.request) {
            res.status(503).json({ message: "Service unavailable" });
        } else {
            res.status(500).json({ message: "Some error occured while processing request" });
        }
    }
}
