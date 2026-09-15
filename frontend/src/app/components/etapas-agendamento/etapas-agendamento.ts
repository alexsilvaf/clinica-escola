import { ChangeDetectionStrategy, Component, input } from '@angular/core';

@Component({
  selector: 'app-etapas-agendamento',
  standalone: true,
  templateUrl: './etapas-agendamento.html',
  styleUrl: './etapas-agendamento.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EtapasAgendamento {
  readonly etapaAtual = input<1 | 2 | 3>(1);
  readonly etapas = [
    { numero: 1, rotulo: 'Escolher horário' },
    { numero: 2, rotulo: 'Informar dados' },
    { numero: 3, rotulo: 'Comprovante' },
  ] as const;
}
