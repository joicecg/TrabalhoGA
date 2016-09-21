package AndersonDaSilvaCossulJoyceCazanoskiGomesTrabGA;

public class ClassificarNome implements Comparator {
	@Override
	public int compare(Object piloto1, Object piloto2) {
		return ((Piloto)piloto1).getNome().compareTo(((Piloto)piloto2).getNome());
	}
}
