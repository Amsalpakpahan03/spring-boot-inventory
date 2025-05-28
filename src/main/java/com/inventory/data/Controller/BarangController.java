package com.inventory.data.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.data.Model.Barang;
import com.inventory.data.Model.Riwayat;
import com.inventory.data.Repository.BarangRepository;
import com.inventory.data.Repository.RiwayatRepository;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/barang")
public class BarangController {

    @Autowired
    private BarangRepository barangRepository;

    @Autowired
    private RiwayatRepository riwayatRepository;

    @GetMapping
    public List<Barang> getAll() {
        return barangRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> addBarang(@RequestBody Barang barang) {
        try {
            barangRepository.save(barang);

            Riwayat riwayat = new Riwayat();
            riwayat.setNama_barang(barang.getNama());
            riwayat.setJumlah(barang.getJumlah());
            riwayat.setStatus("Masuk");
            riwayat.setTanggal(LocalDate.now().toString());

            riwayatRepository.save(riwayat);

            // Respon sukses dengan pesan dan data yang disimpan
            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message", "Barang berhasil ditambahkan",
                    "data", barang
            ));

        } catch (Exception e) {
            // Respon gagal dengan pesan error
            return ResponseEntity.status(500).body(Map.of(
                    "status", "error",
                    "message", "Gagal menambahkan barang: " + e.getMessage()
            ));
        }
    }
    // Ambil barang by ID

    @GetMapping("/{id}")
    public ResponseEntity<Barang> getById(@PathVariable String id) {
        Barang barang = barangRepository.findById(id).orElse(null);
        return barang != null ? ResponseEntity.ok(barang) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBarang(@PathVariable String id, @RequestBody Barang updated) {
        return barangRepository.findById(id)
                .map(existing -> {
                    existing.setNama(updated.getNama());
                    existing.setKategori(updated.getKategori());
                    existing.setJumlah(updated.getJumlah());
                    existing.setHarga(updated.getHarga());
                    barangRepository.save(existing);
                    return ResponseEntity.ok(Map.of("message", "Barang berhasil diupdate"));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        barangRepository.deleteById(id);
        return ResponseEntity.ok(Map.of("message", "Barang berhasil dihapus"));
    }

}
