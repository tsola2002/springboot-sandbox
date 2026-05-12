import { Dialog, DialogTitle, DialogContent, TextField, Button } from "@mui/material";
import { useState, useEffect } from "react";

export default function CustomerModal({ open, handleClose, handleSave, editData }) {
  const [form, setForm] = useState({ name: "", email: "" });

  useEffect(() => {
    if (editData) setForm(editData);
  }, [editData]);

  return (
    <Dialog open={open} onClose={handleClose}>
      <DialogTitle>{editData ? "Edit" : "Create"} Customer</DialogTitle>
      <DialogContent>
        <TextField fullWidth label="Name" sx={{ mt: 2 }} value={form.name}
          onChange={(e) => setForm({ ...form, name: e.target.value })} />
        <TextField fullWidth label="Email" sx={{ mt: 2 }} value={form.email}
          onChange={(e) => setForm({ ...form, email: e.target.value })} />
        <Button sx={{ mt: 2 }} variant="contained" onClick={() => handleSave(form)}>
          Save
        </Button>
      </DialogContent>
    </Dialog>
  );
}