import { Component, OnInit } from '@angular/core';
import { Board } from '../../models/board.model';
import { BoardService } from '../../services/board.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-board',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './board.component.html',
  styleUrl: './board.component.css'
})
export class BoardComponent implements OnInit {

  boards:Board[] = [];


  constructor(private boardService:BoardService, private router: Router){}

  ngOnInit(): void {
      this.loadBoards();
  }

  loadBoards(): void {
    this.boardService.getAllBoards().subscribe((data) =>{
      this.boards = data;
    });
  }

  goToColumns(boardId: number): void {
    this.router.navigate(['/columns', boardId]);
  }

  newBoard: Board = {
    id: 0,
    name: '',
    columns: []
  };

  //Função Criar Board
  createBoard(): void {
    this.boardService.createBoard(this.newBoard).subscribe((data) =>{
      console.log("Board criada", data);
      this.newBoard = { id: 0, name: "", columns:[]};
    });
  }

  goToCreateColumn(boardId: number): void {
    this.router.navigate(['/columns', boardId]);
  }
}
