import React from 'react';
import { Box, Container } from '@mui/material';

const backgroundStyle = {
    width: '100vw',        // Ekran genişliğinin tamamını kapla
    height: '100vh',       // Ekran yüksekliğinin tamamını kapla
    display: 'flex',       // Esnek kutu modeli (hizalama için şart)
    alignItems: 'center',    // Dikeyde ortala
    justifyContent: 'center', // Yatayda ortala (Sola dayalı sorununu bu çözer)
    background: 'radial-gradient(circle at 50% -20%, #1a237e 0%, #0a192f 100%)',
    position: 'relative',
    overflow: 'hidden',

    // Işık Efektleri (Opsiyonel ama şık durur)
    '&::before': {
        content: '""',
        position: 'absolute',
        top: '-10%', left: '-10%', width: '40%', height: '40%',
        background: 'radial-gradient(circle, rgba(100, 255, 218, 0.1) 0%, rgba(0,0,0,0) 70%)',
        filter: 'blur(60px)',
        zIndex: 0,
        animation: 'float 10s infinite ease-in-out',
    },
    '&::after': {
        content: '""',
        position: 'absolute',
        bottom: '-10%', right: '-10%', width: '40%', height: '40%',
        background: 'radial-gradient(circle, rgba(63, 81, 181, 0.2) 0%, rgba(0,0,0,0) 70%)',
        filter: 'blur(60px)',
        zIndex: 0,
        animation: 'float 15s infinite ease-in-out reverse',
    },
    '@keyframes float': {
        '0%': { transform: 'translate(0, 0)' },
        '50%': { transform: 'translate(30px, 50px)' },
        '100%': { transform: 'translate(0, 0)' },
    }
};

const AuthLayout = ({ children }) => {
    return (
        <Box sx={backgroundStyle}>
            {/* maxWidth="sm" formu dar tutar, zIndex ışıkların üstüne çıkarır */}
            <Container maxWidth="sm" sx={{ position: 'relative', zIndex: 1 }}>
                {children}
            </Container>
        </Box>
    );
};

export default AuthLayout;