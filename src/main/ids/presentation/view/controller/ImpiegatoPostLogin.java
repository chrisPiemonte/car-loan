package main.ids.presentation.view.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import main.ids.presentation.FrontController;
import main.ids.presentation.response.Response;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.request.RequestType;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;

public class ImpiegatoPostLogin implements Initializable {
	
	public TextField usernameInput;
	public TextField passwordInput;
	public ArrayList<String> data = new ArrayList<String>();
	public Response response;
	FrontController frontController;
	public Button clienti;
	public Button contratti;
	public Button auto;
	public Button fascia;
	public Button staff;
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		System.out.println("Loading user data...");
		frontController = new FrontController();
		
		clienti.setOnAction(e -> callClientiView());
		contratti.setOnAction(e -> callContrattiView());
		auto.setOnAction(e -> callAutoView());
		fascia.setOnAction(e -> callFasciaView());
		staff.setOnAction(e -> callStaffView());
	}
	

	
	
	private void callClientiView(){
		BasicRequest request = new BasicRequest();
		request.setRequest("gestioneCliente");
		request.setType(RequestType.VIEW);
		frontController.processRequest(request);
	}
	
	private void callContrattiView(){
		Request request = new BasicRequest();
		request.setRequest("gestioneContratti");
		frontController.processRequest(request);
	}
	
	private void callAutoView(){
		Request request = new BasicRequest();
		request.setRequest("gestioneAuto");
		frontController.processRequest(request);
	}
	
	private void callFasciaView(){
		Request request = new BasicRequest();
		request.setRequest("gestioneFascia");
		frontController.processRequest(request);
	}
	
	private void callStaffView(){
		Request request = new BasicRequest();
		request.setRequest("gestioneStaff");
		frontController.processRequest(request);
	}
	

}