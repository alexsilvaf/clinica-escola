import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule],
  selector: 'app-input-text',
  styleUrl: './input-text.scss',
  templateUrl: './input-text.html',
})
export class InputText {
  @Input() id: string = "";
  @Input() label: string = "";
  @Input() placeholder: string = "";

  @Input() value: string = "";
  @Output() valueChange = new EventEmitter<string>();

}
