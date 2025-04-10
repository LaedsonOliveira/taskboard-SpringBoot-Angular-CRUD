package com.taskboard.model;


import jakarta.persistence.*;


import java.util.List;

@Entity
public class TaskColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int orderIndex;
    private String type;  //inicial, pendente, final, cancelado

    @ManyToOne
    @JoinColumn(name = "border_id")
    private Board board;

    @OneToMany(mappedBy = "column", cascade = CascadeType.ALL)
    private List<Card> card;


    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }
}
