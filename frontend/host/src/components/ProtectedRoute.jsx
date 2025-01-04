import { Navigate, Outlet } from "react-router-dom";
import { useAuth } from 'host/AuthProvider';


export default function ProtectedRoute () {
    const { token } = useAuth()

    if (!token) {
        return <Navigate to="/login" />;
    }

    return <Outlet />;
};