import { Component, Input } from '@angular/core';

@Component({
  imports: [],
  selector: 'app-service-card',
  styleUrl: './service-card.scss',
  templateUrl: './service-card.html',
})
export class ServiceCard {
  @Input() title: string;
  @Input() subtitle: string;
  @Input() content: string;
  @Input() timeLabel: string;
}
