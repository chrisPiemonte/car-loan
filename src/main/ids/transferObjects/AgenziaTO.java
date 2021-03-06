package main.ids.transferObjects;

/**
 * Transfer object per il business object {@link AgenziaBO}
 * 
 * @author chris
 */
public class AgenziaTO implements TransferObject {
	
	private String id;
	private String citta;
	private String indirizzo;
	private String telefono;
	
	public AgenziaTO(String citta, String indirizzo, String telefono){
		this.citta = citta;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
	}
	
	public AgenziaTO(){
	}
	
	public void setId (String id){
		this.id = id;
	}
	
	public String getId (){
		return id;
	}
	
	public String getCitta(){
		return citta;
	}
	
	public String getIndirizzo(){
		return indirizzo;
	}
	
	public void setCitta(String citta){
		this.citta = citta;
	}
	
	public void setIndirizzo(String indirizzo){
		this.indirizzo = indirizzo;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String toString(){
		return this.getId() + " " + this.getCitta() + " " + this.getIndirizzo() + " " + this.getTelefono();
	}
	
}
