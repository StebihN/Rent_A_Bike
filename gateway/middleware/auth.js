const jwt = require('jsonwebtoken');
const secret = "my_secret"

const authorization = async (req, res, next) => {
	try {
		const token = req.header('Authorization');
		if (!token) {
			return res.status(401).json({ error: 'You are not authorized!' });
		}

		jwt.verify(token, secret);

		next();
	} catch (error) {
		console.error(error.message);
		return res.status(401).json({ error: 'invalid token' });
	}
};

module.exports = authorization