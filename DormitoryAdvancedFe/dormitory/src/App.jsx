// src/App.jsx
import React from 'react';
import { ThemeProvider, CssBaseline, Box } from '@mui/material'; // Box eklendi
import { Routes, Route, Navigate, useLocation } from 'react-router-dom';
import { AnimatePresence } from 'framer-motion';
import theme from './styles/theme';

// SAYFALAR
import LoginPage from './features/auth/components/LoginForm';
import RegisterPage from './features/auth/components/RegisterForm'; // Dosya adını kontrol et (RegisterForm mu RegisterPage mi?)
import DashboardPage from './features/dashboard/DashboardPage';

// LAYOUT & ROUTES
import DashboardLayout from './layouts/DashboardLayout';
import PrivateRoute from './routes/PrivateRoute';
import PublicRoute from './routes/PublicRoute';
import { AuthProvider } from './context/AuthContext';

function App() {
  const location = useLocation();

  return (
    <AuthProvider>
      <ThemeProvider theme={theme}>
        <CssBaseline />
        <AnimatePresence mode="wait">
          <Routes location={location} key={location.pathname}>

            {/* PUBLIC ROUTES (Login ve Register) - ORTALAMA İŞLEMİ BURADA */}
            <Route element={<PublicRoute />}>
              <Route 
                path="/login" 
                element={
                  // Bu Box sayfayı tam ortalar
                  <Box sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '100vh', width: '100%' }}>
                    <LoginPage />
                  </Box>
                } 
              />
              <Route 
                path="/register" 
                element={
                   // Bu Box sayfayı tam ortalar
                  <Box sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '100vh', width: '100%' }}>
                    <RegisterPage />
                  </Box>
                } 
              />
            </Route>

            {/* PRIVATE ROUTES (Dashboard) - Kendi Layout'unu kullanır */}
            <Route element={<PrivateRoute />}>
              <Route 
                path="/dashboard" 
                element={
                  <DashboardLayout>
                    <DashboardPage />
                  </DashboardLayout>
                } 
              />
            </Route>

            <Route path="/" element={<Navigate to="/login" />} />
            <Route path="*" element={<Navigate to="/login" />} />

          </Routes>
        </AnimatePresence>
      </ThemeProvider>
    </AuthProvider>
  );
}

export default App;