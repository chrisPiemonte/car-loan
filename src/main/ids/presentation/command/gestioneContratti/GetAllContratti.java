package main.ids.presentation.command.gestioneContratti;

import java.util.List;

import main.ids.business.applicationServices.GestioneContratti;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ContrattoTO;
	/**Incapsula l'operazione di estrazione di tutti i contratti
	 * 
	 * @author bi
	 *
	 */
public class GetAllContratti implements Command  {
	
	private Request request;
	private GestioneContratti gestioneContratti;
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri connessi con l'operazione
		 */
	public GetAllContratti(Request request){
		this.gestioneContratti = new GestioneContratti();
		this.request = request;
	}
	
	@Override
	public Response execute() {
		List<ContrattoTO> listContratti = gestioneContratti.getAll();
		ComplexResponse<ContrattoTO> response = new ComplexResponse<ContrattoTO>();
		response.setParameters(listContratti);
		return response;
	}

}