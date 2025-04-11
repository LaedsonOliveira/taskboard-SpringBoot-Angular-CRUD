import { Component, OnInit } from '@angular/core';
import { TaskColumn } from '../../models/task-column.model';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskColumnService } from '../../services/task-column.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-task-column',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './task-column.component.html',
  styleUrl: './task-column.component.css'
})
export class TaskColumnComponent implements OnInit{
[x: string]: any;
  columns: TaskColumn[] = [];
  boardId!: number;


  constructor (
    private route: ActivatedRoute,
    private router: Router,
    private columnService: TaskColumnService
  ){}

  ngOnInit(): void{
    this.boardId = Number(this.route.snapshot.paramMap.get('boardId'));
    this.loadColumns();
  }
  loadColumns() : void {
    this.columnService.getColumnsByBoard(this.boardId).subscribe((data) =>{
      this.columns = data;
    });
  }

  goToCards(columId: number): void{
    this.router.navigate(['/cards',columId])
  }

  newColumn: TaskColumn = {
    id: 0,
    name: "",
    cards: []
  }

  //Criar Coluna
  createColumn(): void{
    this.columnService.createColumn(this.boardId, this.newColumn).subscribe((data) =>{
      console.log("Coluna criada", data);
      this.newColumn = {id:0, name: "", cards:[]};
      this.loadColumns();
    });

  }

  goToBoards(): void{
    this.router.navigate(['/boards']);
  }

}
