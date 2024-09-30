const jwt = require('jsonwebtoken');
const secret = process.env.JWT_SECRET

const authorization = async (req, res, next) => {
	try {
		const token = req.header('token');

		if (!token) {
			return res.status(403).json({ error: 'You are not authorized!' });
		}

		const payload = jwt.verify(token, secret);

		req.user = payload.user;
		next();
	} catch (error) {
		console.error(error.message);
		return res.status(500).json({ error: 'invalid token' });
	}
	next();
};

module.exports = authorization