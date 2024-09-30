const path = require('path');
const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');


const packageDefinition = protoLoader.loadSync(path.join(__dirname, 'bikes.proto'), {
    keepCase: true,
    longs: String,
    enums: String,
    defaults: true,
    oneofs: true
});
const bikesProto = grpc.loadPackageDefinition(packageDefinition);
const bikesClient = new bikesProto.Bikes("localhost:9000", grpc.credentials.createInsecure());

module.exports = bikesClient