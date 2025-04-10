package com.taskboard.controller;

import com.taskboard.model.TaskColumn;
import com.taskboard.service.TaskColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards/columns")
@CrossOrigin(origins = "*")
public class TaskColumnController {

    @Autowired
    private TaskColumnService taskColumnService;

    @GetMapping
    public List<TaskColumn> getAllBoards(){
        return taskColumnService.getAllColumns();
    }

    @PostMapping("/{boardId}")
    public ResponseEntity<TaskColumn> createColumn(@PathVariable Long boardId, @RequestBody TaskColumn taskColumn){
        TaskColumn createColumn = taskColumnService.createColums(boardId, taskColumn);
        return new ResponseEntity<>(createColumn, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public TaskColumn getColumnById(@PathVariable Long id){
        return  taskColumnService.getColumnById(id);
    }

    @PutMapping("/{id}")
    public TaskColumn updateColumn(@PathVariable Long id, @RequestBody TaskColumn column){
        return taskColumnService.updateColumn(id, column);
    }

    @DeleteMapping("/{id}")
    public void deleteColumn(@PathVariable Long id){
        taskColumnService.deleteColumn(id);
    }
}
