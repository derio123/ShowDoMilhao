package model.sqlite;

import java.util.ArrayList;
import java.util.List;

import model.game.Participante;

public class Teste {

	public static void main(String[] args) {
		ParticipanteDAO db = new ParticipanteDAO();
		Participante jogador = new Participante();
		
		/*
		jogador.setNome("Gabriel");
		jogador.setPontos(16);
		
		db.adicionarParticipante(jogador);
		*/
		List<Participante> list = db.rankearJogadores();
		
		/*for(int i=0; i<list.size(); i++) {
			System.out.println("Partipantee: "+list.get(i).getNome()+" - "+list.get(i).getPontos());
		}*/
		
		Participante[] top10 = new Participante[10];
		
		for(int i=0; i<list.size(); i++) {
			top10[i] = list.get(i);
		}
		//top10[0] = 12;          
		//top10[1] = 7;
		//top10[2] = 7;
		//top10[3] = 3;
		//top10[4] = 2;

		Participante novo = new Participante();
		novo.setNome("Sena");
		novo.setPontos(4);
		
		int indexProx = 0;
		boolean isMaior = false;
		for(int i=list.size()-1; i>=0; i--) {
			if(novo.getPontos() > top10[i].getPontos()) {
				indexProx = i;
				isMaior = true;
			}
		}
		int size = list.size();
		if(isMaior) {
			Participante[] topLasts = new Participante[10-indexProx];
			
			for(int i=0; i<9-indexProx; i++) {
				topLasts[i] = top10[i+indexProx];
			}
			top10[indexProx] = novo; 
	
			int var = indexProx+1;
			for(int i=0; i<9-indexProx; i++) {
				top10[var] = topLasts[i];
				var++;
			}
			if(size <= 9) {
				size++;
			}
		}else if(size<=9){
			top10[size] = novo;
			size++;
		}
		for(int i=0; i<size; i++) {
			System.out.println(i+" Top 10 Pontos: "+top10[i].getNome()+" - "+top10[i].getPontos());
		}
	}
	
}


//Later: Apagar o bd e criar novos participantes.
//Não precisar usar algoritmo de ordenação de listas prontas.

/*
int[] top10 = new int[10];

top10[0] = 12;          
top10[1] = 7;
top10[2] = 7;
top10[3] = 3;
top10[4] = 2;
//top10[5] = 7;
//top10[6] = 4;
//top10[7] = 3;
//top10[8] = 2;
//top10[9] = 1;

int novo = 5;
int indexProx = 0;

for(int i=9; i>=0; i--) {
	if(novo > top10[i]) {
		indexProx = i;
	}
}
int[] topLasts = new int[10-indexProx];

for(int i=0; i<9-indexProx; i++) {
	topLasts[i] = top10[i+indexProx];
}
top10[indexProx] = novo; 

int var = indexProx+1;
for(int i=0; i<9-indexProx; i++) {
	top10[var] = topLasts[i];
	var++;
}
for(int i=0; i<10; i++) {
	System.out.println("Top 10 Pontos: "+top10[i]);
}*/