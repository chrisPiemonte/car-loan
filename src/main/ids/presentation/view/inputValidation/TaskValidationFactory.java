package main.ids.presentation.view.inputValidation;

import java.time.LocalDate;

import javafx.scene.control.Alert.AlertType;
import main.ids.presentation.view.controller.Message;

public class TaskValidationFactory {

	public TaskValidationFactory instance = new TaskValidationFactory();
	
	private TaskValidationFactory(){
		
	}
	
	public static boolean getClienteValidation(String cf,String nome,String cognome,LocalDate data,String telefono){
		if(cf != null && nome != null && cognome != null && data != null && telefono != null){
			Message.display("Inserire tutti i campi", AlertType.ERROR);
			return false;
			}
		else {
		InputValidation i = InputValidationFactory.getValidation("cf");
		if (i.isValid(cf)){
			i = InputValidationFactory.getValidation("nome");
			if(i.isValid(nome)){
				i = InputValidationFactory.getValidation("cognome");
				if(i.isValid(cognome)){
					i = InputValidationFactory.getValidation("telefono");
					if(i.isValid(telefono)){
						return true;
					}else { Message.display("telefono non valido", AlertType.ERROR);
							
							return false;
					}
				}else { Message.display("Cognome non valido", AlertType.ERROR);
						
						return false;
				}
			}else { Message.display("Nome non valido", AlertType.ERROR);
					
					return false;
			}
		}else { Message.display("Codice Fiscale non valido", AlertType.ERROR);
				
				return false;}
		
	}
	}
	
	public static boolean getFasciaValidation(String id,String descrizione, String tariffaG, String tariffaS, String tariffaKm){
		if (id != null && descrizione != null && tariffaG != null && tariffaS != null && tariffaKm != null ){
			
			InputValidation i = InputValidationFactory.getValidation("id");
			if (i.isValid(id)){
				i = InputValidationFactory.getValidation("nome");
				if(i.isValid(descrizione)){
					i = InputValidationFactory.getValidation("double");
					if(i.isValid(tariffaG)){
						i = InputValidationFactory.getValidation("double");
						if(i.isValid(tariffaS)){
							i = InputValidationFactory.getValidation("double");
							if(i.isValid(tariffaKm)) {
								return true;
							}else{
								Message.display("Inserire tariffa chilometrica", AlertType.ERROR);
								return false;
							}
						}else { Message.display("Inserire tariffa settimanale", AlertType.ERROR);
								
								return false;
						}
					}else { Message.display("Inserire tariffa giornaliera", AlertType.ERROR);
							
							return false;
					}
				}else { Message.display("Descrizione non valida", AlertType.ERROR);
						
						return false;
				}
			}else { Message.display("ID non valido", AlertType.ERROR);
					
					return false;}
		
	} else { 
		Message.display("Inserire tutti i campi", AlertType.ERROR);
		return false;
	}
		}
	
}