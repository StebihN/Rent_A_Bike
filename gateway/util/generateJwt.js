const jwt = require('jsonwebtoken')

const generateJwt = (user) => {
    const payload = {
        id: user.id,
        name: user.name,
        surname: user.surname,
        email: user.email,
        bikesRented: user.bikesRented
    };
    const secret = "secret"
    return jwt.sign(payload, secret, { expiresIn: '1hr' });
}

module.exports = generateJwt;