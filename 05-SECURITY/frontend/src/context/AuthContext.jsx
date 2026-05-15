import { createContext, useContext, useState } from "react";
import api from "../api/axios";

// CREATE REACT CONTEXT USING CONTEXT API
const AuthContext = createContext();


export const AuthProvider = ({ children }) => {
  // creating state to track users logged in state
  const [isAuthenticated, setIsAuthenticated] = useState(
    !!localStorage.getItem("token")
  );

  // LOGIN FUNCTION TO CONNECT TO THE SPRING BACKEND
  const login = async (username, password) => {
    try {
      const response = await api.post("/auth/login", {
        username,
        password,
      });

      localStorage.setItem("token", response.data.token);

      console.log("JWT TOKEN", localStorage.getItem("token"));

      setIsAuthenticated(true);

      return true;
    } catch (error) {
      throw error;
    }
  };

  const logout = () => {
    localStorage.removeItem("token");
    setIsAuthenticated(false);
  };

  return (
    <AuthContext.Provider
      value={{
        login,
        logout,
        isAuthenticated,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => useContext(AuthContext);