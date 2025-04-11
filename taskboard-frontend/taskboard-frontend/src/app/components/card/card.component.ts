import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Card } from '../../models/card.model';
import { ActivatedRoute, Router } from '@angular/router';
import { CardService } from '../../services/card.service';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-card',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './card.component.html',
  styleUrl: './card.component.css'
})
export class CardComponent implements OnInit {
  cards: Card[] = [];
  columnId!: number;

  constructor(
    private route: ActivatedRoute,
    private cardService: CardService, 
    private router: Router
  ){}

  ngOnInit(): void {
      this.columnId = Number(this.route.snapshot.paramMap.get("columnId"));
      this.loadCards();
  }

  loadCards(): void {
    this.cardService.getCardByColumn(this.columnId).subscribe((data) =>{
      this.cards = data;
    });
    
  }

  newCard: Card ={
    id: 0,
    title: "",
    description: "",
    createAt: "",
    blocked: false,
    columnId: 0

  }

  CreateCard(): void{
    this.cardService.createCard(this.columnId, this.newCard).subscribe((data) =>{
      console.log("Car criado", data);
      this.newCard = {
        id: 0,
        title: "",
        description: "",
        createAt: "",
        blocked: false,
        blockReason: "",
        columnId: 0
      };
      this.loadCards();
    });
  }

  goToColumns(): void {
    this.router.navigate(['/columns', this.columnId]);
  }

}
