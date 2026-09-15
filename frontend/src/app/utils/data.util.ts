/** Datas YYYY-MM-DD representam o calendário local, sem conversão para UTC. */
export function formatarDataLocal(
  data: string,
  opcoes: Intl.DateTimeFormatOptions = {
    day: '2-digit',
    month: '2-digit',
    year: 'numeric',
  },
): string {
  const [ano, mes, dia] = data.split('-').map(Number);
  const dataLocal = new Date(ano, mes - 1, dia);

  return new Intl.DateTimeFormat('pt-BR', opcoes).format(dataLocal);
}

export function formatarDataPorExtenso(data: string): string {
  const texto = formatarDataLocal(data, {
    weekday: 'long',
    day: 'numeric',
    month: 'long',
  });

  return texto.charAt(0).toLocaleUpperCase('pt-BR') + texto.slice(1);
}
