package AndersonDaSilvaCossulJoyceCazanoskiGomesTrabGA;

public class ClassificarPontos implements Comparator{
	@Override
	public int compare(Object piloto1, Object piloto2) {
		return ((Piloto)piloto1).getPontos() - ((Piloto)piloto2).getPontos(); //retorna valor negativo caso p1 tiver menos pontos
	}
}