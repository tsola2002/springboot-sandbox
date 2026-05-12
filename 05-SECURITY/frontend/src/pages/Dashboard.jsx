import CustomerTable from "../components/CustomerTable";
import { Button } from "@mui/material";
import { useAuth } from "../context/AuthContext";

export default function Dashboard() {
  const { logout } = useAuth();

  return (
    <>
      <Button onClick={logout}>Logout</Button>
      <CustomerTable />
    </>
  );
}