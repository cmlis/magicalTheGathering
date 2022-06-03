package br.com.zappts.magicthegathering.bean;

public enum TipoIdioma {
	
	
	PORTUGUES("Portugues"),
	ENGLISH("English"),
	JANAPESE("Japanes");
	

	private String tipoIdioma;

	
	
	private TipoIdioma(String tipoIdioma) {
		this.tipoIdioma = tipoIdioma;
	}

	public String getTipoIdioma() {
		return tipoIdioma;
	}

	public void setTipoIdioma(String tipoIdioma) {
		this.tipoIdioma = tipoIdioma;
	}
	
	
	public static TipoIdioma converter(String tipoIdioma) {
		
		switch(tipoIdioma) {
		case "Português":
			return TipoIdioma.PORTUGUES;
		case "Inglês":
			return TipoIdioma.ENGLISH;
		case "Japonês":
			return TipoIdioma.JANAPESE;
		default:
			 throw new IllegalArgumentException("ShortName [" + tipoIdioma
		                + "] not supported.");
			
			
		}
		
	}
	
	
}
