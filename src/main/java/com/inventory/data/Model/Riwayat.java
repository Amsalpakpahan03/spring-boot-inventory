package com.inventory.data.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "riwayat")
public class Riwayat {
    @Id
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


    private String nama_barang;
    private int jumlah;
    private String status;
    private String tanggal;

    public Riwayat() {}

    public Riwayat(String nama_barang, int jumlah, String status, String tanggal) {
        this.nama_barang = nama_barang;
        this.jumlah = jumlah;
        this.status = status;
        this.tanggal = tanggal;
    }

    // Getters & Setters
    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
