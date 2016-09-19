package AndersonDaSilvaCossulJoyceCazanoskiGomesTrabGA;

public ClassificarNome implements Comparator {
	@Override
	public int compare(Object piloto1, Ojbect piloto2) {
		return piloto1.getNome().compareTo(piloto2.getNome());
	}
}
