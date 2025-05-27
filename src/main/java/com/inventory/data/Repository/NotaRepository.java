package com.inventory.data.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inventory.data.Model.Nota;

public interface NotaRepository extends MongoRepository<Nota, String> {
    // MongoDB pakai String sebagai tipe ID default
}
