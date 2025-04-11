import { RouterModule, Routes } from '@angular/router';
import { BoardComponent } from './components/board/board.component';

import { NgModule } from '@angular/core';
import { TaskColumnComponent } from './components/task-column/task-column.component';
import { CardComponent } from './components/card/card.component';
import { FormsModule } from '@angular/forms';

export const routes: Routes = [
    { path: '', redirectTo: 'board', pathMatch: 'full'},
    { path: 'board', component: BoardComponent},
    { path: "columns/:boardId", component: TaskColumnComponent},
    { path: "cards/:boardId", component: CardComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes), FormsModule],
    exports: [RouterModule]
})

export class AppRoutingModule{}