import React, { useState } from 'react';
import { Box, TextField, Button, Typography, Paper, Grid, Link, Avatar, InputAdornment } from '@mui/material';
import { PersonAddOutlined as PersonAddIcon, Badge, Email, Lock } from '@mui/icons-material';
import { Link as RouterLink } from 'react-router-dom'; // RouterLink eklendi
import { motion } from 'framer-motion';

const RegisterForm = () => {
    const [formData, setFormData] = useState({
        fullName: '',
        email: '',
        password: '',
        confirmPassword: ''
    });

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("Kayıt verileri:", formData);
    };

    return (
        <motion.div
            initial={{ opacity: 0, x: 50 }}
            animate={{ opacity: 1, x: 0 }}
            exit={{ opacity: 0, x: -50 }}
            transition={{ duration: 0.5 }}
        >
            <Paper
                elevation={24}
                sx={{
                    p: { xs: 3, md: 5 },
                    width: '100%',
                    maxWidth: 500,
                    borderRadius: 4,
                    backdropFilter: 'blur(12px)',
                    backgroundColor: 'rgba(17, 34, 64, 0.85)',
                    border: '1px solid rgba(255, 255, 255, 0.1)',
                    boxShadow: '0 8px 32px 0 rgba(0, 0, 0, 0.37)',
                }}
            >
                <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', mb: 3 }}>
                    <motion.div whileHover={{ rotate: 20 }} transition={{ type: 'spring', stiffness: 300 }}>
                        <Avatar sx={{ m: 1, bgcolor: 'secondary.main', width: 56, height: 56, color: 'background.default' }}>
                            <PersonAddIcon fontSize="large" />
                        </Avatar>
                    </motion.div>
                    <Typography variant="h4" sx={{ mt: 1, color: 'text.primary' }}>
                        Kayıt Ol
                    </Typography>
                    <Typography variant="body2" color="text.secondary">
                        Sisteme yeni bir yönetici ekleyin
                    </Typography>
                </Box>

                <Box component="form" onSubmit={handleSubmit} noValidate>
                    <Grid container spacing={2}>
                        <Grid item xs={12}>
                            <TextField
                                fullWidth
                                label="Ad Soyad"
                                name="fullName"
                                onChange={handleChange}
                                InputProps={{
                                    startAdornment: <InputAdornment position="start"><Badge color="action" /></InputAdornment>
                                }}
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <TextField
                                fullWidth
                                label="E-posta"
                                name="email"
                                type="email"
                                onChange={handleChange}
                                InputProps={{
                                    startAdornment: <InputAdornment position="start"><Email color="action" /></InputAdornment>
                                }}
                            />
                        </Grid>
                        <Grid item xs={12} sm={6}>
                            <TextField
                                fullWidth
                                label="Şifre"
                                name="password"
                                type="password"
                                onChange={handleChange}
                                InputProps={{
                                    startAdornment: <InputAdornment position="start"><Lock color="action" /></InputAdornment>
                                }}
                            />
                        </Grid>
                        <Grid item xs={12} sm={6}>
                            <TextField
                                fullWidth
                                label="Şifre Tekrar"
                                name="confirmPassword"
                                type="password"
                                onChange={handleChange}
                                InputProps={{
                                    startAdornment: <InputAdornment position="start"><Lock color="action" /></InputAdornment>
                                }}
                            />
                        </Grid>
                    </Grid>

                    <motion.div whileHover={{ scale: 1.02 }} whileTap={{ scale: 0.98 }}>
                        <Button
                            fullWidth
                            variant="contained"
                            type="submit"
                            size="large"
                            sx={{
                                mt: 4,
                                mb: 2,
                                py: 1.5,
                                fontSize: '1rem',
                                background: 'linear-gradient(45deg, #ccd6f6 30%, #a8b2d1 90%)',
                                color: '#0a192f',
                                fontWeight: 'bold'
                            }}
                        >
                            KAYIT OL
                        </Button>
                    </motion.div>

                    <Box sx={{ textAlign: 'center', mt: 1 }}>
                        <Typography variant="body2" color="text.secondary">
                            Zaten hesabınız var mı?{' '}
                            <Link
                                component={RouterLink}
                                to="/login"
                                sx={{ color: 'primary.main', textDecoration: 'none', '&:hover': { textDecoration: 'underline' } }}
                            >
                                Giriş Yapın
                            </Link>
                        </Typography>
                    </Box>
                </Box>
            </Paper>
        </motion.div>
    );
};

export default RegisterForm;