package com.tubes.salathree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tubes.salathree.models.Sorted_Menu;

@Repository
public interface SortedMenuRepositories extends JpaRepository<Sorted_Menu, Integer> {
    @Query(value = "SELECT * FROM sorted_menu", nativeQuery = true)
    List<Sorted_Menu> findAll();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM sorted_menu WHERE makanan_id = ?1", nativeQuery = true)
    void deleteMenuById(int makanan_id);
}