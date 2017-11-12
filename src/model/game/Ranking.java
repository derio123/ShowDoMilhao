package model.game;

import java.util.List;

import model.sqlite.ParticipanteDAO;

public class Ranking extends ParticipanteDAO{
	public Ranking() {
		List<Participante> list = super.rankearJogadores();

		Participante[] top10 = new Participante[10];
		
		for(int i=0; i<list.size(); i++) {
			top10[i] = list.get(i);
		}
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
