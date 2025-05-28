package com.inventory.data.Service;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;

import com.inventory.data.Model.Nota;
import com.inventory.data.Model.ItemNota;
import com.inventory.data.Model.Barang;
import com.inventory.data.Repository.BarangRepository;


@Service
public class NotaService {
    @Autowired
    private BarangRepository barangRepository;

    public Nota prosesNota(List<ItemNota> requestItems) {
        List<ItemNota> notaItems = new ArrayList<>();
        int totalHarga = 0;

        for (ItemNota item : requestItems) {
            Barang barang = barangRepository.findByNama(item.getNamaBarang())
                .orElseThrow(() -> new RuntimeException("Barang tidak ditemukan: " + item.getNamaBarang()));

            if (barang.getJumlah() < item.getJumlah()) {
                throw new RuntimeException("Stok tidak cukup untuk " + item.getNamaBarang());
            }

            int hargaTotal = barang.getHarga() * item.getJumlah();
            barang.setJumlah(barang.getJumlah() - item.getJumlah());
            barangRepository.save(barang);

            notaItems.add(new ItemNota(item.getNamaBarang(), item.getJumlah(), hargaTotal));
            totalHarga += hargaTotal;
        }

        Nota nota = new Nota();
        nota.setItems(notaItems);
        nota.setTotalHarga(totalHarga);
        return nota;
    }
}
