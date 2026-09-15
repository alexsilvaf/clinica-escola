import { ChangeDetectionStrategy, Component, computed, input, output } from '@angular/core';
import { Horario, HorariosDoDia } from '../../models/horario.model';
import { formatarDataPorExtenso } from '../../utils/data.util';
import { HorarioCard } from '../horario-card/horario-card';

@Component({
  selector: 'app-horario-dia',
  standalone: true,
  imports: [HorarioCard],
  templateUrl: './horario-dia.html',
  styleUrl: './horario-dia.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class HorarioDia {
  readonly grupo = input.required<HorariosDoDia>();
  readonly selecionadoId = input<string | null>(null);
  readonly horarioSelecionado = output<Horario>();
  readonly titulo = computed(() => formatarDataPorExtenso(this.grupo().data));
  readonly tituloId = computed(() => `dia-${this.grupo().data}`);
}
