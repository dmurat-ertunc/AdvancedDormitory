import React from 'react';
import { Grid, Paper, Typography, Box, useTheme } from '@mui/material';
import {
  PeopleAlt,
  MeetingRoom,
  WarningAmber,
  Hotel
} from '@mui/icons-material';
import {
  AreaChart,
  Area,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  ResponsiveContainer
} from 'recharts';
import { motion } from 'framer-motion';

// ---------------- DATA ----------------
const stats = [
  {
    title: 'Toplam Öğrenci',
    value: '1,250',
    icon: <PeopleAlt fontSize="large" />,
    color: '#64ffda',
    bg: 'rgba(100, 255, 218, 0.1)'
  },
  {
    title: 'Toplam Yatak',
    value: '1,221',
    icon: <Hotel fontSize="large" />,
    color: '#bd34fe',
    bg: 'rgba(189, 52, 254, 0.1)'
  },
  {
    title: 'Toplam Oda',
    value: '450',
    icon: <MeetingRoom fontSize="large" />,
    color: '#2196f3',
    bg: 'rgba(33, 150, 243, 0.1)'
  },
  {
    title: 'Boş Yataklar',
    value: '12',
    icon: <WarningAmber fontSize="large" />,
    color: '#ffd700',
    bg: 'rgba(255, 215, 0, 0.1)'
  }
];

const chartData = [
  { name: 'Oca', gelir: 4000 },
  { name: 'Şub', gelir: 3000 },
  { name: 'Mar', gelir: 5000 },
  { name: 'Nis', gelir: 2780 },
  { name: 'May', gelir: 6890 },
  { name: 'Haz', gelir: 8390 },
  { name: 'Tem', gelir: 5390 },
  { name: 'Ağu', gelir: 2390 },
  { name: 'Eyl', gelir: 1390 },
  { name: 'Eki', gelir: 8390 },
  { name: 'Kas', gelir: 4390 },
  { name: 'Ara', gelir: 12390 }
];

// ---------------- COMPONENT ----------------
const DashboardPage = () => {
  const theme = useTheme();

  const containerVariants = {
    hidden: { opacity: 0 },
    visible: { opacity: 1, transition: { staggerChildren: 0.1 } }
  };

  const itemVariants = {
    hidden: { y: 20, opacity: 0 },
    visible: { y: 0, opacity: 1 }
  };

  return (
    <Box sx={{ width: '100%', pb: 2 }}>
      <motion.div variants={containerVariants} initial="hidden" animate="visible">

        {/* -------- BAŞLIK -------- */}
        <Box sx={{ mb: 4 }}>
          <Typography variant="h4" fontWeight="bold">
            Genel Bakış
          </Typography>
          <Typography variant="body1" color="text.secondary" mt={1}>
            Yurt durumuna ait anlık istatistikler
          </Typography>
        </Box>

        {/* ======================================================
            ÜSTTEKİ 4 KUTUCUK – TAM SATIR (%100)
           ====================================================== */}
        <Grid
          container
          spacing={3}
          sx={{
            mb: 4,
            width: '100%',
            mx: 0
          }}
        >
          {stats.map((stat, index) => (
            <Grid
              key={index}
              item
              xs={12}
              sm={6}
              md={3}   // 12 / 4 = 3 → TAM DOLUM
              sx={{ display: 'flex' }}
            >
              <motion.div variants={itemVariants} style={{ width: '100%', height: '100%' }}>
                <Paper
                  elevation={0}
                  sx={{
                    p: 3,
                    width: '100%',
                    height: '100%',
                    borderRadius: 3,
                    bgcolor: 'background.paper',
                    border: '1px solid rgba(255,255,255,0.05)',
                    display: 'flex',
                    flexDirection: 'column',
                    justifyContent: 'space-between',
                    transition: 'all 0.3s ease',
                    '&:hover': {
                      transform: 'translateY(-5px)',
                      boxShadow: '0 10px 20px rgba(0,0,0,0.2)',
                      borderColor: stat.color
                    }
                  }}
                >
                  <Box display="flex" justifyContent="space-between">
                    <Box>
                      <Typography
                        variant="subtitle2"
                        sx={{
                          color: 'text.secondary',
                          fontWeight: 600,
                          textTransform: 'uppercase',
                          letterSpacing: 1
                        }}
                      >
                        {stat.title}
                      </Typography>
                      <Typography variant="h4" fontWeight="bold" mt={1}>
                        {stat.value}
                      </Typography>
                    </Box>

                    <Box
                      sx={{
                        p: 1.5,
                        borderRadius: 2,
                        bgcolor: stat.bg,
                        color: stat.color,
                        display: 'flex',
                        alignItems: 'center',
                        justifyContent: 'center'
                      }}
                    >
                      {stat.icon}
                    </Box>
                  </Box>

                  <Typography variant="caption" sx={{ color: 'rgba(255,255,255,0.3)' }}>
                    Geçen aya göre <span style={{ color: '#64ffda' }}>+2.5%</span>
                  </Typography>
                </Paper>
              </motion.div>
            </Grid>
          ))}
        </Grid>

        {/* ======================================================
            GRAFİK – TAM SATIR (%100)
           ====================================================== */}
        <Grid container spacing={3} sx={{ width: '100%', mx: 0 }}>
          <Grid item xs={12} sx={{ width: '100%' }}>
            <motion.div variants={itemVariants} style={{ height: '100%' }}>
              <Paper
                sx={{
                  p: 3,
                  width: '100%',
                  height: 500,
                  borderRadius: 3,
                  bgcolor: 'background.paper',
                  border: '1px solid rgba(255,255,255,0.05)',
                  display: 'flex',
                  flexDirection: 'column'
                }}
              >
                <Typography variant="h6" fontWeight="bold" mb={2}>
                  Yıllık Gelir Analizi
                </Typography>

                <Box sx={{ flexGrow: 1, width: '100%', minHeight: 0 }}>
                  <ResponsiveContainer width="100%" height="100%">
                    <AreaChart data={chartData}>
                      <defs>
                        <linearGradient id="colorGelir" x1="0" y1="0" x2="0" y2="1">
                          <stop offset="5%" stopColor="#64ffda" stopOpacity={0.3} />
                          <stop offset="95%" stopColor="#64ffda" stopOpacity={0} />
                        </linearGradient>
                      </defs>

                      <CartesianGrid strokeDasharray="3 3" stroke="rgba(255,255,255,0.05)" vertical={false} />
                      <XAxis dataKey="name" tick={{ fill: '#8892b0' }} axisLine={false} tickLine={false} />
                      <YAxis tick={{ fill: '#8892b0' }} axisLine={false} tickLine={false} />
                      <Tooltip
                        contentStyle={{
                          backgroundColor: '#112240',
                          borderRadius: 8,
                          border: '1px solid rgba(255,255,255,0.1)',
                          color: '#fff'
                        }}
                      />
                      <Area
                        type="monotone"
                        dataKey="gelir"
                        stroke="#64ffda"
                        strokeWidth={3}
                        fill="url(#colorGelir)"
                      />
                    </AreaChart>
                  </ResponsiveContainer>
                </Box>
              </Paper>
            </motion.div>
          </Grid>
        </Grid>

      </motion.div>
    </Box>
  );
};

export default DashboardPage;
