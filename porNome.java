package AndersonDaSilvaCossulJoyceCazanoskiGomesTrabGA;

import java.util.Comparator;

public class porNome implements Comparator<Piloto> {
	@Override
	public int compare(Piloto piloto1, Piloto piloto2) {
		return piloto1.getDriver().compareTo(piloto2.getDriver());
	}
}