class UserDTORequest {
    constructor(userDTO){
        this.name = userDTO.name;
        this.surname = userDTO.surname;
        this.email = userDTO.email;
        this.password = userDTO.password;
    }
}

module.exports = UserDTORequest;