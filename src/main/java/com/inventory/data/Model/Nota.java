package com.inventory.data.Model;

import java.util.List;

public class Nota {
    private String id; // Jika pakai MongoDB atau auto-gen id
    private List<ItemNota> items;
    private int totalHarga;
    private String tanggal; // Format string, misal "2025-05-28"

    public Nota() {
    }

    // Constructor lengkap dengan tanggal
    public Nota(List<ItemNota> items, int totalHarga, String tanggal) {
        this.items = items;
        this.totalHarga = totalHarga;
        this.tanggal = tanggal;
    }

    // Constructor tanpa tanggal (opsional)
    public Nota(List<ItemNota> items, int totalHarga) {
        this.items = items;
        this.totalHarga = totalHarga;
    }

    // Getter dan Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ItemNota> getItems() {
        return items;
    }

    public void setItems(List<ItemNota> items) {
        this.items = items;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
