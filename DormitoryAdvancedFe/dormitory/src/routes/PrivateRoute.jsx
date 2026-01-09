import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';

const PrivateRoute = () => {
    // LocalStorage'dan token'ı kontrol et
    const token = localStorage.getItem("token");

    // Token varsa çocuk route'ları (Outlet) göster, yoksa Login'e şutla
    return token ? <Outlet /> : <Navigate to="/login" replace />;
};

export default PrivateRoute;