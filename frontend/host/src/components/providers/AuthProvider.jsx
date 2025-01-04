import { createContext, useContext, useEffect, useMemo, useState } from "react";
import { jwtDecode } from 'jwt-decode'

import Cookies from "js-cookie"

const AuthContext = createContext();

const AuthProvider = ({ children }) => {
    const [token, setToken_] = useState(Cookies.get("token"));

    const setToken = (newToken) => {
        setToken_(newToken);
    };

    useEffect(() => {
        if (token) {
            if(jwtDecode(token).exp < Math.floor(Date.now() / 1000)){
                setToken()
            }
            Cookies.set('token', token);
        } else {
            Cookies.remove('token')
        }
    }, [token]);

    const contextValue = useMemo(
        () => ({
            token,
            setToken,
        }),
        [token]
    );

    return (
        <AuthContext.Provider value={contextValue}>{children}</AuthContext.Provider>
    );
};

export const useAuth = () => {
    return useContext(AuthContext);
};

export default AuthProvider;


// getRentalById(jwtDecode(token).id).then((result) => {
//     if (result.id) {
//         Cookies.set('rentedOn', result.rentedOn)
//         Cookies.set('bikeId', result.bikeId)
//         Cookies.set('rentalId', result.id)
//     }
// }).catch((err) => {
//     console.log(err.message)
// });