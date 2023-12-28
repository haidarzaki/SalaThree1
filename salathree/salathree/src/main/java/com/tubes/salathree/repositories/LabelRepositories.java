package com.tubes.salathree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tubes.salathree.models.Label;

@Repository
public interface LabelRepositories extends JpaRepository<Label, Integer> {

    @Query(value = "SELECT * FROM label WHERE detail LIKE %?1%", nativeQuery = true)
    List<Label> findLabelByName(String keyword);

    @Query(value = "SELECT * FROM label WHERE label_id ?1", nativeQuery = true)
    List<Label> findLabelByLabelId(int label_id);
}
