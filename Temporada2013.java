package JoiceAndersonTrabGA;

import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Temporada2013 {
	protected Piloto[] pilotos;
	protected int last = 0;
	
	public static boolean pilotoPontuou(Piloto p){
		if(p.getPts() == 0)
			return false;
		return true;
	}
	
	public void inserePilotosPont(Piloto p){	
		if(p!=null && pilotoPontuou(p)==true){
			for(int i = 0; i < last; i++)
				if(pilotos[i].getDriver() == p.getDriver())
					pilotos[i].setPts(p.getPts());
				
				else{
					pilotos[last].setDriver(p.getDriver());
					pilotos[last].setTeam(p.getTeam());
					pilotos[last].setPts(p.getPts());
					last++;
			}
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
	
	
		

