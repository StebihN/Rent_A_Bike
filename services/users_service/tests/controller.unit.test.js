const controller = require("../controllers/users.controller");
const User = require("../models/users.model")

jest.mock("../models/users.model")

describe('Test GetAll', () => {
    beforeEach(() => {
        jest.restoreAllMocks()
    });

    it('should return a response ', () => {
        const req = {};
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.getAll(req, res);

        expect(res.status).toHaveBeenCalledWith(200)
        expect(res.send).toHaveBeenCalledWith(
            expect.arrayContaining([
                expect.objectContaining({
                    id: 1,
                    name: "John",
                    surname: "Doe",
                    email: "john.doe@example.com",
                    bikesRented: 3
                }),
                expect.objectContaining({
                    id: 2,
                    name: "Jane",
                    surname: "Smith",
                    email: "jane.smith@example.com",
                    bikesRented: 1
                }),
                expect.objectContaining({
                    id: 3,
                    name: "Michael",
                    surname: "Brown",
                    email: "michael.brown@example.com",
                    bikesRented: 2
                })
            ])
        );
    });

    it('should return an error response ', () => {
        const req = {};
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        jest.spyOn(User, "getAll").mockImplementationOnce((callback) => {
            callback({ kind: "mock" }, null)
        })

        controller.getAll(req, res);

        expect(res.status).toHaveBeenCalledWith(500)

    });

});

describe('Test GetById', () => {
    beforeEach(() => {
        jest.restoreAllMocks()
    });

    it('should return a response ', () => {
        const req = {
            params: {
                id: 1
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.getById(req, res)

        expect(res.status).toHaveBeenCalledWith(200)
        expect(res.send).toHaveBeenCalledWith(
            expect.objectContaining({
                id: 1,
                name: "John",
                surname: "Doe",
                email: "john.doe@example.com",
                bikesRented: 3
            })
        )
    });

    it('should return a not found response ', () => {
        const req = {
            params: {
                id: 5
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.getById(req, res)

        expect(res.status).toHaveBeenCalledWith(404)
    });

    it('should return an error response ', () => {
        const req = {
            params: {
                id: 5
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        jest.spyOn(User, "getById").mockImplementationOnce((id, callback) => {
            callback({ kind: "mock" }, null)
        })

        controller.getById(req, res);

        expect(res.status).toHaveBeenCalledWith(500)

    });
});

describe('Test Create', () => {
    beforeEach(() => {
        jest.restoreAllMocks()
    });

    it('should create new user ', () => {
        const req = {
            body: {
                name: "Sara",
                surname: "Church",
                email: "sara.church@example.com",
                password: "password123"
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.create(req, res)

        expect(res.status).toHaveBeenCalledWith(201)
        expect(res.send).toHaveBeenCalledWith(
            expect.objectContaining({
                id: 4,
                name: "Sara",
                surname: "Church",
                email: "sara.church@example.com",
                bikesRented: 0
            })
        )
    });

    it('should return a bad request response ', () => {
        const req = {
            body: {
                name: "Sara",
                surname: "Church",
                email: "sara.church@example.com",
                password: "password123"
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        jest.spyOn(User, "create").mockImplementationOnce((user, callback) => {
            callback({ kind: "duplicate_entry" }, null)
        })

        controller.create(req, res)

        expect(res.status).toHaveBeenCalledWith(412)
    });

    it('should return an error response ', () => {
        const req = {
            body: {
                name: "Sara",
                surname: "Church",
                email: "sara.church@example.com",
                password: "password123"
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        jest.spyOn(User, "create").mockImplementationOnce((user, callback) => {
            callback({ kind: "mock" }, null)
        })

        controller.create(req, res);

        expect(res.status).toHaveBeenCalledWith(500)

    });
});

describe('Test updateRent', () => {
    it('should return a response', () => {
        const req = {
            params: {
                id: 1
            }
        }
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.updateRent(req, res)

        expect(res.status).toHaveBeenCalledWith(204)
    })

    it('should return a not found response', () => {
        const req = {
            params: {
                id: 5
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.updateRent(req, res)

        expect(res.status).toHaveBeenCalledWith(404)
    })

    it('should return an error response', () => {
        const req = {
            params: {
                id: 5
            }
        };

        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        jest.spyOn(User, "updateRent").mockImplementationOnce((id, callback) => {
            callback({ kind: "mock" }, null)
        })

        controller.updateRent(req, res)

        expect(res.status).toHaveBeenCalledWith(500)
    })
})

describe('Test UpdateById', () => {
    it('should  return a response', () => {
        const req = {
            body: {
                name: "John",
                surname: "Doe",
                email: "john.doe12@example.com",
            },
            params: {
                id: 1
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.updateById(req, res)

        expect(res.status).toHaveBeenCalledWith(204)
        expect(res.send).toHaveBeenCalledWith(
            expect.objectContaining({
                id: 1,
                name: "John",
                surname: "Doe",
                email: "john.doe12@example.com",
                bikesRented: 3
            })
        )
    });

    it('should return a not found response ', () => {
        const req = {
            body: {
                name: "John",
                surname: "Doe",
                email: "john.doe@example.com",
                password: "password123"
            },
            params: {
                id: 5
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.updateById(req, res)

        expect(res.status).toHaveBeenCalledWith(404)
    });

    it('should return a duplicate entry response', () => {
        const req = {
            body: {
                name: "John",
                surname: "Doe",
                email: "john.doe@example.com",
                password: "password123"
            },
            params: {
                id: 1
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.updateById(req, res)

        expect(res.status).toHaveBeenCalledWith(412)
    })

    it('should return an error response ', () => {
        const req = {
            body: {
                name: "John",
                surname: "Doe",
                email: "john.doe@example.com",
                password: "password123"
            },
            params: {
                id: 6
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        jest.spyOn(User, "updateById").mockImplementationOnce((id, user, callback) => {
            callback({ kind: "mock" }, null)
        })

        controller.updateById(req, res);

        expect(res.status).toHaveBeenCalledWith(500)

    });
});

describe('Test UpdatePasswordById', () => {
    it('returns a response', () => {
        const req = {
            body: {
                oldPassword: "password123"
            },
            params: {
                id: 1
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.updatePasswordById(req, res)

        expect(res.status).toHaveBeenCalledWith(204)
    })

    it('returns a not found response', () => {
        const req = {
            body: {
                oldPassword: "password123"
            },
            params: {
                id: 5
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }
        controller.updatePasswordById(req, res)

        expect(res.status).toHaveBeenCalledWith(404)
    })

    it('returns a wrong password response', () => { 
        const req = {
            body: {
                oldPassword: "password1234"
            },
            params: {
                id: 1
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.updatePasswordById(req, res)

        expect(res.status).toHaveBeenCalledWith(401)
    })

    it('returns an error response', () => {
        const req = {
            body: {
                oldPassword: "password123"
            },
            params: {
                id: 1
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        jest.spyOn(User, "updatePasswordById").mockImplementationOnce((id, user, callback) => {
            callback({ kind: "mock" }, null)
        })

        controller.updatePasswordById(req, res)

        expect(res.status).toHaveBeenCalledWith(500)
    })
})

describe('Test Delete All', () => {
    it('should return a response ', () => {
        const req = {};
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.deleteAll(req, res)

        expect(res.status).toHaveBeenCalledWith(200)
    });

    it('should return an error response ', () => {
        const req = {};
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        jest.spyOn(User, "deleteAll").mockImplementationOnce((callback) => {
            callback({ kind: "mock" }, null)
        })

        controller.deleteAll(req, res);

        expect(res.status).toHaveBeenCalledWith(500)

    });
});

describe('Test DeleteById', () => {
    it('should return a response ', () => {
        const req = {
            params: {
                id: 1
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.deleteById(req, res)

        expect(res.status).toHaveBeenCalledWith(200)
    });

    it('should return a not found response ', () => {
        const req = {
            params: {
                id: 5
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.deleteById(req, res)

        expect(res.status).toHaveBeenCalledWith(404)
    });

    it('should return an error response ', () => {
        const req = {
            params: {
                id: 6
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        jest.spyOn(User, "deleteById").mockImplementationOnce((id, callback) => {
            callback({ kind: "mock" }, null)
        })

        controller.deleteById(req, res);

        expect(res.status).toHaveBeenCalledWith(500)

    });
});

describe('Test Auth', () => {
    it('should return a response ', () => {
        const req = {
            body: {
                email: "john.doe@example.com",
                password: "password123",
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.auth(req, res)

        expect(res.status).toHaveBeenCalledWith(200)
        expect(res.send).toHaveBeenCalledWith(
            expect.objectContaining({
                id: 1,
                name: "John",
                surname: "Doe",
                email: "john.doe@example.com",
                bikesRented: 3
            })
        )
    });

    it('should return a unauthorized response ', () => {
        const req = {
            body: {
                email: "john.doe@example.com",
                password: "password1234",
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.auth(req, res)

        expect(res.status).toHaveBeenCalledWith(401)

    });

    it('should return a not found response ', () => {
        const req = {
            body: {
                email: "john.notdoe@example.com",
                password: "password123",
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        controller.auth(req, res)

        expect(res.status).toHaveBeenCalledWith(404)

    });

    it('should return an error response ', () => {
        const req = {
            body: {
                email: "john.notdoe@example.com",
                password: "password1234",
            }
        };
        const res = {
            send: jest.fn(),
            status: jest.fn().mockReturnThis()
        }

        jest.spyOn(User, "auth").mockImplementationOnce((email, password, callback) => {
            callback({ kind: "mock" }, null)
        })

        controller.auth(req, res);

        expect(res.status).toHaveBeenCalledWith(500)

    });
});
