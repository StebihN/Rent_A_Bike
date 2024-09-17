class UserDTOResponse {
    constructor(userDTO){
        this.id = userDTO.id;
        this.name = userDTO.name;
        this.surname = userDTO.surname;
        this.email = userDTO.email;
        this.bikesRented = userDTO.bikesRented;
    }
}

module.exports = UserDTOResponse;