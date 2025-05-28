package com.inventory.data.Repository;

import com.inventory.data.Model.Riwayat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RiwayatRepository extends MongoRepository<Riwayat, String> {
}
