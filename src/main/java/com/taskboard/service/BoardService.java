package com.taskboard.service;

import com.taskboard.model.Board;
import com.taskboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> findAllBoards() {
        return boardRepository.findAll();
    }

    public Board createBoard(Board board){
        return boardRepository.save(board);
    }

    public Board getBoardById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
