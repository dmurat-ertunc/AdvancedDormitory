// src/App.jsx
import React from 'react';
import { ThemeProvider, CssBaseline, Box } from '@mui/material';
import { Routes, Route, Navigate, useLocation } from 'react-router-dom';
import { AnimatePresence } from 'framer-motion';
import theme from './styles/theme';

// --- CONTEXT ---
import { AuthProvider } from './context/AuthContext';

// --- COMPONENTS & LAYOUTS ---
import DashboardLayout from './layouts/DashboardLayout';
import ProtectedRoute from './routes/ProtectedRoute'; // Yeni güvenlik bekçimiz
import PublicRoute from './routes/PublicRoute'; // Giriş yapmışsa dashboard'a atan yapı

// --- SAYFALAR (PAGES) ---
import LoginPage from './features/auth/components/LoginForm';
import RegisterPage from './features/auth/components/RegisterForm';
import DashboardPage from './features/dashboard/DashboardPage';
import UnauthorizedPage from './pages/Unauthorized'; // Yetkisiz giriş sayfası

// (Henüz oluşturmadıysan bu sayfaları oluşturmalısın veya geçici dummy component yapabilirsin)
// import StudentsPage from './pages/StudentsPage';
// import RoomsPage from './pages/RoomsPage';
// import PaymentsPage from './pages/PaymentsPage';
// import SettingsPage from './pages/SettingsPage';

// Geçici Dummy Componentler (Kod hata vermesin diye)
const StudentsPage = () => <div>Öğrenciler Sayfası</div>;
const RoomsPage = () => <div>Odalar Sayfası</div>;
const PaymentsPage = () => <div>Ödemeler Sayfası</div>;
const SettingsPage = () => <div>Ayarlar Sayfası</div>;

function App() {
  const location = useLocation();

  return (
    <AuthProvider>
      <ThemeProvider theme={theme}>
        <CssBaseline />
        <AnimatePresence mode="wait">
          <Routes location={location} key={location.pathname}>

            {/* ============================================================ */}
            {/* 1. PUBLIC ROUTES (Login, Register, Unauthorized)             */}
            {/* ============================================================ */}

            <Route path="/unauthorized" element={<UnauthorizedPage />} />

            <Route element={<PublicRoute />}>
              <Route
                path="/login"
                element={
                  <Box sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '100vh', width: '100%' }}>
                    <LoginPage />
                  </Box>
                }
              />
              <Route
                path="/register"
                element={
                  <Box sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '100vh', width: '100%' }}>
                    <RegisterPage />
                  </Box>
                }
              />
            </Route>

            {/* ============================================================ */}
            {/* 2. PROTECTED ROUTES (Giriş Yapmış Herkes)                    */}
            {/* ============================================================ */}

            {/* GRUP A: Herhangi bir rol kısıtlaması olmayan, sadece giriş şartı olanlar */}
            <Route element={<ProtectedRoute />}>
              <Route
                path="/dashboard"
                element={
                  <DashboardLayout>
                    <DashboardPage />
                  </DashboardLayout>
                }
              />
              <Route
                path="/students"
                element={
                  <DashboardLayout>
                    <StudentsPage />
                  </DashboardLayout>
                }
              />
              <Route
                path="/settings"
                element={
                  <DashboardLayout>
                    <SettingsPage />
                  </DashboardLayout>
                }
              />
            </Route>

            {/* ============================================================ */}
            {/* 3. ROLE-BASED ROUTES (Özel Yetki Gerektirenler)              */}
            {/* ============================================================ */}

            {/* GRUP B: Sadece ADMIN ve MANAGER görebilir (Odalar) */}
            <Route element={<ProtectedRoute allowedRoles={['ADMIN', 'SUPER_ADMIN']} />}>
              <Route
                path="/rooms"
                element={
                  <DashboardLayout>
                    <RoomsPage />
                  </DashboardLayout>
                }
              />
            </Route>

            {/* GRUP C: Sadece SUPER_ADMIN görebilir (Ödemeler) */}
            <Route element={<ProtectedRoute allowedRoles={['SUPER_ADMIN']} />}>
              <Route
                path="/payments"
                element={
                  <DashboardLayout>
                    <PaymentsPage />
                  </DashboardLayout>
                }
              />
            </Route>

            {/* ============================================================ */}
            {/* 4. CATCH ALL (404 -> Login)                                  */}
            {/* ============================================================ */}
            <Route path="/" element={<Navigate to="/login" />} />
            <Route path="*" element={<Navigate to="/login" />} />

          </Routes>
        </AnimatePresence>
      </ThemeProvider>
    </AuthProvider>
  );
}

export default App;