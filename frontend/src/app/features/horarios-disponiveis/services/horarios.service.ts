import { inject, Injectable } from '@angular/core';
import { Observable, defer, delay, of } from 'rxjs';
import { Horario } from '../../../models/horario.model';
import { criarHorariosMock } from '../mocks/horarios.mock';
import { HttpClient } from '@angular/common/http';

const consultaAPI = '/api/v1/';

@Injectable({ providedIn: 'root' })
export class HorariosService {
  private http = inject(HttpClient);

  listar(): Observable<readonly Horario[]> {
    // A página consome o mesmo contrato assíncrono que utilizará com HttpClient.
    return defer(() => of(criarHorariosMock())).pipe(delay(300));
  }

  pegarHorarios(): Observable<readonly Horario[]> {
    return defer(() => this.http.get<Horario[]>(consultaAPI + 'horarios'));
  }
}
