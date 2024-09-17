const crypto = require("crypto");


const data = [
    {
        id: 1,
        name: "John",
        surname: "Doe",
        email: "john.doe@example.com",
        password: "password123",
        password_salt: "salt123",
        bikes_rented: 3
    },
    {
        id: 2,
        name: "Jane",
        surname: "Smith",
        email: "jane.smith@example.com",
        password: "securepass456",
        password_salt: "salt456",
        bikes_rented: 1
    },
    {
        id: 3,
        name: "Michael",
        surname: "Brown",
        email: "michael.brown@example.com",
        password: "mypass789",
        password_salt: "salt789",
        bikes_rented: 2
    }
];

class User {
    constructor(user) {
        this.id = user.id;
        this.name = user.name;
        this.surname = user.surname;
        this.email = user.email;
        this.password = user.password;
        this.passwordSalt = user.password_salt
        this.bikesRented = user.bikes_rented;
    }

    static getAll(callback) {
        const users = data.map(user => new User(user))
        callback(null, users)
    }

    static getById(id, callback) {
        const result = data.find((user) => user.id == id)
        if (result) {
            const user = new User(result)
            callback(null, user)
            return
        }

        callback({ kind: "not_found" }, null);
    }

    static create(user, callback) {
        const newUser = new User({ id: 4, password_salt: "salt", bikes_rented: 0, ...user })
        callback(null, newUser)
    }

    static updateById(id, user, callback) {
        const result = data.find((user) => user.id == id)
        if (result) {
            const user = new User(result)
            callback(null, user)
            return
        }

        callback({ kind: "not_found" }, null);
    }

    static deleteAll(callback) {
        const data = {
            affectedRows: 3
        }
        callback(null, data)
    }

    static deleteById(id, callback) {
        const result = data.find((user) => user.id == id)
        if (result) {
            callback(null, null)
            return
        }

        callback({ kind: "not_found" }, null);
    }

    static auth(email, password, callback) {
        const result = data.find((user) => user.email == email)
        if (result) {
            if (result.password == password) {
                const user = new User(result)
                callback(null, user)
                return
            } else{
                callback({ kind: "wrong_password" }, null)
                return
            }
        }
        callback({ kind: "not_found" }, null);
    }
}



module.exports = User;