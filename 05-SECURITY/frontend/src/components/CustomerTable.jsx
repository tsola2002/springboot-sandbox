import { useEffect, useState } from "react";
import api from "../api/axios";
import {
  Table, TableBody, TableCell, TableHead, TableRow,
  Button, TextField
} from "@mui/material";
import CustomerModal from "./CustomerModal";
import { useSnackbar } from "notistack";

function CustomerTable() {

  const [data, setData] = useState([]);
  const [search, setSearch] = useState("");
  const [open, setOpen] = useState(false);
  const [edit, setEdit] = useState(null);
  const { enqueueSnackbar } = useSnackbar();
    

  const fetchData = async () => {
    const res = await api.get("/api/v1/customers");
    setData(res.data);
    };
    
  useEffect(() => { fetchData(); }, []);

  const handleSave = async (form) => {
    try {
      if (edit) {
        await api.put(`/api/v1/customers/${edit.id}`, form);
        enqueueSnackbar("Updated successfully", { variant: "success" });
      } else {
        await api.post("/api/v1/customers", form);
        enqueueSnackbar("Created successfully", { variant: "success" });
      }
      setOpen(false);
      setEdit(null);
      fetchData();
    } catch {
      enqueueSnackbar("Operation failed", { variant: "error" });
    }
  };

  const handleDelete = async (id) => {
    try {
      await api.delete(`/api/v1/customers/${id}`);
      enqueueSnackbar("Deleted", { variant: "success" });
      fetchData();
    } catch {
      enqueueSnackbar("Delete failed", { variant: "error" });
    }
  };

  const filtered = data.filter((c) =>
    c.name?.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <>
      <TextField label="Search" onChange={(e) => setSearch(e.target.value)} />
      <Button onClick={() => setOpen(true)}>Add Customer</Button>

      <Table>
        <TableHead>
          <TableRow>
            <TableCell>ID</TableCell>
            <TableCell>Name</TableCell>
            <TableCell>Email</TableCell>
            <TableCell>Actions</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {filtered.map((c) => (
            <TableRow key={c.id}>
              <TableCell>{c.id}</TableCell>
              <TableCell>{c.name}</TableCell>
              <TableCell>{c.email}</TableCell>
              <TableCell>
                <Button onClick={() => { setEdit(c); setOpen(true); }}>Edit</Button>
                <Button color="error" onClick={() => handleDelete(c.id)}>Delete</Button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>

      <CustomerModal
        open={open}
        handleClose={() => setOpen(false)}
        handleSave={handleSave}
        editData={edit}
      />
    </>
  );
}

export default CustomerTable