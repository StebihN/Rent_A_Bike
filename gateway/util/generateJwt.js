const jwt = require('jsonwebtoken')

const generateJwt = (user) => {
    const payload = {
        id: user.id,
    };
    const secret = "my_secret"
    return jwt.sign(payload, secret, { expiresIn: '1hr' });
}

module.exports = generateJwt;