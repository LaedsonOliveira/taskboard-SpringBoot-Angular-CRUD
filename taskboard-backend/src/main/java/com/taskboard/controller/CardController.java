package com.taskboard.controller;

import com.taskboard.model.Card;
import com.taskboard.model.TaskColumn;
import com.taskboard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards/columns/cards")
@CrossOrigin(origins = "*")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/column/{columnId}")
    public List<Card> getAllCardsByColumn(@PathVariable Long columnId) {
        return cardService.getAllCardsByColumn(columnId);
    }

    @GetMapping("/{Id}")
    public Card getCardById(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    @PostMapping("/{columnId}")
    public Card createCard(@PathVariable Long columnId, @RequestBody Card card){
        return cardService.createCard(columnId, card);
    }

    @PutMapping("/{id}")
    public Card updateCard(@PathVariable Long id, @RequestBody Card card){
        return cardService.updateCard(id, card);
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id){
        cardService.deleteCard(id);
    }



}
