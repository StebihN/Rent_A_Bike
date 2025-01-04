class UserDTORequestUpdate {
    constructor(userDTO){
        this.name = userDTO.name;
        this.surname = userDTO.surname;
        this.email = userDTO.email;
    }
}

module.exports = UserDTORequestUpdate;