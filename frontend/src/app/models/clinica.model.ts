export interface Clinica {
  readonly nome: string;
  readonly servico: string;
  readonly duracaoMinutos: number;
  readonly endereco: string;
  readonly cidade: string;
  readonly acessibilidade: readonly string[];
}
