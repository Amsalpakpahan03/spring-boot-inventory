package com.inventory.data.Controller;

import com.inventory.data.Model.Riwayat;
import com.inventory.data.Repository.RiwayatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RiwayatController {

    @Autowired
    private RiwayatRepository riwayatRepository;

    @GetMapping("/api/riwayat")
    public List<Riwayat> getRiwayat() {
        return riwayatRepository.findAll();
    }
}
