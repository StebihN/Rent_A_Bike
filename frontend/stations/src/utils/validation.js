
export const validate = (formData) => {
    let errors = {}
    for (var key in formData) {    
        if (formData[key].trim() === "") {
            errors[key + "Error"] = "This field is required!"
        }
    }
    return errors
}

