package com.inventory.data.Model;

public class ItemNota {
    private String nama_barang;
    private int jumlah;
    private int harga_total;

    public String getNama_barang() {
        return this.nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public int getJumlah() {
        return this.jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getHarga_total() {
        return this.harga_total;
    }

    public void setHarga_total(int harga_total) {
        this.harga_total = harga_total;
    }


    public ItemNota() {}

    public ItemNota(String nama_barang, int jumlah, int harga_total) {
        this.nama_barang = nama_barang;
        this.jumlah = jumlah;
        this.harga_total = harga_total;
    }

    // Getters dan Setters
}
