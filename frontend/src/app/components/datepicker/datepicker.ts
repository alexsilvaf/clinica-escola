import {
  Component,
  ElementRef,
  EventEmitter,
  HostListener,
  Injector,
  Input,
  Output,
  afterNextRender,
  inject,
} from '@angular/core';
import { formatarDataLocal } from '../../utils/data.util';

interface DiaCalendario {
  iso: string;
  numero: number;
  doMes: boolean;
  hoje: boolean;
  escolhido: boolean;
  bloqueado: boolean;
  descricao: string;
}

/**
 * Campo de data com calendário próprio: mesma anatomia do Campo do design system
 * (rótulo, caixa de 40 px e texto de apoio) com um painel igual ao da Lista de opções.
 * Datas entram e saem como AAAA-MM-DD, o formato usado no resto do projeto.
 */
@Component({
  selector: 'app-datepicker',
  styleUrl: './datepicker.scss',
  templateUrl: './datepicker.html',
})
export class Datepicker {
  @Input() id = '';
  @Input() label = '';
  @Input() description = '';
  @Input() erro = '';
  @Input() desabilitado = false;
  @Input() placeholder = 'dd/mm/aaaa';
  /** Limites do período aceito, em AAAA-MM-DD. */
  @Input() min = '';
  @Input() max = '';

  @Input() set value(iso: string) {
    this.escolhida = iso ?? '';
    this.texto = this.escolhida ? formatarDataLocal(this.escolhida) : '';
    this.erroDigitacao = '';
  }
  get value(): string {
    return this.escolhida;
  }
  @Output() valueChange = new EventEmitter<string>();

  protected aberto = false;
  protected texto = '';
  protected erroDigitacao = '';
  protected diaFocado = '';
  protected mesVisivel = this.primeiroDiaDoMes(new Date());

  /** Domingo a sábado, a partir de uma semana conhecida. */
  protected readonly diasDaSemana = Array.from({ length: 7 }, (_, indice) => {
    const data = new Date(2024, 0, 7 + indice);
    return {
      curto: new Intl.DateTimeFormat('pt-BR', { weekday: 'short' }).format(data).replace('.', ''),
      completo: new Intl.DateTimeFormat('pt-BR', { weekday: 'long' }).format(data),
    };
  });

  private escolhida = '';
  private readonly hoje = this.paraIso(new Date());
  private readonly elemento: ElementRef<HTMLElement> = inject(ElementRef);
  private readonly injector = inject(Injector);
  private chaveDoCache = '';
  private semanasEmCache: DiaCalendario[][] = [];

  protected get temErro(): boolean {
    return Boolean(this.erro || this.erroDigitacao);
  }

  protected get apoio(): string {
    return this.erro || this.erroDigitacao || this.description;
  }

  protected get titulo(): string {
    const texto = new Intl.DateTimeFormat('pt-BR', { month: 'long', year: 'numeric' }).format(
      this.mesVisivel,
    );
    return texto.charAt(0).toLocaleUpperCase('pt-BR') + texto.slice(1);
  }

  protected get hojeBloqueado(): boolean {
    return this.foraDoPeriodo(this.hoje);
  }

  protected get semanas(): DiaCalendario[][] {
    const chave = [this.paraIso(this.mesVisivel), this.escolhida, this.min, this.max].join('|');
    if (chave !== this.chaveDoCache) {
      this.semanasEmCache = this.montarSemanas();
      this.chaveDoCache = chave;
    }
    return this.semanasEmCache;
  }

  protected alternar(): void {
    if (this.desabilitado) {
      return;
    }
    if (this.aberto) {
      this.fechar();
    } else {
      this.abrir();
    }
  }

  protected abrir(): void {
    if (this.desabilitado) {
      return;
    }
    this.aberto = true;
    const partida = this.escolhida || this.limitar(this.hoje);
    this.diaFocado = partida;
    this.mesVisivel = this.primeiroDiaDoMes(this.deIso(partida));
    this.focarDia();
  }

  protected fechar(devolverFoco = false): void {
    if (!this.aberto) {
      return;
    }
    this.aberto = false;
    if (devolverFoco) {
      this.elemento.nativeElement.querySelector<HTMLInputElement>('.campo__entrada')?.focus();
    }
  }

  protected escolherDia(dia: DiaCalendario): void {
    if (dia.bloqueado) {
      return;
    }
    this.erroDigitacao = '';
    this.definir(dia.iso);
    this.fechar(true);
  }

  protected irParaHoje(): void {
    if (this.hojeBloqueado) {
      return;
    }
    this.erroDigitacao = '';
    this.definir(this.hoje);
    this.fechar(true);
  }

  protected mudarMes(passo: number): void {
    const alvo = new Date(this.mesVisivel.getFullYear(), this.mesVisivel.getMonth() + passo, 1);
    this.mesVisivel = alvo;
    const diaAtual = this.diaFocado ? this.deIso(this.diaFocado).getDate() : 1;
    const ultimoDia = new Date(alvo.getFullYear(), alvo.getMonth() + 1, 0).getDate();
    this.diaFocado = this.paraIso(
      new Date(alvo.getFullYear(), alvo.getMonth(), Math.min(diaAtual, ultimoDia)),
    );
    this.focarDia();
  }

  /** Máscara dd/mm/aaaa enquanto se digita. */
  protected aoDigitar(evento: Event): void {
    const campo = evento.target as HTMLInputElement;
    const digitos = campo.value.replace(/\D/g, '').slice(0, 8);
    const partes = [digitos.slice(0, 2), digitos.slice(2, 4), digitos.slice(4, 8)].filter(
      (parte) => parte.length,
    );
    this.texto = partes.join('/');
    campo.value = this.texto;
    this.erroDigitacao = '';
  }

  protected confirmarTexto(): void {
    const texto = this.texto.trim();
    if (!texto) {
      this.erroDigitacao = '';
      this.definir('');
      return;
    }

    const partes = /^(\d{2})\/(\d{2})\/(\d{4})$/.exec(texto);
    if (!partes) {
      this.erroDigitacao = 'Use o formato dd/mm/aaaa.';
      return;
    }

    const dia = Number(partes[1]);
    const mes = Number(partes[2]);
    const ano = Number(partes[3]);
    const data = new Date(ano, mes - 1, dia);
    const existe =
      data.getFullYear() === ano && data.getMonth() === mes - 1 && data.getDate() === dia;
    if (!existe) {
      this.erroDigitacao = 'Essa data não existe no calendário.';
      return;
    }

    const iso = this.paraIso(data);
    if (this.foraDoPeriodo(iso)) {
      this.erroDigitacao = this.mensagemDoPeriodo();
      return;
    }

    this.erroDigitacao = '';
    this.definir(iso);
    this.mesVisivel = this.primeiroDiaDoMes(data);
    this.diaFocado = iso;
  }

  protected aoTeclarNoCampo(evento: KeyboardEvent): void {
    if (evento.key === 'ArrowDown' || (evento.altKey && evento.key === 'ArrowDown')) {
      evento.preventDefault();
      this.abrir();
      return;
    }
    if (evento.key === 'Enter') {
      evento.preventDefault();
      this.confirmarTexto();
      return;
    }
    if (evento.key === 'Escape' && this.aberto) {
      evento.preventDefault();
      this.fechar();
    }
  }

  protected aoTeclarNaGrade(evento: KeyboardEvent): void {
    const passos: Record<string, number> = {
      ArrowLeft: -1,
      ArrowRight: 1,
      ArrowUp: -7,
      ArrowDown: 7,
    };
    const passo = passos[evento.key];
    if (passo !== undefined) {
      evento.preventDefault();
      this.moverFoco(passo);
      return;
    }

    switch (evento.key) {
      case 'Home':
        evento.preventDefault();
        this.moverFoco(-this.deIso(this.diaFocado).getDay());
        break;
      case 'End':
        evento.preventDefault();
        this.moverFoco(6 - this.deIso(this.diaFocado).getDay());
        break;
      case 'PageUp':
        evento.preventDefault();
        this.mudarMes(evento.shiftKey ? -12 : -1);
        break;
      case 'PageDown':
        evento.preventDefault();
        this.mudarMes(evento.shiftKey ? 12 : 1);
        break;
      case 'Escape':
        evento.preventDefault();
        this.fechar(true);
        break;
    }
  }

  protected aoSairDoFoco(evento: FocusEvent): void {
    const destino = evento.relatedTarget as Node | null;
    if (!destino || !this.elemento.nativeElement.contains(destino)) {
      this.fechar();
    }
  }

  @HostListener('document:pointerdown', ['$event'])
  protected aoApontarFora(evento: PointerEvent): void {
    if (this.aberto && !this.elemento.nativeElement.contains(evento.target as Node)) {
      this.fechar();
    }
  }

  private definir(iso: string): void {
    this.escolhida = iso;
    this.texto = iso ? formatarDataLocal(iso) : '';
    this.valueChange.emit(iso);
  }

  private moverFoco(dias: number): void {
    const data = this.deIso(this.diaFocado);
    const alvo = new Date(data.getFullYear(), data.getMonth(), data.getDate() + dias);
    this.diaFocado = this.paraIso(alvo);
    if (
      alvo.getMonth() !== this.mesVisivel.getMonth() ||
      alvo.getFullYear() !== this.mesVisivel.getFullYear()
    ) {
      this.mesVisivel = this.primeiroDiaDoMes(alvo);
    }
    this.focarDia();
  }

  /** O painel só existe depois da renderização, por isso o foco espera por ela. */
  private focarDia(): void {
    afterNextRender(
      () => {
        const painel = this.elemento.nativeElement.querySelector<HTMLElement>('.calendario');
        if (painel && painel.getBoundingClientRect().right > window.innerWidth - 8) {
          // Campo perto da borda: o painel passa a se alinhar pela direita.
          painel.style.left = 'auto';
          painel.style.right = '0';
        }
        this.elemento.nativeElement
          .querySelector<HTMLButtonElement>('.calendario__dia--focado')
          ?.focus();
      },
      { injector: this.injector },
    );
  }

  private montarSemanas(): DiaCalendario[][] {
    const primeiro = this.mesVisivel;
    const inicio = new Date(primeiro.getFullYear(), primeiro.getMonth(), 1 - primeiro.getDay());
    const semanas: DiaCalendario[][] = [];

    for (let semana = 0; semana < 6; semana++) {
      const dias: DiaCalendario[] = [];
      for (let dia = 0; dia < 7; dia++) {
        const data = new Date(
          inicio.getFullYear(),
          inicio.getMonth(),
          inicio.getDate() + semana * 7 + dia,
        );
        const iso = this.paraIso(data);
        dias.push({
          iso,
          numero: data.getDate(),
          doMes: data.getMonth() === primeiro.getMonth(),
          hoje: iso === this.hoje,
          escolhido: iso === this.escolhida,
          bloqueado: this.foraDoPeriodo(iso),
          descricao: formatarDataLocal(iso, {
            weekday: 'long',
            day: 'numeric',
            month: 'long',
            year: 'numeric',
          }),
        });
      }
      semanas.push(dias);
    }

    return semanas;
  }

  private foraDoPeriodo(iso: string): boolean {
    return Boolean((this.min && iso < this.min) || (this.max && iso > this.max));
  }

  private limitar(iso: string): string {
    if (this.min && iso < this.min) {
      return this.min;
    }
    if (this.max && iso > this.max) {
      return this.max;
    }
    return iso;
  }

  private mensagemDoPeriodo(): string {
    if (this.min && this.max) {
      return `Escolha uma data entre ${formatarDataLocal(this.min)} e ${formatarDataLocal(this.max)}.`;
    }
    if (this.min) {
      return `Escolha uma data a partir de ${formatarDataLocal(this.min)}.`;
    }
    return `Escolha uma data até ${formatarDataLocal(this.max)}.`;
  }

  private primeiroDiaDoMes(data: Date): Date {
    return new Date(data.getFullYear(), data.getMonth(), 1);
  }

  private paraIso(data: Date): string {
    const mes = `${data.getMonth() + 1}`.padStart(2, '0');
    const dia = `${data.getDate()}`.padStart(2, '0');
    return `${data.getFullYear()}-${mes}-${dia}`;
  }

  private deIso(iso: string): Date {
    const [ano, mes, dia] = iso.split('-').map(Number);
    return new Date(ano, mes - 1, dia);
  }
}
