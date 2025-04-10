package com.taskboard.controller;

import com.taskboard.model.TaskColumn;
import com.taskboard.service.TaskColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/columns")
@CrossOrigin(origins = "*")
public class TaskColumnController {

    @Autowired
    private TaskColumnService taskColumnService;

    @GetMapping
    public List<TaskColumn> getAllBoards(){
        return taskColumnService.getAllColumns();
    }

    @PostMapping
    public TaskColumn createColumn(@RequestBody TaskColumn taskColumn){
        return taskColumnService.createColums(taskColumn);
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
