package AndersonDaSilvaCossulJoyceCazanoskiGomesTrabGA;

import java.util.Arrays;

import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Temporada2013 {
	private Piloto[] pilotos;
	
	public Temporada2013(int qntdPilotos) {
		pilotos = new Piloto[qntdPilotos];
	}
	
	public static boolean pilotoPontuou(Piloto p) {
		return p.getPts() > 0;
	}
	
	public void inserePilotosPont(Piloto p) {	
		if(pilotoPontuou(p) == false) return; //se nao pontuou, sai
		
		for(int i = 0; i < pilotos.length; i++) {
			if(pilotos[i] == null) { //se ainda não há piloto aqui, adiciona um new Piloto
					
				Piloto piloto = new Piloto();
				piloto.setDriver(p.getDriver());
				piloto.setTeam(p.getTeam());
				piloto.setPts(p.getPts());
				
				pilotos[i] = piloto;
				return;					
				
			} else if(pilotos[i].getDriver().equalsIgnoreCase(p.getDriver())) { //se ja tem e for o mesmo só atualiza e sai
				pilotos[i].setPts(p.getPts());
				return;
			}	
			//se ja tiver um outro piloto, nao faz nada
		}
	}			
	
	
	public void ordenaPorNome() {
		Arrays.sort(pilotos, new porNome());		
	}
	
	public void ordenaPorPts() {
		Arrays.sort(pilotos, new porPontos());
	}
	
	
	public void registraArquivo() {
		File fileName = new File("ClassificacaoTemporada2013.txt");		
		try {
			FileWriter fw = new FileWriter(fileName);
			PrintWriter out = new PrintWriter(fw);
			out.println("Fórmula 1" + "\nTemporada 2013\n Nome do pilto - Equipe - Pontuação\n");
			
			for(int i = 0; i < pilotos.length; i++) {
				if(pilotos[i] == null) {
					out.close();
					return;
				}
				out.println(pilotos[i].getDriver() + " - " + pilotos[i].getTeam() + " - " + pilotos[i].getPts());
			}
		
			out.close();
			
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, 
						     "Um erro ocorreu ao gerar o arquivo " + fileName + "!\n" +
						      e.getMessage(),
						      "ERRO",
						      JOptionPane.ERROR_MESSAGE);
		}	
	}	
	
	public Piloto[] getPilotosPontuados() {		
		return pilotos;
	}
}
