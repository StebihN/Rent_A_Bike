const sql = require("../config/db");
const crypto = require("crypto");
const debug = require('debug')('users-service:database');

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

    static hashPasword(password, salt) {
        const usedSalt = salt || crypto.randomBytes(16).toString("hex");
        const hashedPassword = crypto.pbkdf2Sync(password, usedSalt, 10000, 64, "sha-512").toString("hex");

        return [hashedPassword, usedSalt]
    }

    static getAll(result) {
        sql.query("select * from users", (err, res) => {
            if (err) {
                debug("error:", err);
                result(err, null);
                return;
            }

            const users = res.map(user => new User(user))
            debug("Got all users from database");
            result(null, users);
        });
    }
    static getById(id, result) {
        sql.query("select * from users where id = ?", [id], (err, res) => {
            if (err) {
                debug("error:", err);
                result(err, null);
                return;
            }
            if (res.length) {
                const user = new User(res[0])
                debug("found user: ", user);
                result(null, user);
                return;
            }

            debug(`user with id ${id} not found!`);
            result({ kind: "not_found" }, null);
        });
    }

    static create(user, result) {
        const [password, salt] = this.hashPasword(user.password)

        sql.query("INSERT INTO users ( name, surname, email, password, password_salt, bikes_rented ) values (?,?,?,?,?,?)",
            [user.name, user.surname, user.email, password, salt, 0], (err, res) => {
                if (err) {
                    if (err.code == "ER_DUP_ENTRY") {
                        debug(`user with email: ${user.email} already exists`);
                        result({ kind: "duplicate_entry" }, null);
                        return
                    }

                    debug("error creating new user:", err);
                    result(err, null);
                    return
                }
                debug(`created new user with id: ${res.insertId}`, { id: res.insertId, ...user });
                result(null, { id: res.insertId, ...user })
            }
        )
    }
    static updateRent(id, result) {
        sql.query("UPDATE users SET bikes_rented = bikes_rented + 1 WHERE id = ?", [id], (err, res) => {
            if (err) {
                debug("error: ", err);
                result(null, err);
                return;
            }
            if (res.affectedRows == 0) {
                debug(`user with id ${id} not found!`);
                result({ kind: "not_found" }, null);
                return;
            }
            debug(`increased number of bikes rented for user with id: ${id}`);
            result(null, res);
        })
    }
    static updateById(id, user, result) {
        sql.query("UPDATE users SET name = ?, surname = ?, email = ? WHERE id = ?",
            [user.name, user.surname, user.email, id], (err, res) => {
                if (err) {
                    if (err.code == "ER_DUP_ENTRY") {
                        debug(`user with email: ${user.email} already exists`);
                        result({ kind: "duplicate_entry" }, null);
                        return
                    }

                    debug("error: ", err);
                    result(null, err);
                    return;
                }

                if (res.affectedRows == 0) {
                    debug(`user with id ${id} not found!`);
                    result({ kind: "not_found" }, null);
                    return;
                }

                debug(`updated user with id: ${id}`, { id: id, ...user });
                result(null, { id: id, ...user });
            })
    }

    static updatePasswordById(id, user, result) {
        this.getById(id, (err, retrievedUser) => {
            if (err) {
                if (err.kind === "not_found") {
                    result({ kind: "not_found" }, null);
                } else {
                    result(null, err);
                }
            } else {       
                const [hashedPassword, salt] = this.hashPasword(user.oldPassword, retrievedUser.passwordSalt);
                const storedPassword = retrievedUser.password

                if (storedPassword === hashedPassword) {
                    const [newPassword, newSalt] = this.hashPasword(user.newPassword)
                    sql.query("UPDATE users SET password = ?, password_salt = ? WHERE id = ?",
                        [newPassword, newSalt, id], (err, res) => {
                            if (err) {
                                debug("error: ", err);
                                result(null, err);
                                return;
                            }

                            debug(`updated password for user with id: ${id}`, { id: id, ...retrievedUser });
                            result(null, { id: id, ...retrievedUser });
                        })
                } else {
                    debug(`error updating password for user: wrong password`);
                    result({ kind: "wrong_password" }, null)
                }
                return
            }
        })
    }

    static deleteAll(result) {
        sql.query("DELETE FROM users", (err, res) => {
            if (err) {
                debug("error:", err);
                result(err, null);
                return;
            }

            debug(`deleted ${res.affectedRows} users`);
            result(null, res);
        });
    }

    static deleteById(id, result) {
        sql.query("delete from users where id = ?", [id], (err, res) => {
            if (err) {
                debug("error:", err);
                result(err, null);
                return;
            }
            if (res.affectedRows == 0) {
                debug(`user with id ${id} not found!`);
                result({ kind: "not_found" }, null);
                return;
            }

            debug(`deleted user with id: ${id}`);
            result(null, res);
        });
    }

    static auth(email, password, result) {
        sql.query("select * from users where email = ?", [email], (err, res) => {
            if (err) {
                debug("error authenticating user:", err);
                result(err, null);
                return
            }
            if (res.length) {
                const [hashedPassword, salt] = this.hashPasword(password, res[0].password_salt);
                const storedPassword = res[0].password
                if (storedPassword === hashedPassword) {
                    const user = res[0]
                    debug(`succesfully authenticated user with email: ${email}`, err);
                    result(null, user)
                } else {
                    debug(`error authenticating user: wrong password`);
                    result({ kind: "wrong_password" }, null)
                }
                return
            }

            debug(`user with email ${email} not found!`);
            result({ kind: "not_found" }, null)
        })
    }


}


module.exports = User;