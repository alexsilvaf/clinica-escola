export interface Horario {
  readonly id: number;
  readonly servico: string;
  readonly local: string;
  readonly inicio: string;
  readonly fim: string;
  readonly vagas: number;
}

export interface HorariosDoDia {
  readonly data: string;
  readonly horarios: readonly Horario[];
}