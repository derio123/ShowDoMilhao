package controllers;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.game.Participante;
import model.game.Ranking;

public class RankingController {
	Ranking position;
	@FXML
	protected TableView<Participante> tableVJogadores=null;
	
	@FXML
	protected void initialize() {
		Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
			@Override
			public void onScreenChanged(String newScreen, Object userData) {
					System.out.println("Entrou na tela de colocações");
			}
		});	
		this.mostrarPlacar();
	}
	
	public RankingController() {
		position = new Ranking();
	}
	public void verificarPlayer(Participante p) {
		position.adicionarJogador(p);
	}
	public void mostrarPlacar() {
		List<Participante> cts = position.listarRanking();
		tableVJogadores = new TableView<>();
		
		TableColumn<Participante, String>  colunaNome = new TableColumn<>("Nome");
        TableColumn<Participante, String> colunaPontos = new TableColumn<>("Pontos");
        
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaPontos.setCellValueFactory(new PropertyValueFactory<>("pontos"));
        
        tableVJogadores.setItems(FXCollections.observableArrayList(cts));
        tableVJogadores.getColumns().addAll(colunaPontos, colunaNome);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	}
}
