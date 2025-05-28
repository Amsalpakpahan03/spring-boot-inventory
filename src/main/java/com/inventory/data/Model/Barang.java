package com.inventory.data.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("barang")
public class Barang {
    @Id
    private String id;

    private String nama;
    private int jumlah;
    private int harga;
    private String kategori; // ← Tambahkan ini

    public Barang() {}

    public Barang(String nama, int jumlah, int harga, String kategori) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
        this.kategori = kategori;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlah() {
        return this.jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getHarga() {
        return this.harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
