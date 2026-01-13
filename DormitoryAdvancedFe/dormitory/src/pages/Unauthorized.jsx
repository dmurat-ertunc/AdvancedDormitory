import React from 'react';
import { Box, Typography, Button } from '@mui/material';
import { useNavigate } from 'react-router-dom';

const Unauthorized = () => {
    const navigate = useNavigate();

    return (
        <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', height: '100vh', bgcolor: '#0a192f', color: '#fff' }}>
            <Typography variant="h1" sx={{ color: '#ff6b6b', fontWeight: 'bold' }}>403</Typography>
            <Typography variant="h5" sx={{ mb: 3 }}>Bu sayfaya erişim yetkiniz yok!</Typography>
            <Button variant="contained" color="primary" onClick={() => navigate('/dashboard')}>
                Ana Sayfaya Dön
            </Button>
        </Box>
    );
};

export default Unauthorized;