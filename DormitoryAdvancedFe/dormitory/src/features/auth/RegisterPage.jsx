import { Box, Container } from '@mui/material';
import RegisterForm from './components/RegisterForm';

// LoginPage ile aynı arka plan stilini kullanıyoruz
const backgroundStyle = {
    minHeight: '100vh',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    // Koyu lacivert degrade arka plan
    background: 'radial-gradient(circle at 50% -20%, #1a237e 0%, #0a192f 100%)',
    position: 'relative',
    overflow: 'hidden',
    // Sol üstteki hareketli ışık küresi
    '&::before': {
        content: '""',
        position: 'absolute',
        top: '-10%',
        left: '-10%',
        width: '40%',
        height: '40%',
        background: 'radial-gradient(circle, rgba(100, 255, 218, 0.1) 0%, rgba(0,0,0,0) 70%)',
        filter: 'blur(60px)',
        animation: 'float 10s infinite ease-in-out',
        zIndex: 0
    },
    // Sağ alttaki hareketli ışık küresi
    '&::after': {
        content: '""',
        position: 'absolute',
        bottom: '-10%',
        right: '-10%',
        width: '40%',
        height: '40%',
        background: 'radial-gradient(circle, rgba(63, 81, 181, 0.2) 0%, rgba(0,0,0,0) 70%)',
        filter: 'blur(60px)',
        animation: 'float 15s infinite ease-in-out reverse',
        zIndex: 0
    },
    // Yüzme (floating) animasyonu
    '@keyframes float': {
        '0%': { transform: 'translate(0, 0)' },
        '50%': { transform: 'translate(30px, 50px)' },
        '100%': { transform: 'translate(0, 0)' },
    }
};

const RegisterPage = () => {
    return (
        <Box sx={backgroundStyle}>
            {/* zIndex: 1 vererek formu arka plan ışıklarının önüne alıyoruz */}
            <Container maxWidth="sm" sx={{ position: 'relative', zIndex: 1, display: 'flex', justifyContent: 'center' }}>
                <RegisterForm />
            </Container>
        </Box>
    );
};

export default RegisterPage;