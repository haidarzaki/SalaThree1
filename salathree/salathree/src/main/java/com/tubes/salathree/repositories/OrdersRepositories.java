package com.tubes.salathree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tubes.salathree.models.Orders;

@Repository
public interface OrdersRepositories extends JpaRepository<Orders, Integer> {
    @Query(value = "SELECT * FROM orders", nativeQuery = true)
    List<Orders> findAll();

    @Query(value = "SELECT * FROM orders WHERE pelanggan_id = ?1", nativeQuery = true)
    List<Orders> findAllByUserId(String pelanggan_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM orders WHERE sorted_menu_id = ?1", nativeQuery = true)
    void deleteMenuById(int sorted_menu_id);
}