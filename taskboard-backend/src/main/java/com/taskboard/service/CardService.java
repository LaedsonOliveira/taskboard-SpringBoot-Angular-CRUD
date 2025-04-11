package com.taskboard.service;

import com.taskboard.model.Board;
import com.taskboard.model.Card;
import com.taskboard.model.TaskColumn;
import com.taskboard.repository.CardRepository;
import com.taskboard.repository.ColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ColumnRepository columnRepository;

    public List<Card> getAllCardsByColumn(Long columnId){
        return cardRepository.findByColumnId(columnId);
    }

    public Card createCard(Long columnId, Card card){
        Optional<TaskColumn> columnOptional = columnRepository.findById(columnId);
        if(columnOptional.isPresent()){
            TaskColumn column = columnOptional.get();
            card.setColumn(column);
            return cardRepository.save(card);
        }else{
            throw new RuntimeException("Coluna com ID" + columnId + " não encontrada.");
        }

    }

    public Card getCardById(Long id){
        return  cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card com ID" + id + "não encontrado"));
    }

    public Card updateCard(Long id, Card cardDetails){
        Card card = getCardById(id);
        card.setTitle(cardDetails.getTitle());
        card.setDescription(cardDetails.getDescription());
        return cardRepository.save(card);
    }

    public void deleteCard(Long id){
        Card card = getCardById(id); //Lançar erro automático
        cardRepository.deleteById(id);
    }
}
