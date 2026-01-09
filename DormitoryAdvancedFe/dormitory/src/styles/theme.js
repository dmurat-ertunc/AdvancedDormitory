import { createTheme } from '@mui/material/styles';

const theme = createTheme({
    palette: {
        mode: 'dark',
        primary: {
            main: '#64ffda', // Neon Turkuaz (Vurgu rengi)
            contrastText: '#0a192f',
        },
        secondary: {
            main: '#ccd6f6', // Açık Gri/Mavi metinler için
        },
        background: {
            default: '#0a192f', // Ana arka plan (En koyu lacivert)
            paper: '#112240',   // Kartlar ve Sidebar arka planı (Bir tık açık lacivert)
        },
        text: {
            primary: '#e6f1ff', // Ana başlıklar (Neredeyse beyaz)
            secondary: '#8892b0', // Alt metinler (Gri-Mavi)
        },
        error: {
            main: '#ff6b6b', // Hata mesajları ve Çıkış butonu için pastel kırmızı
        },
        warning: {
            main: '#ffd700',
        },
        success: {
            main: '#64ffda',
        }
    },
    shape: { borderRadius: 12 }, // Kartların köşe yuvarlaklığı
    typography: {
        fontFamily: "'Inter', 'Roboto', sans-serif",
        h4: { fontWeight: 700, letterSpacing: '-0.5px' },
        h6: { fontWeight: 600, letterSpacing: '0.5px' },
        button: { textTransform: 'none', fontWeight: 600 },
    },
    components: {
        // Label Rengi (Input üzerindeki yazı: "Kullanıcı Adı" vs.)
        MuiInputLabel: {
            styleOverrides: {
                root: {
                    color: '#8892b0',
                    '&.Mui-focused': {
                        color: '#64ffda',
                    },
                },
            },
        },
        // Input Kutusu (TextField) Ayarları
        MuiOutlinedInput: {
            styleOverrides: {
                root: {
                    backgroundColor: 'rgba(255, 255, 255, 0.03)', // Hafif şeffaf arka plan
                    transition: 'all 0.3s ease-in-out',
                    
                    // Normal Çerçeve Rengi
                    '& fieldset': {
                        borderColor: 'rgba(255, 255, 255, 0.1)', 
                    },
                    // Üzerine gelince (Hover)
                    '&:hover fieldset': {
                        borderColor: '#64ffda', 
                        boxShadow: '0 0 8px rgba(100, 255, 218, 0.1)', // Hafif neon parlaması
                    },
                    // Tıklanınca (Focus)
                    '&.Mui-focused fieldset': {
                        borderColor: '#64ffda',
                        borderWidth: '2px',
                    },
                },
                // Input İçindeki Yazı Alanı
                input: {
                    padding: '16.5px 14px', // Yükseklik ayarı
                    color: '#e6f1ff',       // Yazı rengi
                    
                    // --- KRİTİK AYAR: AUTOFILL DÜZELTMESİ ---
                    // Tarayıcı otomatik doldurma yapınca arka planı bozmaması için:
                    '&:-webkit-autofill': {
                        '-webkit-box-shadow': '0 0 0 100px #112240 inset !important', // Arka planı zorla lacivert yap
                        '-webkit-text-fill-color': '#e6f1ff !important', // Yazıyı beyaz yap
                        'caret-color': '#64ffda', // İmleç rengi
                        borderRadius: 'inherit',
                    },
                },
            },
        },
        // Drawer (Sidebar) stilini buradan yönetebiliriz (Opsiyonel)
        MuiDrawer: {
            styleOverrides: {
                paper: {
                    backgroundColor: '#112240',
                    color: '#ccd6f6',
                    borderRight: '1px solid rgba(255,255,255,0.05)',
                }
            }
        },
        // AppBar (Üst Menü) stili
        MuiAppBar: {
            styleOverrides: {
                root: {
                    backgroundColor: 'rgba(10, 25, 47, 0.85)',
                    backdropFilter: 'blur(10px)',
                    boxShadow: '0 4px 30px rgba(0, 0, 0, 0.1)',
                }
            }
        }
    },
});

export default theme;