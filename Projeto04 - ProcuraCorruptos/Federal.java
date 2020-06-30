package grauBFinal;

public class Federal extends Deputado {

	private int numeroDeCadastro;

	public Federal(String nome, String partido, double salarioBruto, double salarioLiquido, int numeroDeFuncionarios,
			int numeroDeCadastro) {
		super(nome, partido, salarioBruto, salarioLiquido, numeroDeFuncionarios);
		this.numeroDeCadastro = numeroDeCadastro;
	}

	public int getNumeroDeCadastro() {
		return numeroDeCadastro;
	}

	public void setNumeroDeCadastro(int numeroDeCadastro) {
		this.numeroDeCadastro = numeroDeCadastro;
	}

	@Override
	public String toString() {
		return "Numero de Cadastro: " + numeroDeCadastro;
	}
}
