package controllers;

import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.game.Dinheiro;
import model.game.Questionario;
import model.sqlite.Pergunta;

public class RodadaController extends Questionario{
	JogadorController jogadorX = null;
	Pergunta questao = null;
	Scanner entry = null;
	int pts = 0;

	public RodadaController () {
		jogadorX = new JogadorController();
		entry = new Scanner(System.in);
	}
	
	@FXML
	protected void btnTeste(ActionEvent e) {
		//Main.changeScreen("inserir");
		iniciarRodada();
	}
	public void iniciarRodada() {	
		jogadorX.escreverNome(entry);
		boolean termina = false;
		while(!termina) {
			System.out.println("Jogador: "+jogadorX.nome);
			super.numPerg++;
			questao = super.gerarPergunta();
		
			System.out.println("Questão: "+super.numPerg);
			this.mostrarAlternativas(questao);		
			System.out.println(" ------------------------------------------------------------------------");
			System.out.println("|"+verPossibilidades());
			System.out.println(" ------------------------------------------------------------------------");
			while(true) {
				System.out.println("r. Responder");
				System.out.println("a. Ajuda");
				System.out.println("p. Parar");
				System.out.println("Escolha uma opção: ");
				String opcao = entry.next();
		
				if(opcao.equals("r")){
					termina = this.responder();
					break;
				}else if(opcao.equals("a")) {
					this.pedirAjuda();
					break;
					
				}else if(opcao.equals("p")){
					termina = this.parar();
					break;
				}else {
					System.out.print("Sintaxe Incorreta!");
				}
			}
			if(super.numPerg == 16) {
				termina = true;
			}
		}
		System.out.println("Pontos: "+super.maleta.pontos);
		System.out.print("Você ganhou "+ super.maleta.verMaleta());
		//jogadorX.verificarPontos(super.maleta.pontos);
	}
	public void mostrarAlternativas(Pergunta p) {
		System.out.println("Pergunta: "+p.getPergunta());
		System.out.println("1."+p.getNumero1());
		System.out.println("2."+p.getNumero2());
		System.out.println("3."+p.getNumero3());
		System.out.println("4."+p.getNumero4());
		System.out.println("");
	}
	public boolean responder() {
		int resposta = questao.getResposta();
		System.out.println("Escolha o número da alternativa");
		System.out.print("Escolha uma opção: ");
		int escolhida = entry.nextInt();
		
		if(resposta == escolhida) {
			System.out.println("Você Acertou!");
			super.maleta.analisarPontos(pts+1, true);						
			pts++;
		}else {
			System.out.println("Você Errou! \n Fim de jogo");
			super.maleta.pontos = super.maleta.analisarPontos(super.numPerg, false);
			return true;
		}
		return false;
	}
	public boolean parar() {
		super.maleta.pontos = super.maleta.analisarPontos(super.numPerg - 1, true);
		return true;
	}
	public void pedirAjuda() {
		System.out.println("1. Pular");
		System.out.println("2. Universitários");
		System.out.println("3. Cartas");
		int option = entry.nextInt();
		
		switch(option) {
		case 1: 
			if(!super.pularPergunta()) {
				System.out.println("Os três pulos foram usados");
				this.responder();
			}
			break;
		case 2:
			//new UnController(super);
			if(super.univ) {
			int[] univ = super.pedirUniversitarios();
			
			System.out.println("Universitários");
			System.out.println("Universitário 1 aposta na alternativa "+univ[0]);
			System.out.println("Universitário 2 aposta na alternativa "+univ[1]);
			System.out.println("Universitário 3 aposta na alternativa "+univ[2]);
			}else {
				System.out.println("A consulta dos universitários foi esgotada!");
			}
			this.responder();
			break;
		case 3:
			if(super.cartas) {
				System.out.println("Escolha uma carta");
				System.out.println("1.Carta A");
				System.out.println("2.Carta B");
				System.out.println("3.Carta C");
				System.out.println("4.Carta D");
				
				Pergunta questao = super.pedirCartas();
				this.mostrarAlternativas(questao);
			}
			this.responder();
			break;
		}
	}
	public String verPossibilidades(){
		String painel = null; 
		
		Dinheiro malaPoss = new Dinheiro();
		
		malaPoss.pontos = malaPoss.analisarPontos(pts + 1, true);
		painel = "Acertar: "+malaPoss.verMaleta();
		
		malaPoss.pontos = pts; 
		malaPoss.pontos = malaPoss.analisarPontos(pts, true);
		painel = painel+" - Parar: "+malaPoss.verMaleta();
		
		malaPoss.pontos = pts;
		malaPoss.pontos = malaPoss.analisarPontos(pts+1, false);
		painel = painel+" - Errar: "+malaPoss.verMaleta();
		
		return painel;
	}
}
