package model.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.sqlite.ParticipanteDAO;
import model.sqlite.Pergunta;
import model.sqlite.PerguntasDAO;

public class Questionario {
	public int qtdPerguntas = 0;
	List<Integer>anteriores;
	public PerguntasDAO db = null;
	public int numPerg = 0;
	public int totalPerguntas = 0;
	public Pergunta perg = null;
	public Dinheiro maleta = null;
	protected int pulo;
	protected boolean cartas;
	protected boolean univ;
	
	public Questionario() {
		 db = new PerguntasDAO();
		 totalPerguntas = db.verificarTotal();
		 anteriores = new ArrayList<Integer>();
		 maleta = new Dinheiro();
		 cartas = true;
		 univ = true;
	}
	
	public Pergunta gerarPergunta() {
		
		Random sorteioId = new Random();
	
		while(true) {
			Integer id = sorteioId.nextInt(totalPerguntas)+1; // Gera um número que representa o id // 5 = quantidade de perguntas
			boolean unico = true;
			if(qtdPerguntas > 0) {
				for(int i = 0; i < anteriores.size(); i++) { // Percorrer todos os ids gerados na partida
					if(anteriores.get(i) == id) { // Se houver um número que seja igual ao id será gerado outro número
						unico = false;
					}
				}
			}if(unico) {
				/*
				if(numPerg <= 6) {
					
					if(numPerg == 6) {
						anteriores.clear();
					}
				}if(nivel == 2) {
					
				}if(nivel == 3)Wa {
					
				}
				*/
				perg = db.buscarId(id);
				anteriores.add(perg.getId());
				qtdPerguntas++;
				return perg;
			}
		}
		
	}
	public boolean pularPergunta() {
		if(pulo<3) {
			numPerg--;
			pulo++;
			return true;
		}
		return false;
	}
	public int[] pedirUniversitarios() {
		int[] choosed = new int[3];
		Random numAleat = new Random();
		
		int randomCerta = numAleat.nextInt(2); 
			
		choosed[randomCerta] = perg.getResposta();
		
		
		boolean termina = false;
		while(!termina) {
			int randomNum = numAleat.nextInt(2);
			int randomI = 0;
			
			if(randomNum != randomCerta) {
				int val1 = numAleat.nextInt(4)+1;
				choosed[randomNum] = val1; 
				randomI = randomNum;
				for(int iLast=0; iLast<=2;iLast++) {
					if(iLast != randomI && iLast != randomCerta) {
						while(true) {
							int val2 = numAleat.nextInt(4)+1;
							if(val1 == perg.getResposta() && val2 == val1) {
								choosed[iLast] = val2;
								break;
							}if(val1 != val2) {
								choosed[iLast] = val2;
								break;
							}
						}
						termina = true;
					}
				}
			}
		}
		univ = false;
		return choosed;
	}
	public Pergunta pedirCartas() {
		Random tiraNum = new Random();
	
		List<Integer> numsDeleted = new ArrayList<Integer>();
		
		Integer numAleatorio = tiraNum.nextInt(4);

		//System.out.print("NumAletório: "+numAleatorio);
		
		int numero = 1;
		while(numsDeleted.size() < numAleatorio) {
			if(numero != perg.getResposta()) {
				numsDeleted.add(numero);
			}
			numero++;
		}
		//System.out.print("sizeNumsDeleted > "+numsDeleted.size());
		
		for(int i=0; i<numsDeleted.size(); i++) {
			//System.out.println("Cartas>>>> "+ numsDeleted.get(i));
		}
		
		for(int i=0; i<numsDeleted.size(); i++) {
		if(numsDeleted.get(i) == 1) {
			perg.setNumero1("-----");
		}if(numsDeleted.get(i) == 2) {
			perg.setNumero2("-----");
		}if(numsDeleted.get(i) == 3) {
			perg.setNumero3("-----");
		}if(numsDeleted.get(i) == 4) {
			perg.setNumero4("-----");
		}
		}
		cartas = false;
		return perg;
	}
}
