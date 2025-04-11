import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Board } from '../models/board.model';

@Injectable({
  providedIn: 'root'
})

export class BoardService {
  private apiURL = "http://localhost:8080/api/boards";
  constructor(private http: HttpClient) {}

  getAllBoards(): Observable<Board[]> {
    return this.http.get<Board[]>(this.apiURL)
  }

  getBoardById(id: number): Observable<Board> {
    return this.http.get<Board>(`${this.apiURL}/${id}`);
  }

  createBoard(board: Board): Observable<Board> {
    return this.http.post<Board>(this.apiURL, board);
  }

  updateBoard(id: number, board: Board): Observable<Board> {
    return this.http.put<Board>(`${this.apiURL}/${id}`, board);
  }

  deleteBoard(id: number): Observable<void>{
    return this.http.delete<void>(`${this.apiURL}/${id}`)
  }
}
