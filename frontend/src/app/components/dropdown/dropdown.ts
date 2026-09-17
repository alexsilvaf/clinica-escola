import {
  Component,
  ElementRef,
  EventEmitter,
  HostListener,
  Injector,
  Input,
  Output,
  ViewChild,
  afterNextRender,
  inject,
} from '@angular/core';

export interface OpcaoDropdown {
  value: unknown;
  name: string;
}

@Component({
  selector: 'app-dropdown',
  styleUrl: './dropdown.scss',
  templateUrl: './dropdown.html',
})
export class Dropdown {
  @Input() id = '';
  @Input() label = '';
  /** Texto de apoio abaixo do campo. */
  @Input() description = '';
  /** Mostrado enquanto nada foi escolhido; aplica o estado Erro quando preenchido. */
  @Input() erro = '';
  @Input() desabilitado = false;
  @Input() placeholder = '';
  @Input() options: OpcaoDropdown[] = [];

  @Input() value: unknown = '';
  @Output() valueChange = new EventEmitter<unknown>();

  protected aberto = false;
  protected indiceAtivo = -1;

  @ViewChild('lista') private lista?: ElementRef<HTMLUListElement>;
  private readonly elemento: ElementRef<HTMLElement> = inject(ElementRef);
  private readonly injector = inject(Injector);
  private busca = '';
  private buscaEm = 0;

  protected get opcaoEscolhida(): OpcaoDropdown | undefined {
    return this.options.find((opcao) => opcao.value === this.value);
  }

  protected get textoDoValor(): string {
    return this.opcaoEscolhida?.name ?? this.placeholder;
  }

  protected get apoio(): string {
    return this.erro || this.description;
  }

  protected escolher(opcao: OpcaoDropdown): void {
    this.value = opcao.value;
    this.valueChange.emit(opcao.value);
    this.fechar();
    this.devolverFoco();
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

  /** Teclado do padrão combobox de seleção: abre, percorre, escolhe e fecha. */
  protected aoTeclar(evento: KeyboardEvent): void {
    if (this.desabilitado) {
      return;
    }
    const tecla = evento.key;

    if (!this.aberto) {
      if (tecla === 'ArrowDown' || tecla === 'ArrowUp' || tecla === 'Enter' || tecla === ' ') {
        evento.preventDefault();
        this.abrir();
        if (tecla === 'ArrowUp') {
          this.irPara(this.options.length - 1);
        }
      } else if (tecla.length === 1) {
        evento.preventDefault();
        this.abrir();
        this.procurarPorTexto(tecla);
      }
      return;
    }

    switch (tecla) {
      case 'ArrowDown':
        evento.preventDefault();
        this.irPara(this.indiceAtivo + 1);
        break;
      case 'ArrowUp':
        evento.preventDefault();
        this.irPara(this.indiceAtivo < 0 ? this.options.length - 1 : this.indiceAtivo - 1);
        break;
      case 'Home':
        evento.preventDefault();
        this.irPara(0);
        break;
      case 'End':
        evento.preventDefault();
        this.irPara(this.options.length - 1);
        break;
      case 'Enter':
      case ' ': {
        evento.preventDefault();
        const opcao = this.options[this.indiceAtivo];
        if (opcao) {
          this.escolher(opcao);
        } else {
          this.fechar();
        }
        break;
      }
      case 'Escape':
        evento.preventDefault();
        this.fechar();
        break;
      case 'Tab':
        this.fechar();
        break;
      default:
        if (tecla.length === 1) {
          evento.preventDefault();
          this.procurarPorTexto(tecla);
        }
    }
  }

  /** Fecha ao sair do componente pelo teclado. */
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

  protected ehEscolhida(opcao: OpcaoDropdown): boolean {
    return opcao.value === this.value;
  }

  protected abrir(): void {
    this.aberto = true;
    const escolhida = this.options.findIndex((opcao) => opcao.value === this.value);
    // Sem nada escolhido a lista abre sem realce, como no desenho; o realce começa pelo teclado.
    if (escolhida >= 0) {
      this.irPara(escolhida);
    } else {
      this.indiceAtivo = -1;
    }
  }

  protected fechar(): void {
    this.aberto = false;
    this.indiceAtivo = -1;
  }

  private irPara(indice: number): void {
    if (!this.options.length) {
      this.indiceAtivo = -1;
      return;
    }
    const total = this.options.length;
    this.indiceAtivo = ((indice % total) + total) % total;
    afterNextRender(
      () => {
        const ativa = this.lista?.nativeElement.children.item(this.indiceAtivo);
        ativa?.scrollIntoView({ block: 'nearest' });
      },
      { injector: this.injector },
    );
  }

  /** Digitar letras salta para a opção correspondente, como num select nativo. */
  private procurarPorTexto(tecla: string): void {
    const agora = Date.now();
    this.busca = agora - this.buscaEm > 700 ? tecla : this.busca + tecla;
    this.buscaEm = agora;
    const termo = this.busca.toLowerCase();
    const indice = this.options.findIndex((opcao) => opcao.name.toLowerCase().startsWith(termo));
    if (indice >= 0) {
      this.irPara(indice);
    }
  }

  private devolverFoco(): void {
    this.elemento.nativeElement.querySelector<HTMLButtonElement>('.campo__caixa')?.focus();
  }
}
