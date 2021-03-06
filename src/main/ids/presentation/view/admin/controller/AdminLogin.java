package main.ids.presentation.view.admin.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.response.Response;
import main.ids.presentation.view.controller.GestioneDatiPersonali;
import main.ids.util.viewUtil.CallViewLoop;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.request.RequestType;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;

public class AdminLogin implements Initializable {
	
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
	public MenuButton personalMenu;
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		MenuItem logout = new MenuItem("Logout");
		logout.setOnAction(e -> GestioneDatiPersonali.logout());
		personalMenu.getItems().addAll(logout);
		frontController = new DefaultFrontController();
		
		clienti.setOnAction(e -> CallViewLoop.clientiViewAdmin());
		contratti.setOnAction(e -> CallViewLoop.contrattiViewAdmin());
		auto.setOnAction(e -> CallViewLoop.autoViewAdmin());
		fascia.setOnAction(e -> CallViewLoop.fasciaViewAdmin());
		staff.setOnAction(e -> CallViewLoop.staffViewAdmin());
	}
	
	

}
