import { ChangeDetectionStrategy, Component, input } from '@angular/core';

@Component({
  selector: 'app-acessibilidade-local',
  standalone: true,
  templateUrl: './acessibilidade-local.html',
  styleUrl: './acessibilidade-local.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AcessibilidadeLocal {
  readonly recursos = input.required<readonly string[]>();
}
