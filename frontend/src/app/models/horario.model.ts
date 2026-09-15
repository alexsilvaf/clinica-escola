export interface Horario {
  readonly id: string;
  readonly data: string;
  readonly hora: string;
  readonly sala: string;
  readonly vagas: number;
  readonly disponivel: boolean;
  readonly motivoIndisponibilidade?: string;
}

export interface HorariosDoDia {
  readonly data: string;
  readonly horarios: readonly Horario[];
}
