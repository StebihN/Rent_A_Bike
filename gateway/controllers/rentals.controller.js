const rentals = require("../config/rentals")

exports.getRentalByUserId = (req, res) => {
    rentals.get("/get/by_user/" + req.params.id)
        .then((response) => {
            res.status(200).send(response.data);
        }).catch((error) => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        });
}
exports.existsByUserId = (req, res) => {
    rentals.get("/exists/by_user/" + req.params.id)
        .then((response) => {
            res.status(204)
        }).catch((error) => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        });
}

exports.getRentalById = (req, res) => {
    rentals.get("/get/" + req.params.id)
        .then((response) => {
            res.status(200).send(response.data);
        }).catch((error) => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        });
}

exports.getAllRentals = (req, res) => {
    rentals.get("/get/all")
        .then((response) => {
            res.status(200).send(response.data);
        }).catch((error) => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        });
}

exports.updateRental = (req, res) => {
    const rental = {
        userId: req.body.userId,
        bikeId: req.body.bikeId,
        rentedOn: req.body.rentedOn
    }
    rentals.put("/update/" + req.params.id, rental)
        .then((response) => {
            res.status(203).send(response.data);
        }).catch((error) => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        });
}

exports.createRental = (req, res) => {
    const rental = {
        userId: req.body.userId,
        bikeId: req.body.bikeId,
        rentedOn: req.body.rentedOn
    }
    rentals.post("/create", rental)
        .then((response) => {
            res.status(201).send(response.data);
        }).catch((error) => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        });

}

exports.deleteRentalById = (req, res) => {
    rentals.delete("/delete/" + req.params.id)
        .then((response) => {
            res.status(204).send(response.data)
        }).catch((error) => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        });
}

exports.getDeleteAllRentals = (req, res) => {
    rentals.delete("/delete/all")
        .then((response) => {
            res.status(204).send(response.data)
        }).catch((error) => {
            if (error.response) {
                res.status(error.response.status).json(error.response.data)
            } else if (error.request) {
                res.status(503).json({ message: "Service unavailable" });
            } else {
                res.status(500).json({ message: "Some error occured while processing request" });
            }
        });
}
