import { Clinica } from '../../../models/clinica.model';

export const CLINICA_MOCK: Clinica = {
  nome: 'Clínica de Fisioterapia',
  servico: 'Fisioterapia · avaliação',
  duracaoMinutos: 45,
  endereco: 'Rua Exemplo, 100 · Centro',
  cidade: 'Guarapari/ES',
  acessibilidade: [
    'Entrada sem degraus e rampa de acesso',
    'Banheiro adaptado no térreo',
    'Vaga de estacionamento reservada',
    'Intérprete de Libras mediante solicitação prévia',
  ],
};
