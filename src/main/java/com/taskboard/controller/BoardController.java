package com.taskboard.controller;

import com.taskboard.model.Board;
import com.taskboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@CrossOrigin(origins = "*")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public List<Board> getAllBoards(){
        return boardService.findAllBoards();
    }

    @PostMapping
    public Board createBoard(@RequestBody Board board){
        return boardService.createBoard(board);
    }

    @GetMapping("/{id}")
    public Board getBoard(@PathVariable Long id){
        return boardService.getBoardById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id){
        boardService.deleteBoard(id);
    }

}
