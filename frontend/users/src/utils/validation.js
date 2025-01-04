const isEmailValid = (email) => {
    const emailRegex = new RegExp(/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g);
    return emailRegex.test(email)
}

const isPasswordValid = (password) => {
    const passwordRegex = new RegExp(/^[A-Za-z0-9]{10,}$/g)
    return passwordRegex.test(password)
}

export const validate = (formData) => {
    let errors = {}
    for (var key in formData) {
        if (key == "email") {
            if (!isEmailValid(formData[key])) {
                errors[key + "Error"] = "Email is not correct"
            }
        }
        if (key == "password") {
            if (!isPasswordValid(formData[key])) {
                errors[key + "Error"] = "Password must be at least 10 characters long and can contain only letters and numbers"
            }
        }
        if (formData[key].trim() === "") {
            errors[key + "Error"] = "This field is required!"
        }

    }
    return errors
}