const bikesClient = require('../proto/client')
const statusCodeMapper = require("../util/statusCodeMapper")


exports.getAllBikes = (req, res) => {
    bikesClient.GetAll({}, (err, bikes) => {
        if (err) {
            res.status(statusCodeMapper(err.code)).json({message: err.details})
        } else {
            res.status(200).send(bikes)
        }
    });
}

exports.getByLocation = (req, res) => {
    bikesClient.getByLocation({ value: req.params.location }, (err, bikes) => {
        if (err) {
            res.status(statusCodeMapper(err.code)).json({message: err.details})
        } else {
            res.status(200).send(bikes)
        }
    })
}

exports.getById = (req, res) => {
    bikesClient.getById({ value: req.params.id }, (err, bike) => {
        if (err) {
            res.status(statusCodeMapper(err.code)).json({message: err.details})
        } else {
            res.status(200).send(bike)
        }
    })
}

exports.updateById = (req, res) => {
    const bikeRequest = {
        id: req.body.id,
        locationId: req.body.locationId,
        name: req.body.name
    }
    bikesClient.updateById(bikeRequest, (err, bike) => {
        if (err) {
            res.status(statusCodeMapper(err.code)).json({message: err.details})
        } else {
            res.status(200).send(bike)
        }
    })
}

exports.updateRatingById = (req, res) => {
    const bikeUpdateRatingRequest = {
        id: req.body.id,
        rating: req.body.rating
    }
    bikesClient.updateRatingById(bikeUpdateRatingRequest, (err, bike) => {
        if (err) {
            res.status(statusCodeMapper(err.code)).json({message: err.details})
        } else {
            res.status(200).send(bike)
        }
    })
}

exports.create = (req, res) => {
    const bikeRequest = {
        id: req.body.id,
        locationId: req.body.locationId,
        name: req.body.name
    }
    bikesClient.create(bikeRequest, (err, bike) => {
        if (err) {
            res.status(statusCodeMapper(err.code)).json({message: err.details})
        } else {
            res.status(200).send(bike)
        }
    })
}

exports.deleteAll = (req, res) => {
    bikesClient.deleteAll({}, (err, bike) => {
        if (err) {
            res.status(statusCodeMapper(err.code)).json({message: err.details})
        } else {
            res.sendStatus(200)
        }
    })
}

exports.deleteByLocation = (req, res) => {
    bikesClient.deleteByLocation({ value: req.params.location }, (err, bike) => {
        if (err) {
            res.status(statusCodeMapper(err.code)).json({message: err.details})
        } else {
            res.sendStatus(200)
        }
    })
}

exports.deleteById = (req, res) => {
    bikesClient.deleteById({ value: req.params.id }, (err, bike) => {
        if (err) {
            res.status(statusCodeMapper(err.code)).json({message: err.details})
        } else {
            res.sendStatus(200)
        }
    })
}