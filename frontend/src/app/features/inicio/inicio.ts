import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CabecalhoPublico } from '../../components/cabecalho-publico/cabecalho-publico';
import { Dropdown, OpcaoDropdown } from '../../components/dropdown/dropdown';

@Component({
  imports: [CabecalhoPublico, FormsModule, Dropdown],
  selector: 'app-inicio',
  styleUrl: './inicio.scss',
  templateUrl: './inicio.html',
})
export class Inicio {
  texto = "";
  value = "";

  // Dados de demonstração, no lugar do catálogo que virá da API.
  readonly servicos: OpcaoDropdown[] = [
    { value: 'fisioterapia-avaliacao', name: 'Fisioterapia · avaliação' },
    { value: 'psicologia-acolhimento', name: 'Psicologia · acolhimento' },
    { value: 'odontologia-avaliacao', name: 'Odontologia · avaliação' },
    { value: 'nutricao-avaliacao', name: 'Nutrição · avaliação' },
  ];

  readonly clinicas: OpcaoDropdown[] = [
    { value: 'fisioterapia-centro', name: 'Clínica de Fisioterapia · Centro' },
    { value: 'psicologia-centro', name: 'Clínica-Escola de Psicologia · Centro' },
    { value: 'odontologia-centro', name: 'Clínica Odontológica · Centro' },
    { value: 'nutricao-centro', name: 'Ambulatório de Nutrição · Centro' },
  ];

  servico: unknown = '';
  clinica: unknown = '';
}
