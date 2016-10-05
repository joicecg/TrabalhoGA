package JoiceAndersonTrabGA;

import java.util.Arrays;

public class Provas {
	private Piloto[] pilotos;

	public Provas(int qntdPilotos) {
		pilotos = new Piloto[qntdPilotos];
	}

	public void inserirPiloto(Piloto piloto) {
		for(int i = 0; i < pilotos.length; i++)
			if(pilotos[i] == null) {
				pilotos[i] = piloto;
				return;
			}
		System.err.println("Não há vagas no array!");
	}

	public void classificarPilotos() {
		Arrays.sort(pilotos);
	}
}