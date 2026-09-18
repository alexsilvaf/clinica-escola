import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Horario } from '../../../models/horario.model';

@Injectable({ providedIn: 'root' })
export class HorariosService {

  constructor(private http: HttpClient) {}

  listar(): Observable<readonly Horario[]> {
    // A página consome o mesmo contrato assíncrono que utilizará com HttpClient.
    return this.http.get<readonly Horario[]>('/api/v1/horarios');
  }
}
