import { Component, EventEmitter, input, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule],
  selector: 'app-input',
  styleUrl: './app-input.scss',
  templateUrl: './app-input.html',
})
export class AppInput {
  @Input() id: string = "";
  @Input() label: string = "";
  @Input() placeholder: string = "";
  @Input() tipo: 'text' | 'number' = 'text';

  @Input() value: string = "";
  @Output() valueChange = new EventEmitter<string>();

}
