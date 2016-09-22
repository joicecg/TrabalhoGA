package JoiceAndersonTrabGA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {	
		
	public static void main(String[] args) {
		String f1= "Corridas-2013/AbuDhabi2013_17.csv";
		String f2= "Corridas-2013/Alemanha2013_9.csv";
		String f3= "Corridas-2013/Australia2013_1.csv";
									
		try{
			
			leArquivo(f1, new Provas(22), new Temporada2013(30));
						
			leArquivo(f2, new Provas(22), new Temporada2013(30));
			
			leArquivo(f3, new Provas(22), new Temporada2013(30));
		
		}catch(NumberFormatException e){
			e.printStackTrace();
			
		}catch(FileNotFoundException e){
			System.out.println("O arquivo não foi encontrado.");
						
		}catch(IOException e){
			System.out.println("Erro ao ler arquivo");
			e.printStackTrace();
		}
	}
	
	public static void leArquivo(String filename, Provas p, Temporada2013 t) throws IOException{
		 String[]result;		
		 Piloto piloto;
		 int pontos;
		 String line = "";		 

				
		FileReader fr = new FileReader(filename);
		BufferedReader in = new BufferedReader(fr);
		
		line = in.readLine();
		line = in.readLine();
					
		while(line!= null){				
			result = line.split(";");
			pontos = Integer.parseInt(result[6]);
			piloto = new Piloto(result[0],result[1],result[2],result[3],result[4],result[5],pontos);
			p.inserirPiloto(piloto);
			
			line = in.readLine();
		}
		for(int i = 0; i < p.last; i++)
			t.inserePilotosPont(p.pilotos[i]);
		
		in.close();
		
		
	}

}
