package JoiceAndersonTrabGA;

import java.util.Comparator;

public class porPontos implements Comparator<Piloto> { 
	@Override
	public int compare(Piloto piloto1, Piloto piloto2) {
		if(piloto1 == null) return 0;
		return piloto2.getPts() - piloto1.getPts(); //retorna valor negativo caso p1 tiver menos pontos
	}
}