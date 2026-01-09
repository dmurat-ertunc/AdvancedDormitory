import axios from "axios";

// Base URL'i buraya yazıyoruz (Vite kullanıyorsan .env dosyasından çekmek en iyisidir)
// Örn: VITE_API_URL=http://localhost:8080/api
const BASE_URL = "http://localhost:2552/api"; 

const api = axios.create({
  baseURL: BASE_URL,
  headers: {
    "Content-Type": "application/json",
  },
});

// REQUEST INTERCEPTOR (İstek Atılmadan Önce Araya Girer)
// Amacı: LocalStorage'da token varsa alıp Header'a "Bearer <token>" olarak eklemek.
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token"); // Token'ı 'token' adıyla saklayacağız
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// RESPONSE INTERCEPTOR (Cevap Geldikten Sonra Araya Girer)
// Amacı: 401 (Yetkisiz) hatası gelirse kullanıcıyı log out yapabiliriz.
api.interceptors.response.use(
  (response) => {
    return response;
  },
  (error) => {
    // Eğer token geçersizse veya süresi dolmuşsa (401)
    if (error.response && error.response.status === 401) {
      // Opsiyonel: Otomatik çıkış yap
      // localStorage.removeItem("token");
      // window.location.href = "/login";
    }
    return Promise.reject(error);
  }
);

export default api;