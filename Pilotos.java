package AndersonDaSilvaCossulJoyceCazanoskiGomesTrabGA;

public class Provas {
	private Piloto[] pilotos;

	public Provas(int tamanho) {
		pilotos = new Piloto[tamanho];
	}

	public void inserirPiloto(Piloto piloto) {
		for(int i = 0; i < pilotos.length; i++)
			if(pilotos[i] == null) {
				pilotos[i] = piloto;
				return;
			}
		System.out.println("Não há vagas no array!");
	}

	public void classificarPilotos() {
		Arrays.sort(pilotos);
	}
}
