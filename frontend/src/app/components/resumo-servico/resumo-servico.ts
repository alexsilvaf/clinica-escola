import { ChangeDetectionStrategy, Component, input } from '@angular/core';
import { Clinica } from '../../models/clinica.model';

@Component({
  selector: 'app-resumo-servico',
  standalone: true,
  templateUrl: './resumo-servico.html',
  styleUrl: './resumo-servico.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ResumoServico {
  readonly clinica = input.required<Clinica>();
}
