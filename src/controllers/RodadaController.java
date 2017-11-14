package controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
import model.game.Dinheiro;
import model.game.Participante;
import model.game.Questionario;
import model.sqlite.Pergunta;

public class RodadaController extends Questionario{
	boolean termina = false;
	JogadorController jogadorX = null;
	Pergunta questao = null;
	int respostaJogador = 0;
	int pts = 0;
	
	@FXML
	private Label nomeJogador;
	@FXML
	private Label quadro;
	@FXML
	private Label numPergunta;
	@FXML
	private Button btnOpcao1;
	@FXML
	private Button btnOpcao2;
	@FXML
	private Button btnOpcao3;
	@FXML
	private Button btnOpcao4;
	@FXML
	private Label qtdPulo;
	@FXML
	private Label qtdUniv;
	@FXML
	private Label qtdCartas;
	
	public RodadaController () {
		jogadorX = new JogadorController();
	}
	@FXML
	protected void initialize() {
		Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
			
			@Override
			public void onScreenChanged(String newScreen, Object userData) {
				if(newScreen.equals("iniciarRodada")) {
					System.out.println("Entrou no onScreenChanged");
					if(userData != null) {
						Participante p = (Participante)userData;
						nomeJogador.setText(p.getNome());
					}
				}
			}
		});	
		this.iniciarRodada();
	}
	
	public void iniciarRodada() {	
		System.out.println("Começou o jogo");
		
		this.gerarNovaPergunta();	
		//Som=btnOpcao1.setOnMouseEntered(event -> btnOpcao1.setText("Botão 1"));
		//Som=btnOpcao1.setOnMouseExited(event -> btnOpcao1.setText(qm));
	}
	private void gerarNovaPergunta() {
		super.numPerg++;
		questao = super.gerarPergunta();
		quadro.setText(questao.getPergunta());
		numPergunta.setText(Integer.toString(super.numPerg));
		this.mostrarAlternativas(questao);
		this.escolherOpcao();
	}
	
	private void finalizarRodada() {
		System.out.println("Pontos: "+super.maleta.pontos);
		System.out.print("Você ganhou "+ super.maleta.verMaleta());
		jogadorX.novoParticipante((int)super.maleta.pontos);
	}
	
	@FXML
	public void mostrarAlternativas(Pergunta p) {
		btnOpcao1.setText(p.getNumero1());
		btnOpcao2.setText(p.getNumero2());
		btnOpcao3.setText(p.getNumero3());
		btnOpcao4.setText(p.getNumero4());
	}
	private void escolherOpcao() {
		btnOpcao1.setOnAction(event ->  this.setOpcaoEscolhida(1)); // COM LAMBDA
		btnOpcao2.setOnAction(event -> this.setOpcaoEscolhida(2));
		btnOpcao3.setOnAction(event -> this.setOpcaoEscolhida(3));
		btnOpcao4.setOnAction(event -> this.setOpcaoEscolhida(4));
	}
	
	private void setOpcaoEscolhida(int opcao) {
		this.respostaJogador = opcao;
		
		if(questao.getResposta() == respostaJogador) {
			System.out.println("Você Acertou!");
			super.maleta.analisarPontos(pts+1, true);						
			pts++;
			if(numPerg<16) {
				gerarNovaPergunta();
			}else {
				finalizarRodada();
			}
		}else {
			System.out.println("Você Errou! \n Fim de jogo");
			super.maleta.pontos = super.maleta.analisarPontos(super.numPerg, false);
			finalizarRodada();
		}
	}
	
	@FXML 
	protected void btnParar(ActionEvent e) {
		super.maleta.pontos = super.maleta.analisarPontos(super.numPerg - 1, true);
		Main.changeScreen("main");
	}
	@FXML
	protected void btnPular(ActionEvent e) {
		if(super.pularPergunta()) {
			gerarNovaPergunta();
			qtdPulo.setText(Integer.toString(pulo));
		}else {
			System.out.println("Os três pulos foram usados");
		}
	}
	@FXML
	protected void btnUniv(ActionEvent e) {
		
	}
	@FXML
	protected void btnCartas(ActionEvent e) {
		
	}
	/*
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
				//this.mostrarAlternativas(questao);
			}
			this.responder();
			break;
		}
	}*/
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
