import { useState } from "react";
import { TextField, Button, Box, Paper } from "@mui/material";
import { useAuth } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";
import { useSnackbar } from "notistack";

export default function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const { login } = useAuth();
  const navigate = useNavigate();
  const { enqueueSnackbar } = useSnackbar();

  const handleSubmit = async () => {
    try {
      await login(username, password);
      enqueueSnackbar("Login successful", { variant: "success" });
      navigate("/");
    } catch  {
      enqueueSnackbar("Invalid credentials", { variant: "error" });
    }
  };

  return (
    <Box display="flex" justifyContent="center" mt={10}>
      <Paper sx={{ p: 4, width: 300 }}>
        <TextField fullWidth label="Username" onChange={(e) => setUsername(e.target.value)} />
        <TextField fullWidth type="password" label="Password" sx={{ mt: 2 }} onChange={(e) => setPassword(e.target.value)} />
        <Button fullWidth variant="contained" sx={{ mt: 2 }} onClick={handleSubmit}>
          Login
        </Button>
      </Paper>
    </Box>
  );
}