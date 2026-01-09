import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';

const PublicRoute = () => {
    const token = localStorage.getItem("token");

    // Token varsa (zaten giriş yapmışsa) Dashboard'a gönder
    // Token yoksa sayfayı (Login/Register) göster
    return token ? <Navigate to="/dashboard" replace /> : <Outlet />;
};

export default PublicRoute;