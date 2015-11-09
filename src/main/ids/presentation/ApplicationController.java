package main.ids.presentation;

import main.ids.presentation.request.Request;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AdminTO;
import main.ids.transferObjects.ImpiegatoTO;
import main.ids.transferObjects.ManagerTO;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.command.Command;
import main.ids.presentation.command.CommandFactory;
import main.ids.util.json.ViewsJsonParser;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import main.ids.presentation.Dispatcher;

public class ApplicationController {
	
	ArrayList<String> parameters = new ArrayList<String>();
	private Dispatcher dispatcher;
	private ViewsJsonParser vjp;
	//Object result;
	ComplexResponse response ;
	CommandFactory commandFactory ;

	

	
	public ApplicationController(){
		
		//this.result = null;
		this.commandFactory = CommandFactory.getIstance();
		//this.command = new Command();
		
	}
	
	//richieste che non chiedono l'utilizzo di parametri
	
	public Response handleRequest(Request request){
		//System.out.println(request.getRequest());
	 if(request.getType() == RequestType.SERVICE)
		{
			switch(request.getRequest()){
			
			case "login":
				return login(request);
				 
				
				
			
			
			}

		}
		
	 else if (request.getType() == RequestType.VIEW){
		 System.out.println("HEI");
		switch (request.getRequest()) {
		case "bootstrap":
			ComplexResponse<Scene> resp = new ComplexResponse<Scene>();
			//ene scene = new Scene();
			dispatcher = new Dispatcher();
			//vjp = ViewsJsonParser.getInstance();
			resp.addParameter(dispatcher.begin()) ;
			return resp;
			
		case "astalavistababy":
			break;
		
		
		default:
			vjp = ViewsJsonParser.getInstance();
			//vjp.getInstance();
			dispatcher = new Dispatcher();
			dispatcher.setInterface(vjp.getViewPath(request.getRequest()));
			}
		
		}
		return null;
		
	}
	
	
	public Response login(Request request){
	 
		response =  new ComplexResponse<ImpiegatoTO>();
		try{
		Command command = commandFactory.getCommand(request.getRequest(), request);
		response = (ComplexResponse<ImpiegatoTO>) command.execute();
		ImpiegatoTO impiegato = (ImpiegatoTO) response.getParameters().get(0);
		if (impiegato != null){
			if (impiegato.getClass().equals(AdminTO.class)){
				
			}
			else if (impiegato.getClass().equals(ManagerTO.class)){
				
			}
			
			else {
				String pathImpiegato = "impiegatoBoot";
				vjp = ViewsJsonParser.getInstance();
				dispatcher = new Dispatcher(); 
				dispatcher.setInterface(vjp.getViewPath(pathImpiegato));
			}
		}
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
				
				
		
		response.setResponse(true);
		return response;
		
		
		
	}
	
	
	
}
