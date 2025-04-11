import { TaskColumn } from "./task-column.model"

export interface Board {
    id: number;
    name: string;
    columns: TaskColumn[];
    

}