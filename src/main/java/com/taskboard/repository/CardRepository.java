package com.taskboard.repository;

import com.taskboard.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByColumnId(Long columnId);
}
