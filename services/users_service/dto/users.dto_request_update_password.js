class UserDTORequestUpdatePassword {
    constructor(userDTO){
        this.oldPassword = userDTO.oldPassword;
        this.newPassword = userDTO.newPassword;

    }
}

module.exports = UserDTORequestUpdatePassword;