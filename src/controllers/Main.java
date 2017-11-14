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


public class Main extends Application {
	private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();
	protected static Stage stage;
	private static Scene mainScene;
	private static Scene nomeScene;
	private static Scene rodadaScene;
	private static Scene rankingScene;
	private static Scene editionScene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		primaryStage.setTitle("Show do Milhão");
	
		Parent fxmlMain = FXMLLoader.load(getClass().getResource("../view/main_screen.fxml"));	
		mainScene = new Scene(fxmlMain, 600, 385);
		
		Parent fxmlNome = FXMLLoader.load(getClass().getResource("../view/nome_screen.fxml"));
		nomeScene = new Scene(fxmlNome, 600, 385);
		
		Parent fxmlRodada = FXMLLoader.load(getClass().getResource("../view/rodada_screen.fxml"));
		rodadaScene = new Scene(fxmlRodada, 650, 400);
		
		Parent fxmlRanking = FXMLLoader.load(getClass().getResource("../view/placar_screen.fxml"));
		rankingScene = new Scene(fxmlRanking, 600, 385);
		
		Parent fxmlEdition = FXMLLoader.load(getClass().getResource("../view/edition_screen.fxml"));
		editionScene = new Scene(fxmlEdition, 600, 385);
		
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}public static void changeScreen(String tela, Object userData){
		switch(tela) {
		case "main":
			stage.setScene(mainScene);
			notifyAllListeners("main", userData);
			break;
		case "novoJogador":
			stage.setScene(nomeScene);
			notifyAllListeners("novoJogador", userData);
			break;
		case "iniciarRodada":
			stage.setScene(rodadaScene);
			notifyAllListeners("iniciarRodada", userData);
			break;
		case "ranking":
			stage.setScene(rankingScene);
			notifyAllListeners("ranking", userData);
			break;
		case "editarPergunta":
			stage.setScene(editionScene);
			notifyAllListeners("editarPergunta", userData);
		}
	}public static void changeScreen(String tela) {
		changeScreen(tela, null);
	}
	public static interface OnChangeScreen{
		void onScreenChanged(String newScreen, Object userData);
	}
	public static void addOnChangeScreenListener(OnChangeScreen newListener) {
		listeners.add(newListener);
	}
	private static void notifyAllListeners(String newScreen, Object userData) {
		for(OnChangeScreen l:listeners) {
			l.onScreenChanged(newScreen, userData);
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
