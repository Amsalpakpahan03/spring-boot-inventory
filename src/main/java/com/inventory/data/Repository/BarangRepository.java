package com.inventory.data.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inventory.data.Model.Barang;

public interface BarangRepository extends MongoRepository<Barang, String> {
    Optional<Barang> findByNama(String nama);
}
