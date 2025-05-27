package com.inventory.data.Controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.data.Model.Barang;
import com.inventory.data.Repository.BarangRepository;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/barang")
public class BarangController {

    @Autowired
    private BarangRepository barangRepository;

    @GetMapping
    public List<Barang> getAll() {
        return barangRepository.findAll();
    }

    @PostMapping
    public Map<String, String> addBarang(@RequestBody Barang barang) {
        barangRepository.save(barang);
        return Collections.singletonMap("message", "Barang berhasil ditambahkan.");
    }
}
