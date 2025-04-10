package com.taskboard.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<TaskColumn> columns;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TaskColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<TaskColumn> columns) {
        this.columns = columns;
    }
}
