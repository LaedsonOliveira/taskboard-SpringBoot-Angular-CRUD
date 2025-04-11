import { Card } from "./card.model"

export interface TaskColumn {
    id: number;
    name: string;
    cards: Card[];
}