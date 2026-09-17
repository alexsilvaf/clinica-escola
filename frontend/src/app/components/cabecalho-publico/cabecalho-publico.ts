import { ChangeDetectionStrategy, Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Botao } from '../botao/botao';

@Component({
  selector: 'app-cabecalho-publico',
  standalone: true,
  imports: [RouterLink, Botao],
  templateUrl: './cabecalho-publico.html',
  styleUrl: './cabecalho-publico.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CabecalhoPublico {}
