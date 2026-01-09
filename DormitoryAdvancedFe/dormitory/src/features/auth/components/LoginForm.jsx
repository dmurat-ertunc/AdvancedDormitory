import React, { useState } from 'react';
import { Box, TextField, Button, Typography, Paper, Avatar, Link, InputAdornment, Alert, CircularProgress } from '@mui/material';
import { LockOutlined as LockIcon, Person as PersonIcon, VpnKey as KeyIcon } from '@mui/icons-material';
import { Link as RouterLink, useNavigate } from 'react-router-dom';
import { motion } from 'framer-motion';

// DÜZELTME 1: AuthService yerine Context Hook'unu import ediyoruz
import { useAuth } from "../../../context/AuthContext"; 

const LoginForm = () => {
    const navigate = useNavigate();
    
    // DÜZELTME 2: Context içindeki login fonksiyonunu çekiyoruz
    const { login } = useAuth(); 

    // State Tanımlamaları
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");

    const handleLogin = async (e) => {
        e.preventDefault();
        setError("");
        setLoading(true);

        try {
            // DÜZELTME 3: AuthService.login YERİNE context'ten gelen login'i kullanıyoruz.
            // Bu fonksiyon hem backend'e istek atacak hem de State'i güncelleyecek.
            await login(username, password);
            
            // Login işlemi ve State güncellemesi bitti, artık yönlendirebiliriz.
            navigate('/dashboard');
        } catch (err) {
            console.error("Login hatası:", err);
            setError("Giriş başarısız. Kullanıcı adı veya şifre hatalı.");
            setLoading(false);
        }
    };

    // ... (Kalan return kısmı aynı, değiştirmene gerek yok) ...
    return (
        <motion.div
            initial={{ opacity: 0, y: 30 }}
            animate={{ opacity: 1, y: 0 }}
            exit={{ opacity: 0, y: -30 }}
            transition={{ duration: 0.5 }}
        >
            <Paper
                elevation={24}
                sx={{
                    p: { xs: 3, md: 5 },
                    width: '100%',
                    maxWidth: 450,
                    borderRadius: 4,
                    backdropFilter: 'blur(12px)',
                    backgroundColor: 'rgba(17, 34, 64, 0.85)',
                    border: '1px solid rgba(255, 255, 255, 0.1)',
                    boxShadow: '0 8px 32px 0 rgba(0, 0, 0, 0.37)',
                }}
            >
                <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', mb: 4 }}>
                    <motion.div
                        whileHover={{ scale: 1.1, rotate: 360 }}
                        transition={{ duration: 0.5 }}
                    >
                        <Avatar sx={{ m: 1, bgcolor: 'primary.main', width: 64, height: 64, color: 'primary.contrastText' }}>
                            <LockIcon fontSize="large" />
                        </Avatar>
                    </motion.div>
                    <Typography variant="h4" sx={{ mt: 2, color: 'text.primary' }}>
                        Hoş Geldiniz
                    </Typography>
                    <Typography variant="body2" color="text.secondary" sx={{ mt: 1 }}>
                        Yönetici paneline erişmek için giriş yapın
                    </Typography>
                </Box>

                {error && (
                    <motion.div initial={{ opacity: 0 }} animate={{ opacity: 1 }} sx={{ mb: 2 }}>
                        <Alert severity="error" variant="filled" onClose={() => setError("")}>
                            {error}
                        </Alert>
                    </motion.div>
                )}

                <Box component="form" onSubmit={handleLogin} noValidate>
                    <TextField
                        margin="normal"
                        fullWidth
                        label="Kullanıcı Adı"
                        name="username"
                        autoComplete="username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        InputProps={{
                            startAdornment: (
                                <InputAdornment position="start">
                                    <PersonIcon color="action" />
                                </InputAdornment>
                            ),
                            style: { color: '#fff' }
                        }}
                        InputLabelProps={{
                            style: { color: '#8892b0' }
                        }}
                    />
                    <TextField
                        margin="normal"
                        fullWidth
                        label="Şifre"
                        type="password"
                        name="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        InputProps={{
                            startAdornment: (
                                <InputAdornment position="start">
                                    <KeyIcon color="action" />
                                </InputAdornment>
                            ),
                            style: { color: '#fff' }
                        }}
                        InputLabelProps={{
                            style: { color: '#8892b0' }
                        }}
                    />

                    <motion.div whileHover={{ scale: 1.02 }} whileTap={{ scale: 0.98 }}>
                        <Button
                            type="submit"
                            fullWidth
                            variant="contained"
                            disabled={loading}
                            size="large"
                            sx={{
                                mt: 4,
                                mb: 2,
                                py: 1.5,
                                fontSize: '1rem',
                                background: 'linear-gradient(45deg, #64ffda 30%, #53d3b4 90%)',
                                color: '#0a192f',
                                fontWeight: 'bold',
                                '&:hover': {
                                    background: 'linear-gradient(45deg, #53d3b4 30%, #64ffda 90%)',
                                },
                                '&:disabled': {
                                    background: 'rgba(100, 255, 218, 0.3)',
                                    color: 'rgba(255,255,255,0.3)'
                                }
                            }}
                        >
                            {loading ? <CircularProgress size={24} color="inherit" /> : "GİRİŞ YAP"}
                        </Button>
                    </motion.div>

                    <Box sx={{ textAlign: 'center', mt: 2 }}>
                        <Typography variant="body2" color="text.secondary">
                            Hesabınız yok mu?{' '}
                            <Link
                                component={RouterLink}
                                to="/register"
                                sx={{
                                    color: 'primary.main',
                                    textDecoration: 'none',
                                    fontWeight: 'bold',
                                    '&:hover': { textDecoration: 'underline' }
                                }}
                            >
                                Kayıt Olun
                            </Link>
                        </Typography>
                    </Box>
                </Box>
            </Paper>
        </motion.div>
    );
};

export default LoginForm;