package main.ids.presentation.command.gestioneClienti;

import main.ids.business.applicationServices.GestioneClienti;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ClienteTO;
	/**Incapsula l'operazione di inserimento di un nuovo elemento 
	 * 
	 * @author bi
	 *
	 */
public class AddCliente implements Command  {
	
	private ComplexRequest<ClienteTO> request;
	private GestioneClienti gestioneClienti;
	
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri connessi con l'inserimento
		 */
	public AddCliente(Request request){
		this.gestioneClienti = new GestioneClienti();
		this.request = (ComplexRequest<ClienteTO>) request;
	}
	
	@Override
	public Response execute() {

		boolean inserito = gestioneClienti.addNewCliente(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(inserito);
		return response;
	}

}