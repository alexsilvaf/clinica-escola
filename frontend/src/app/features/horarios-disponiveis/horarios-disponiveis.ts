import {
  ChangeDetectionStrategy,
  Component,
  DestroyRef,
  computed,
  inject,
  signal,
} from '@angular/core';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';

import { AcessibilidadeLocal } from '../../components/acessibilidade-local/acessibilidade-local';
import { Aviso } from '../../components/aviso/aviso';
import { Botao } from '../../components/botao/botao';
import { CabecalhoPublico } from '../../components/cabecalho-publico/cabecalho-publico';
import { EstadoConsulta } from '../../components/estado-consulta/estado-consulta';
import { EtapasAgendamento } from '../../components/etapas-agendamento/etapas-agendamento';
import { HorarioDia } from '../../components/horario-dia/horario-dia';
import { ResumoServico } from '../../components/resumo-servico/resumo-servico';
import { RodapePublico } from '../../components/rodape-publico/rodape-publico';

import { Horario, HorariosDoDia } from '../../models/horario.model';
import { formatarDataLocal } from '../../utils/data.util';
import { CLINICA_MOCK } from './mocks/clinica.mock';
import { HorariosService } from './services/horarios.service';

@Component({
  selector: 'app-horarios-disponiveis',
  standalone: true,
  imports: [
    AcessibilidadeLocal,
    Aviso,
    Botao,
    CabecalhoPublico,
    EstadoConsulta,
    EtapasAgendamento,
    HorarioDia,
    ResumoServico,
    RodapePublico,
  ],
  templateUrl: './horarios-disponiveis.html',
  styleUrl: './horarios-disponiveis.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class HorariosDisponiveis {
  private readonly horariosService = inject(HorariosService);
  private readonly destroyRef = inject(DestroyRef);

  readonly clinica = CLINICA_MOCK;

  readonly horarios = signal<readonly Horario[]>([]);
  readonly carregando = signal(false);
  readonly erro = signal<string | null>(null);
  readonly horarioSelecionado = signal<Horario | null>(null);

  readonly gruposHorarios = computed<readonly HorariosDoDia[]>(() => {
    const grupos = new Map<string, Horario[]>();

    for (const horario of this.horarios()) {
      const data = horario.inicio.split('T')[0];

      const horariosDoDia = grupos.get(data) ?? [];

      horariosDoDia.push(horario);
      grupos.set(data, horariosDoDia);
    }

    return Array.from(grupos, ([data, horarios]) => ({
      data,
      horarios: horarios.sort((primeiro, segundo) =>
        primeiro.inicio.localeCompare(segundo.inicio),
      ),
    })).sort((primeiro, segundo) =>
      primeiro.data.localeCompare(segundo.data),
    );
  });

  readonly resumoSelecao = computed(() => {
    const horario = this.horarioSelecionado();

    if (!horario) {
      return '';
    }

    const data = horario.inicio.split('T')[0];
    const hora = horario.inicio.split('T')[1].slice(0, 5);

    return `${formatarDataLocal(data)} às ${hora} · ${horario.local}`;
  });

  constructor() {
    this.carregarHorarios();
  }

  carregarHorarios(): void {
    if (this.carregando()) {
      return;
    }

    this.carregando.set(true);
    this.erro.set(null);
    this.horarioSelecionado.set(null);

    this.horariosService
      .listar()
      .pipe(takeUntilDestroyed(this.destroyRef))
      .subscribe({
        next: (horarios) => {
          this.horarios.set(horarios);
          this.carregando.set(false);
        },
        error: () => {
          this.horarios.set([]);
          this.erro.set(
            'Não foi possível consultar a lista. Tente novamente para recarregar os horários.',
          );
          this.carregando.set(false);
        },
      });
  }

  selecionarHorario(horario: Horario): void {
    if (horario.vagas > 0) {
      this.horarioSelecionado.set(horario);
    }
  }

  limparSelecao(): void {
    this.horarioSelecionado.set(null);
  }
}