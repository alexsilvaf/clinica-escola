import { ChangeDetectionStrategy, Component, input } from '@angular/core';

@Component({
  selector: 'app-aviso',
  standalone: true,
  templateUrl: './aviso.html',
  styleUrl: './aviso.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class Aviso {
  readonly titulo = input.required<string>();
  readonly descricao = input.required<string>();
  readonly tipo = input<'informacao' | 'erro'>('informacao');
}
