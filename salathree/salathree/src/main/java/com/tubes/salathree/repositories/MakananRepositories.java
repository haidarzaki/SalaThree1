package com.tubes.salathree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tubes.salathree.models.Makanan;

import java.util.List;

@Repository
public interface MakananRepositories extends JpaRepository<Makanan, Integer> {

    @Query(value = "SELECT * FROM makanan WHERE name_makanan LIKE %?1% OR description LIKE %?1% OR label_id IN (SELECT label_id FROM label WHERE detail LIKE %?1%)", nativeQuery = true)
    List<Makanan> searchProduct(String keyword);

    @Query(value = "SELECT * FROM makanan WHERE name_makanan = ?1", nativeQuery = true)
    List<Makanan> findMakananByNameMakanan(String nameMakanan);

    @Query(value = "SELECT * FROM makanan WHERE detail IN (SELECT label_id FROM label WHERE detail = ?1)", nativeQuery = true)
    List<Makanan> findMakananByLabelName(String detail);

}
