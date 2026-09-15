import { ChangeDetectionStrategy, Component, input, output } from '@angular/core';
import { Aviso } from '../aviso/aviso';
import { Botao } from '../botao/botao';

@Component({
  selector: 'app-estado-consulta',
  standalone: true,
  imports: [Aviso, Botao],
  templateUrl: './estado-consulta.html',
  styleUrl: './estado-consulta.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EstadoConsulta {
  readonly estado = input.required<'carregando' | 'vazio' | 'erro'>();
  readonly mensagemErro = input('Não foi possível carregar os horários. Tente novamente.');
  readonly tentarNovamente = output<void>();
  readonly linhasEsqueleto = [1, 2, 3];
}
