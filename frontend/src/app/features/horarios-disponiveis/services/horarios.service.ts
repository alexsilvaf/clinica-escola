import { Injectable } from '@angular/core';
import { Observable, defer, delay, of } from 'rxjs';
import { Horario } from '../../../models/horario.model';
import { criarHorariosMock } from '../mocks/horarios.mock';

@Injectable({ providedIn: 'root' })
export class HorariosService {
  listar(): Observable<readonly Horario[]> {
    // A página consome o mesmo contrato assíncrono que utilizará com HttpClient.
    return defer(() => of(criarHorariosMock())).pipe(delay(300));
  }
}
