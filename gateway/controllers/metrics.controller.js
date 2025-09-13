const client = require('prom-client');
const register = new client.Registry();

client.collectDefaultMetrics({ register });

exports.getMetrics = async (req, res) => {
    res.set('Content-Type', register.contentType);
    res.end(await register.metrics());
}