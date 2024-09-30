const statusCodeMapper = (code) => {
    switch (code) {
        case 0:
            return 200
        case 1:
            return 499
        case 2:
            return 500
        case 3:
            return 400
        case 4:
            return 504
        case 5:
            return 404
        case 6:
            return 409
        case 7:
            return 403
        case 8:
            return 429
        case 9:
            return 400
        case 10:
            return 409
        case 11:
            return 400
        case 12:
            return 501
        case 13:
            return 500
        case 14:
            return 503
        case 15:
            return 500
        case 16:
            return 401
        default:
            return 500
    }
}

module.exports = statusCodeMapper