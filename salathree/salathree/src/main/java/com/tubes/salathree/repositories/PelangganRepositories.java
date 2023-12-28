package com.tubes.salathree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.tubes.salathree.models.Pelanggan;

public interface PelangganRepositories extends JpaRepository<Pelanggan, Integer> {
    @Query(value = "SELECT * FROM pelanggan WHERE pelanggan_id = ?1", nativeQuery = true)
    Pelanggan findByPelanggan(String pelanggan_id);

    @Query(value = "SELECT * FROM pelanggan WHERE pelanggan_id = ?1", nativeQuery = true)
    List<Pelanggan> findAllByPelanggan(String pelanggan_id);

}
