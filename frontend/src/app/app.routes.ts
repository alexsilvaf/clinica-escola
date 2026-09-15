import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    title: 'Horários disponíveis | Clínicas-Escola',
    loadComponent: () =>
      import('./features/horarios-disponiveis/horarios-disponiveis').then(
        (m) => m.HorariosDisponiveis,
      ),
  },
  { path: '**', redirectTo: '' },
];
