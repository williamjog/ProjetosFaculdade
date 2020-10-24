package grauBFinal;

public class Estadual extends Deputado {

	private String estado;

	public Estadual(String nome, String partido, double salarioBruto, double salarioLiquido, int numeroDeFuncionarios,
			String estado) {
		super(nome, partido, salarioBruto, salarioLiquido, numeroDeFuncionarios);
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Estado: " + estado;
	}
}
