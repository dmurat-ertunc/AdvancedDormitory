// src/context/AuthContext.jsx
import React, { createContext, useState, useContext, useEffect } from "react";
import AuthService from "../services/auth.service";
import { jwtDecode } from "jwt-decode";

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [token, setToken] = useState(localStorage.getItem("token") || null);

  // --- YARDIMCI FONKSİYON: Rolleri her zaman diziye (array) çevirir ---
  const parseRoles = (roleData) => {
    if (Array.isArray(roleData)) {
      return roleData; // Zaten liste ise olduğu gibi döndür
    } else if (typeof roleData === "string") {
      return [roleData]; // Tek bir string ise listeye sar: ["ADMIN"]
    }
    return []; // Hiçbiri değilse boş liste döndür
  };

  // 1. BAŞLANGIÇ STATE'İ
  const [user, setUser] = useState(() => {
    const storedToken = localStorage.getItem("token");
    if (storedToken) {
      try {
        const decoded = jwtDecode(storedToken);
        return { 
          ...decoded, 
          username: decoded.sub,
          // Rolleri "roles" adında bir dizi olarak saklıyoruz
          roles: parseRoles(decoded.role) 
        }; 
      } catch (error) {
        return null;
      }
    }
    return null;
  });

  // 2. LOGIN FONKSİYONU
  const login = async (username, password) => {
    try {
      const data = await AuthService.login(username, password);

      if (data.accessToken) {
        setToken(data.accessToken);

        try {
          const decoded = jwtDecode(data.accessToken);
          
          // Decode edilen veriyi standart hale getiriyoruz:
          const formattedUser = {
            ...decoded,           
            username: decoded.sub,       // sub -> username
            roles: parseRoles(decoded.role) // role -> roles (Dizi formatında)
          };

          setUser(formattedUser); 
          console.log("Kullanıcı ve Roller Hazır:", formattedUser);
        } catch (e) {
          console.error("Token hatası", e);
          setUser(null);
        }
      }
      return true;
    } catch (error) {
      console.error("Login Error:", error);
      throw error;
    }
  };

  const logout = () => {
    AuthService.logout();
    setToken(null);
    setUser(null);
  };

  useEffect(() => {
    if (token) {
      try {
        const decoded = jwtDecode(token);
        if (decoded.exp * 1000 < Date.now()) {
          logout();
        }
      } catch (error) {
        logout();
      }
    }
  }, [token]);

  // Kullanıcının rollerini ayrı bir değişken olarak da dışarı açıyoruz
  // Eğer user null ise boş dizi döner.
  const userRoles = user?.roles || [];

  const values = {
    token,
    user,
    userRoles, // <-- ARTIK ROLLER AYRI BİR LİSTE OLARAK ERİŞİLEBİLİR
    login,
    logout,
    isAuthenticated: !!token
  };

  return <AuthContext.Provider value={values}>{children}</AuthContext.Provider>;
};

export const useAuth = () => useContext(AuthContext);