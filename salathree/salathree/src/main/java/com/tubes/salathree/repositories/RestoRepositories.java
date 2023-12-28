package com.tubes.salathree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tubes.salathree.models.Resto;
import com.tubes.salathree.models.Makanan;

import java.util.List;

@Repository
public interface RestoRepositories extends JpaRepository<Resto, Integer> {

    @Query(value = "SELECT * FROM resto WHERE name_resto LIKE %?1% OR description LIKE %?1% OR makanan_id IN (SELECT makanan_id FROM makanan WHERE name_makanan LIKE %?1%)", nativeQuery = true)
    List<Resto> searchMakanan(String keyword);

    @Query(value = "SELECT * FROM resto WHERE resto_id = ?1", nativeQuery = true)
    List<Resto> findRestoByRestoId(int resto_id);

    @Query(value = "SELECT * FROM resto WHERE name_resto = ?1", nativeQuery = true)
    List<Resto> findRestoByNameResto(String name_resto);

    @Query(value = "SELECT * FROM makanan WHERE makanan_id = ?1", nativeQuery = true)
    List<Makanan> findMakananByMakananId(int makanan_id);

}
