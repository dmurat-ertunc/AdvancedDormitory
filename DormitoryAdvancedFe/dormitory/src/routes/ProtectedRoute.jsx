import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';

// Bu bileşen, gidilmek istenen sayfayı sarmalar ve kontrol eder
const ProtectedRoute = ({ allowedRoles }) => {
    const { token, userRoles } = useAuth();

    // 1. Kullanıcı hiç giriş yapmış mı? (Token yoksa Login'e at)
    if (!token) {
        return <Navigate to="/login" replace />;
    }

    // 2. Kullanıcı giriş yapmış ama bu sayfa için yetkisi var mı?
    // allowedRoles gönderildiyse kontrol et, gönderilmediyse (boşsa) herkese açıktır.
    if (allowedRoles && allowedRoles.length > 0) {
        const hasPermission = allowedRoles.some(role => userRoles?.includes(role));

        if (!hasPermission) {
            // Yetkisi yoksa "Yetkisiz Giriş" sayfasına veya Dashboard'a at
            return <Navigate to="/unauthorized" replace />;
        }
    }

    // 3. Her şey yolundaysa, alt sayfayı (Outlet) göster
    return <Outlet />;
};

export default ProtectedRoute;