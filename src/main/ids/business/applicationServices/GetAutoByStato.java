package main.ids.business.applicationServices;

import java.util.List;

import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AutoTO;

public class GetAutoByStato implements Command  {
	

	private ComplexRequest<String> request;
	private GestioneAuto gestioneAuto;
	
	
	public GetAutoByStato(Request request){
		this.gestioneAuto = new GestioneAuto();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		List<AutoTO> autoDisponibili = gestioneAuto.getByStato(request.getParameters().get(0));
		ComplexResponse<AutoTO> response = new ComplexResponse<AutoTO>();
		response.setParameters(autoDisponibili);
		return response;
	}

}