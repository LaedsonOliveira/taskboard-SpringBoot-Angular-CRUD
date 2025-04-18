package com.taskboard.repository;

import com.taskboard.model.TaskColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColumnRepository extends JpaRepository <TaskColumn, Long> {
}
