package com.inventory.data.Model;

import java.util.List;

public class Nota {
    private List<ItemNota> items;
    private int total_harga;

    public List<ItemNota> getItems() {
        return this.items;
    }

    public void setItems(List<ItemNota> items) {
        this.items = items;
    }

    public int getTotal_harga() {
        return this.total_harga;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }

    public Nota() {}

    public Nota(List<ItemNota> items, int total_harga) {
        this.items = items;
        this.total_harga = total_harga;
    }

    // Getters dan Setters
}
