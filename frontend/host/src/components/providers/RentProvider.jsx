import { createContext, useContext, useEffect, useMemo, useState } from "react";
import { jwtDecode } from 'jwt-decode'

import { useAuth } from 'host/AuthProvider'
import { getRentByUserId } from "../../api/service";

const RentContext = createContext();


const RentProvider = ({ children }) => {
    const { token } = useAuth()
    const [isRented, setIsRented_] = useState()

    const setIsRented = (rentStatus) => {
        setIsRented_(rentStatus)
    }

    useEffect(() => {
        if (token) {
            getRentByUserId(jwtDecode(token).id).then((result) => {
                setIsRented(result)
            }).catch((err) => {
                console.log(err)
            });
        } else {
        }
    }, [token])

    const contextValue = useMemo(
        () => ({
            isRented,
            setIsRented,
        }),
        [isRented]
    );

    return (
        <RentContext.Provider value={contextValue}>{children}</RentContext.Provider>
    );
}

export const useRent = () => {
    return useContext(RentContext);
};

export default RentProvider;