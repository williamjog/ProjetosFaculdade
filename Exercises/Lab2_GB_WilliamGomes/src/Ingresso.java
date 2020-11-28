public class Ingresso {
	
	protected String nomeDaPessoa;
	protected String localizacaoNoEstadio;
	protected String tipo;
	
	public Ingresso(String nomeDaPessoa, String localizacaoNoEstadio, String tipo) {
		this.nomeDaPessoa = nomeDaPessoa;
		this.localizacaoNoEstadio = localizacaoNoEstadio;
		this.tipo = tipo;
	}
	
	public Ingresso() {}
	
	public String getNomeDaPessoa() {
		return nomeDaPessoa;
	}
	public void setNomeDaPessoa(String nomeDaPessoa) {
		this.nomeDaPessoa = nomeDaPessoa;
	}
	public String getLocalizacaoNoEstadio() {
		return localizacaoNoEstadio;
	}
	public void setLocalizacaoNoEstadio(String localizacaoNoEstadio) {
		this.localizacaoNoEstadio = localizacaoNoEstadio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Nome: " + this.getNomeDaPessoa() + "\n" +
				"Localidade: " + this.getLocalizacaoNoEstadio() + "\n" +
				"Tipo: " + this.getTipo();
			}
}	
