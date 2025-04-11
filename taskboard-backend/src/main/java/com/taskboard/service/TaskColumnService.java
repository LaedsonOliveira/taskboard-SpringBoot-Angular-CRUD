package com.taskboard.service;

import com.taskboard.model.Board;
import com.taskboard.model.TaskColumn;
import com.taskboard.repository.BoardRepository;
import com.taskboard.repository.ColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TaskColumnService {

    @Autowired
    private ColumnRepository  columnRepository;

    @Autowired
    private BoardRepository boardRepository;

    public List<TaskColumn> getAllColumns() {
        return columnRepository.findAll();
    }

    public TaskColumn createColums(Long boardId, TaskColumn taskColumn){
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("board com ID" + boardId + "não encontrado"));
        taskColumn.setBoard(board);
        return columnRepository.save(taskColumn);
    }

    public TaskColumn getColumnById(Long id){
        return columnRepository.findById(id).orElse(null);
    }

    public TaskColumn updateColumn(Long id, TaskColumn columnDetails){
        TaskColumn column = getColumnById(id);
        if(column != null){
            column.setName(columnDetails.getName());
            return columnRepository.save(column);
        }
        return null;
    }

    public void deleteColumn(Long id){
        columnRepository.deleteById(id);
    }


}
