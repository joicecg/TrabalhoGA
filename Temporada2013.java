package JoiceAndersonTrabGA;

import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Temporada2013 {
	protected Piloto[] pilotos;
	protected int last = 0;
	
	public void inserePilotosPont(Piloto p){		
		int pos = -1;
		for(int i = 0; i < last; i++)
			if(pilotos[i].getDriver() == p.getDriver()){
				pilotos[i].setPts(p.getPts());
				pos = i;
			}
			
		if(pos == -1 && p.getPts()!= 0){
			pilotos[last].setDriver(p.getDriver());
			pilotos[last].setTeam(p.getTeam());
			pilotos[last].setPts(p.getPts());
			last++;
		}
		
	}
	
	public void ordenaPorNome(){
		Arrays.sort(pilotos, new ClassificarNome());
		
	}
	
	public void ordenaPorPts(){
		Arrays.sort(pilotos, new ClassificarPontos());
	}
	
	
	public void registraArquivo(){
		File filename = new File("ClassificacaoTemporada2013.txt");
		try{
			FileWriter fw = new FileWriter(filename);
			PrintWriter out = new PrintWriter(fw);
			out.println("Fórmula 1" + "\nTemporada 2013\n Nome do pilto - Equipe - Pontuação");
			
			for(int i = 0; i < last; i++)
				out.println(pilotos[i].getDriver() + " - " + pilotos[i].getTeam() + " - " + pilotos[i].getPts()+"\n");
		
			out.close();
			
		}catch(IOException e){
			System.out.println("Erro ao gerar arquivo");
			e.printStackTrace();
		}
		
	
	}
	
		
}
	
	
		

