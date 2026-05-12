// import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import { AuthProvider } from "./context/AuthContext";
import { SnackbarProvider } from "notistack";

ReactDOM.createRoot(document.getElementById("root")).render(
  <SnackbarProvider maxSnack={3}>
    <AuthProvider>
      <App />
    </AuthProvider>
  </SnackbarProvider>
);