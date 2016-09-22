package AndersonDaSilvaCossulJoyceCazanoskiGomesTrabGA;

public class ClassificarPontos implements Comparator<Piloto> { 
	@Override
	public int compare(Piloto piloto1, Piloto piloto2) {
		return piloto1.getPts() - piloto2.getPts(); //retorna valor negativo caso p1 tiver menos pontos
	}
}
