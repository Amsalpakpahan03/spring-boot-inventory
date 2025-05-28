package com.inventory.data.Model;

public class ItemNota {

    private String namaBarang;
    private int jumlah;
    private int hargaTotal;

    public ItemNota() {}

    public ItemNota(String namaBarang, int jumlah, int hargaTotal) {
        this.namaBarang = namaBarang;
        this.jumlah = jumlah;
        this.hargaTotal = hargaTotal;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getHargaTotal() {
        return hargaTotal;
    }

    public void setHargaTotal(int hargaTotal) {
        this.hargaTotal = hargaTotal;
    }
}
