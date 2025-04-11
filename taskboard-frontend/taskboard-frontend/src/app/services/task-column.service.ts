import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TaskColumn } from '../models/task-column.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskColumnService {
  private apiUrl = "http://localhost:8080/api/boards/columns"

  constructor(private http: HttpClient) {}

  createColumn(boardId: number, column: TaskColumn): Observable<TaskColumn>{
    return this.http.post<TaskColumn>(`${this.apiUrl}/${boardId}`, column);
  }

  updateColumn(id: number, column: TaskColumn): Observable<TaskColumn>{
    return this.http.put<TaskColumn>(`${this.apiUrl}/${id}`, column);
  }

  deleteColumn(id: number): Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }


  //Atenção com esse método
  getColumnsByBoard(boardId: number): Observable<TaskColumn[]> {
    return this.http.get<TaskColumn[]>(`${this.apiUrl}/board/${boardId}`);
  }
}
