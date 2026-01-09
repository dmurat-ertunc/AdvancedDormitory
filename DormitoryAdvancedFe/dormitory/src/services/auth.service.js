import api from "./api";

class AuthService {
  // Login İşlemi
  // Backend endpoint: /auth/login
  // Giden Data: { username, password }
  // Gelen Data: { accessToken, tokenType }
  async login(username, password) {
    try {
      const response = await api.post("/auth/login", {
        username,
        password,
      });

      // Token'ı kaydetme işlemi
      if (response.data.accessToken) {
        localStorage.setItem("token", response.data.accessToken);
        // İstersen kullanıcı bilgilerini de saklayabilirsin
        localStorage.setItem("user", JSON.stringify({ username }));
      }

      return response.data;
    } catch (error) {
      throw error; // Hatayı bileşene fırlat, orada yakala
    }
  }

  // Register İşlemi
  async register(username, password) {
    return await api.post("/auth/register", {
      username,
      password,
    });
  }

  // Logout İşlemi
  logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
  }
  
  // O anki kullanıcıyı alma (yardımcı metod)
  getCurrentUser() {
    return JSON.parse(localStorage.getItem("user"));
  }
}

export default new AuthService();