import { ChangeDetectionStrategy, Component, input, output } from '@angular/core';

@Component({
  selector: 'app-botao',
  standalone: true,
  templateUrl: './botao.html',
  styleUrl: './botao.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
  host: { '[class.largura-total]': 'larguraTotal()' },
})
export class Botao {
  readonly rotulo = input.required<string>();
  readonly variante = input<'primario' | 'secundario'>('primario');
  readonly tipo = input<'button' | 'submit' | 'reset'>('button');
  readonly desabilitado = input(false);
  readonly larguraTotal = input(false);
  readonly acionado = output<void>();
}
