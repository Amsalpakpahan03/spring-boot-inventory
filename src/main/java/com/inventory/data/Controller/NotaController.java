package com.inventory.data.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.data.Model.Barang;
import com.inventory.data.Model.ItemNota;
import com.inventory.data.Model.Nota;
import com.inventory.data.Model.Riwayat;
import com.inventory.data.Repository.BarangRepository;
import com.inventory.data.Repository.NotaRepository;
import com.inventory.data.Repository.RiwayatRepository;
import com.inventory.data.dto.NotaRequest;

@RestController
@RequestMapping("/api/nota")
public class NotaController {

    @Autowired
    private BarangRepository barangRepository;

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
private RiwayatRepository riwayatRepository;

@PostMapping
public ResponseEntity<?> buatNota(@RequestBody NotaRequest request) {
    List<ItemNota> items = new ArrayList<>();
    int totalHarga = 0;

    for (NotaRequest.ItemRequest itemReq : request.getItems()) {
        Barang barang = barangRepository.findByNama(itemReq.getNama_barang()).orElse(null);

        if (barang == null) {
            return ResponseEntity.badRequest().body(Map.of("message", "Barang " + itemReq.getNama_barang() + " tidak ditemukan."));
        }

        if (barang.getJumlah() < itemReq.getJumlah()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Stok barang " + itemReq.getNama_barang() + " tidak cukup."));
        }

        int hargaTotal = barang.getHarga() * itemReq.getJumlah();
        items.add(new ItemNota(barang.getNama(), itemReq.getJumlah(), hargaTotal));

        // Kurangi stok
        barang.setJumlah(barang.getJumlah() - itemReq.getJumlah());
        barangRepository.save(barang);

        // Simpan riwayat keluar
        Riwayat riwayat = new Riwayat();
        riwayat.setNama_barang(barang.getNama());
        riwayat.setJumlah(itemReq.getJumlah());
        riwayat.setStatus("Keluar");
        riwayat.setTanggal(LocalDate.now().toString());

        riwayatRepository.save(riwayat);

        totalHarga += hargaTotal;
    }

    Nota nota = new Nota(items, totalHarga);
    notaRepository.save(nota);

    Map<String, Object> response = new HashMap<>();
    response.put("message", "Nota berhasil dibuat");
    response.put("nota", nota);

    return ResponseEntity.ok(response);
}

}
