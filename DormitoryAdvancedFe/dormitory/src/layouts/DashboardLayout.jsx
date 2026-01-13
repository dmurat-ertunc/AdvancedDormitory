import React from 'react';
import { Box, Drawer, List, ListItem, ListItemIcon, ListItemText, Typography, Avatar, AppBar, Toolbar, IconButton } from '@mui/material';
import { Dashboard, People, BedroomParent, Payment, Settings, Logout, Notifications } from '@mui/icons-material';
import { useNavigate } from 'react-router-dom';
import AuthService from '../services/auth.service';
import { useAuth } from '../context/AuthContext';

const drawerWidth = 280;
const sidebarBg = '#112240'; // Sidebar rengi
const mainBg = '#0a192f';    // Ana arka plan rengi

// Menü Elemanları
const menuItems = [
    { text: 'Ana Sayfa', icon: <Dashboard />, path: '/dashboard' },
    { text: 'Öğrenciler', icon: <People />, path: '/students' },
    { text: 'Odalar', icon: <BedroomParent />, path: '/rooms', roles: ['ADMIN', 'SUPER_ADMIN', 'DEVELOPER'] },
    { text: 'Ödemeler', icon: <Payment />, path: '/payments', roles: ['SUPER_ADMIN', 'DEVELOPER'] },
    { text: 'Ayarlar', icon: <Settings />, path: '/settings' },
];

const DashboardLayout = ({ children }) => {
    const navigate = useNavigate();
    const { user, logout, userRoles } = useAuth(); // Token'a gerek kalmadı, user yetiyor

    const handleLogout = () => {
        AuthService.logout();
        navigate('/login');
    };

    const filteredMenuItems = menuItems.filter(item => {
        if (!item.roles || item.roles.length === 0) return true;
        const currentUserRoles = userRoles || [];
        return item.roles.some(permittedRole => currentUserRoles.includes(permittedRole));
    });

    return (
        <Box sx={{ display: 'flex', minHeight: '100vh', bgcolor: mainBg }}>

            {/* Üst Bar (AppBar) */}
            <AppBar
                position="fixed"
                sx={{
                    width: { sm: `calc(100% - ${drawerWidth}px)` },
                    ml: { sm: `${drawerWidth}px` },
                    backdropFilter: 'blur(10px)',
                    backgroundColor: 'rgba(10, 25, 47, 0.85)',
                    borderBottom: '1px solid rgba(255,255,255,0.05)',
                    boxShadow: '0 4px 30px rgba(0, 0, 0, 0.1)'
                }}
            >
                <Toolbar>
                    <Typography variant="h6" noWrap component="div" sx={{ flexGrow: 1, color: '#ccd6f6', fontWeight: 'bold' }}>
                        Yurt Yönetim Paneli
                    </Typography>

                    {/* --- KULLANICI BİLGİLERİ ALANI (DÜZENLENDİ) --- */}
                    <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'flex-end', mr: 1 }}>
                        {/* 1. Kullanıcı Adı */}
                        <Typography variant="body1" sx={{ color: '#fff', fontWeight: 'bold', lineHeight: 1.2 }}>
                            {user?.username}
                        </Typography>

                        {/* 2. Roller (Liste Halinde) */}
                        <Typography variant="caption" sx={{ color: '#64ffda', fontFamily: 'monospace' }}>
                            {/* Artık kontrol yapmana gerek yok, direkt joinle */}
                            {userRoles.length > 0 ? userRoles.join(', ') : 'Yetki Yok'}
                        </Typography>
                    </Box>
                    {/* ----------------------------------------------- */}

                    <IconButton sx={{ color: '#64ffda' }}>
                        <Notifications />
                    </IconButton>
                    <Avatar sx={{ ml: 2, bgcolor: '#64ffda', color: '#0a192f', width: 32, height: 32, fontWeight: 'bold' }}>
                        {user?.username?.charAt(0).toUpperCase()}
                    </Avatar>
                </Toolbar>
            </AppBar>

            {/* Sol Menü (Sidebar) */}
            <Box
                component="nav"
                sx={{ width: { sm: drawerWidth }, flexShrink: { sm: 0 } }}
            >
                <Drawer
                    variant="permanent"
                    sx={{
                        display: { xs: 'none', sm: 'block' },
                        '& .MuiDrawer-paper': {
                            boxSizing: 'border-box',
                            width: drawerWidth,
                            backgroundColor: sidebarBg,
                            color: '#ccd6f6',
                            borderRight: '1px solid rgba(255,255,255,0.05)'
                        },
                    }}
                    open
                >
                    <Box sx={{ p: 3, textAlign: 'center', mb: 2 }}>
                        <Typography variant="h5" fontWeight="900" sx={{ color: '#64ffda', letterSpacing: 3 }}>
                            YYP
                        </Typography>
                    </Box>
                    <List sx={{ px: 2 }}>
                        {filteredMenuItems.map((item) => (
                            <ListItem
                                button
                                key={item.text}
                                onClick={() => navigate(item.path)}
                                sx={{
                                    mb: 1,
                                    borderRadius: 2,
                                    transition: 'all 0.3s ease',
                                    '&:hover': { bgcolor: 'rgba(100, 255, 218, 0.1)', transform: 'translateX(5px)' },
                                    '&:hover .MuiListItemIcon-root': { color: '#64ffda' },
                                    '&:hover .MuiTypography-root': { color: '#64ffda' }
                                }}
                            >
                                <ListItemIcon sx={{ color: '#8892b0', minWidth: 40 }}>{item.icon}</ListItemIcon>
                                <ListItemText primary={item.text} primaryTypographyProps={{ fontWeight: 500, fontFamily: 'Inter, sans-serif' }} />
                            </ListItem>
                        ))}
                    </List>

                    <Box sx={{ position: 'absolute', bottom: 20, width: '100%', px: 2 }}>
                        <ListItem
                            button
                            onClick={handleLogout}
                            sx={{ borderRadius: 2, color: '#ff6b6b', '&:hover': { bgcolor: 'rgba(255, 107, 107, 0.1)' } }}
                        >
                            <ListItemIcon sx={{ color: '#ff6b6b', minWidth: 40 }}><Logout /></ListItemIcon>
                            <ListItemText primary="Çıkış Yap" />
                        </ListItem>
                    </Box>
                </Drawer>
            </Box>

            {/* Ana İçerik Alanı */}
            <Box
                component="main"
                sx={{
                    flexGrow: 1,
                    p: 3,
                    width: { sm: `calc(100% - ${drawerWidth}px)` },
                    mt: 8,
                    color: '#ccd6f6'
                }}
            >
                {children}
            </Box>
        </Box>
    );
};

export default DashboardLayout;