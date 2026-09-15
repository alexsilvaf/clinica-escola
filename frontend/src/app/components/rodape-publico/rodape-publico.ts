import { ChangeDetectionStrategy, Component, input } from '@angular/core';
import { Clinica } from '../../models/clinica.model';

@Component({
  selector: 'app-rodape-publico',
  standalone: true,
  templateUrl: './rodape-publico.html',
  styleUrl: './rodape-publico.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class RodapePublico {
  readonly clinica = input.required<Clinica>();
}
