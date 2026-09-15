import { TestBed } from '@angular/core/testing';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { RouterTestingHarness } from '@angular/router/testing';
import { App } from './app';
import { appConfig } from './app.config';

describe('Base da aplicação', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [App],
      providers: appConfig.providers,
    }).compileComponents();
  });

  it('cria o componente raiz', () => {
    expect(TestBed.createComponent(App).componentInstance).toBeTruthy();
  });

  it('disponibiliza o cliente HTTP', () => {
    expect(TestBed.inject(HttpClient)).toBeTruthy();
  });

  it('carrega a página inicial pela rota', async () => {
    const harness = await RouterTestingHarness.create('/');
    expect(harness.routeNativeElement?.querySelector('h1')?.textContent).toContain(
      'Clínica Escola',
    );
  });

  it('redireciona rotas desconhecidas para a página inicial', async () => {
    await RouterTestingHarness.create('/rota-inexistente');
    expect(TestBed.inject(Router).url).toBe('/');
  });
});
