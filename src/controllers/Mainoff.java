package controllers;

import java.util.ArrayList;
import java.util.Scanner;

//import controller.Main.OnChangeScreen;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.sqlite.Pergunta;

public class Mainoff extends Application {
	private static Stage stage;
	private static Scene mainScene;
	private static Scene rodadaScene;
	private static Scene rankingScene;
	private static Scene editionScene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		primaryStage.setTitle("Show do Milhão");
		
		//Parent fxmlMain = FXMLLoader.load(getClass().getResource("../view/main_screen.fxml"));	
		//mainScene = new Scene(fxmlMain, 800, 400);
		Parent fxmlMain = FXMLLoader.load(getClass().getResource("../view/main_screen.fxml"));	
		mainScene = new Scene(fxmlMain, 600, 385);
		
		Parent fxmlRodada = FXMLLoader.load(getClass().getResource("../view/rodada_screen.fxml"));
		rodadaScene = new Scene(fxmlRodada, 600, 385);
		
		Parent fxmlRanking = FXMLLoader.load(getClass().getResource("../view/placar_screen.fxml"));
		rankingScene = new Scene(fxmlRanking, 600, 385);
		
		Parent fxmlEdition = FXMLLoader.load(getClass().getResource("../view/edition_screen.fxml"));
		editionScene = new Scene(fxmlEdition, 600, 385);
		
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}public static void changeScreen(String tela){
		switch(tela) {
		case "main":
			stage.setScene(mainScene);
			break;
		case "iniciarRodada":
			stage.setScene(rodadaScene);
			break;
		case "ranking":
			stage.setScene(rankingScene);
			break;
		case "editarPergunta":
			stage.setScene(editionScene);
			break;
		}
	}
	public static void main(String[] args) {
		launch(args);
		//RodadaController partida = new RodadaController();
		
		//partida.iniciarRodada();
	}
}
