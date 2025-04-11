export interface Card{
    id: number;
    title: string;
    description: string;
    createAt: string;
    blocked: boolean;
    blockReason?: string;
    columnId: number;
}