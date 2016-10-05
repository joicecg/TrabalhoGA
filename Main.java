package JoiceAndersonTrabGA;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {	
	private static final int NUM_PILOTOS = 22;	
	private static final int NUM_PILOTOS_TEMP_2013 = 30;
	
	public static void main(String[] args) {
		try {
			File diretorioProvas = new File("Temporada2013");		
			File[] arquivosNaPasta = diretorioProvas.listFiles();
			if(arquivosNaPasta == null) {
				JOptionPane.showMessageDialog(null,
							      "Nenhum arquivo foi encontrado!",
							      "ERRO",
							      JOptionPane.ERROR_MESSAGE);
				return;
			}
			ArrayList<Provas> provas = new ArrayList<>(); //para salvar todas provas
			
			Temporada2013 temp2013 = new Temporada2013(NUM_PILOTOS_TEMP_2013);
			
			for(int i = 0; i < arquivosNaPasta.length; i++) {//percorre todos os arquivos na pasta Temporada2013
				provas.add(new Provas(NUM_PILOTOS));//para cada arquivo cria um objeto provas
				
				Piloto[] pilotosNoArquivo = leArquivo(arquivosNaPasta[i], temp2013);//le cada arquivo e devolve como array de pilotos				
				
				for(Piloto piloto : pilotosNoArquivo){//percorre cada piloto desse array
					provas.get(i).inserirPiloto(piloto);//coloca cada piloto do array nesse objeto provas criado agora
				}
			}
			
			 
			int op = escolha();
			switch(op){
				case 1:
					if(temp2013.pilotos != null)
						temp2013.ordenaPorNome();
					break;
					
				case 2:
					temp2013.ordenaPorPts();
			}
			
			temp2013.registraArquivo();
			
			apresentarCampeoes(temp2013);
		
		} catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, 
						     "Arquivo " + e.getMessage() + " nÃ£o encontrado!",
					             "ERRO",
						     JOptionPane.ERROR_MESSAGE);
						
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, 
						      "Um erro ocorreu!\n" + e.getMessage(),
						      "ERRO",
						      JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static Piloto[] leArquivo(File prova, Temporada2013 temp2013) throws IOException {
		Piloto[] pilotos = new Piloto[NUM_PILOTOS];
		int last = 0;
		
		BufferedReader in = new BufferedReader(new FileReader(prova));
		in.readLine(); //pula linha 1
		
		String[]result;		
		int pontos;		

		String line;
		
		while((line = in.readLine()) != null) {				
			result = line.split(";");
			pontos = Integer.parseInt(result[6]);
			Piloto p = new Piloto(result[0],result[1],result[2],result[3],result[4],result[5],pontos);
			pilotos[last++] = p;
			temp2013.inserePilotosPont(p); //dentro da classe Temporada2013 ele sÃ³ vai ser inserido se tem pts
		}
		
		in.close();	
		return pilotos;
	}
	
	public static int escolha() throws IOException{
		InputStream in = System.in;
		InputStreamReader is = new InputStreamReader (in);
		BufferedReader console = new BufferedReader (is);
		
		System.out.print ("Escolha o método para ordenar:\n (digite o número correspondente) \n (1) Por nome \n (2) Por pontos ");
		int op = Integer.parseInt(console.readLine());
		
		return op;
		
	}
	
	public static void apresentarCampeoes(Temporada2013 temp2013) {
		temp2013.ordenaPorPts();
		
		for(Piloto piloto : temp2013.getPilotosPontuados()) {
			if(piloto == null) return; //pois nao vai vir um array com 30 posicoes, entao havera nulls
			System.out.println("Nome: " + piloto.getDriver());
			System.out.println("Equipe: " + piloto.getTeam());
			System.out.println("Pontos: " + piloto.getPts() + "\n\n\n");
		}
			
	}
}
