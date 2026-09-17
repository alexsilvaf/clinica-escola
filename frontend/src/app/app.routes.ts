import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    title: 'Horários disponíveis | Clínica-Escola',
    loadComponent: () =>
      import('./features/inicio/inicio').then(
        (m) => m.Inicio,
      ),
  },
  {
    path: 'horarios-disponiveis',
    pathMatch: 'full',
    title: 'Horários disponíveis | Clínica-Escola',
    loadComponent: () =>
      import('./features/horarios-disponiveis/horarios-disponiveis').then(
        (m) => m.HorariosDisponiveis,
      ),
  },
  { path: '**', redirectTo: '' },
];
