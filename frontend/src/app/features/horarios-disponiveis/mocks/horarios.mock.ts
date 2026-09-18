 /**
  * Gera datas futuras para que o exemplo não envelheça com o calendário.
  */

export function criarHorariosMock(
  referencia = new Date(),
) {

  const proximaData = (dias: number): string => {

    const data = new Date(
      referencia.getFullYear(),
      referencia.getMonth(),
      referencia.getDate() + dias,
    );

    const ano = data.getFullYear();
    const mes = String(data.getMonth() + 1).padStart(2, '0');
    const dia = String(data.getDate()).padStart(2, '0');

    return `${ano}-${mes}-${dia}`;
  };

  return [
    {
      id: 1,
      data: proximaData(1),
      hora: '08:00',
      sala: 'Sala 1',
      vagas: 1,
      disponivel: true,
    },
    {
      id: 2,
      data: proximaData(1),
      hora: '09:00',
      sala: 'Sala 1',
      vagas: 1,
      disponivel: true,
    },
    {
      id: 3,
      data: proximaData(1),
      hora: '10:00',
      sala: 'Sala 1',
      vagas: 0,
      disponivel: false,
      motivoIndisponibilidade: 'Sem vaga',
    },
    {
      id: 4,
      data: proximaData(1),
      hora: '11:00',
      sala: 'Sala 1',
      vagas: 1,
      disponivel: true,
    },
    {
      id: 5,
      data: proximaData(2),
      hora: '08:00',
      sala: 'Sala 1',
      vagas: 1,
      disponivel: true,
    },
    {
      id: 6,
      data: proximaData(2),
      hora: '09:00',
      sala: 'Sala 1',
      vagas: 1,
      disponivel: true,
    },
    {
      id: 7,
      data: proximaData(2),
      hora: '10:00',
      sala: 'Sala 1',
      vagas: 0,
      disponivel: false,
      motivoIndisponibilidade: 'Sem supervisão',
    },
    {
      id: 8,
      data: proximaData(2),
      hora: '11:00',
      sala: 'Sala 1',
      vagas: 1,
      disponivel: true,
    },
    {
      id: 9,
      data: proximaData(3),
      hora: '08:00',
      sala: 'Sala 1',
      vagas: 0,
      disponivel: false,
      motivoIndisponibilidade: 'Sala em manutenção',
    },
    {
      id: 10,
      data: proximaData(3),
      hora: '09:00',
      sala: 'Sala 1',
      vagas: 1,
      disponivel: true,
    },
    {
      id: 11,
      data: proximaData(3),
      hora: '10:00',
      sala: 'Sala 1',
      vagas: 1,
      disponivel: true,
    },
    {
      id: 12,
      data: proximaData(3),
      hora: '11:00',
      sala: 'Sala 1',
      vagas: 0,
      disponivel: false,
      motivoIndisponibilidade: 'Sem vaga',
    },
  ];
}