import { ChangeDetectionStrategy, Component, computed, input, output } from '@angular/core';
import { Horario } from '../../models/horario.model';
import { formatarDataLocal } from '../../utils/data.util';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-horario-card',
  standalone: true,
  templateUrl: './horario-card.html',
  styleUrl: './horario-card.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [RouterLink],
})
export class HorarioCard {
  readonly horario = input.required<Horario>();
  readonly selecionado = input(false);
  readonly horarioSelecionado = output<Horario>();
  readonly disponivel = computed(() => this.horario().disponivel && this.horario().vagas > 0);
  readonly detalhe = computed(() => {
    const horario = this.horario();
    return this.disponivel()
      ? `${horario.sala} · ${horario.vagas} ${horario.vagas === 1 ? 'vaga' : 'vagas'}`
      : (horario.motivoIndisponibilidade ?? 'Sem vaga');
  });
  readonly nomeAcessivel = computed(() => {
    const horario = this.horario();
    const contexto = `${formatarDataLocal(horario.data)} às ${horario.hora}, ${this.detalhe()}`;
    return this.disponivel()
      ? `Selecionar horário: ${contexto}`
      : `Horário indisponível: ${contexto}`;
  });

  selecionar(): void {
    if (this.disponivel()) {
      this.horarioSelecionado.emit(this.horario());
    }
  }
}
