package main.ids.presentation.view.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import main.ids.presentation.FrontController;
import main.ids.presentation.response.Response;
import main.ids.presentation.request.Request;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class Staff implements Initializable {
	
	public TextField usernameInput;
	public TextField passwordInput;
	public ArrayList<String> data = new ArrayList<String>();
	public Response response;
	FrontController frontController = new FrontController();
	public Button clienti;
	public Button contratti;
	public Button auto;
	public Button fascia;
	public TreeView<String> elementTree;
	TreeItem<String> root,elemento;
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		System.out.println("Loading user data...");
		
		clienti.setOnAction(e -> callClientiView());
		contratti.setOnAction(e -> callContrattiView());
		auto.setOnAction(e -> callAutoView());
		fascia.setOnAction(e -> callFasciaView());
		
		
		
	}
	
	
	private void callClientiView(){
		Request request = new Request();
		request.setRequest("gestioneCliente");
		frontController.processRequest(request);
	}
	
	private void callContrattiView(){
		Request request = new Request();
		request.setRequest("gestioneContratti");
		frontController.processRequest(request);
	}
	
	private void callAutoView(){
		Request request = new Request();
		request.setRequest("gestioneAuto");
		frontController.processRequest(request);
	}
	
	private void callFasciaView(){
		Request request = new Request();
		request.setRequest("gestioneFascia");
		frontController.processRequest(request);
	}
	
	private TreeItem<String> makeBranch(String title, TreeItem<String> parent){
		TreeItem<String> item = new TreeItem<>(title);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;
	}
	
	
	private void checkLeaf(Number leaf){
		Request request = new Request();
		switch(leaf.intValue()){
		case 1:
			request.setRequest("inserisciClienteLeaf");
			frontController.processRequest(request);
			break;
			
		case 2:
			request.setRequest("modificaCliente");
			frontController.processRequest(request);
		}
		
		
		
	}



}