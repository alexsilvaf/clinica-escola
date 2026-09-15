import { ChangeDetectionStrategy, Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-cabecalho-publico',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './cabecalho-publico.html',
  styleUrl: './cabecalho-publico.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CabecalhoPublico {}
