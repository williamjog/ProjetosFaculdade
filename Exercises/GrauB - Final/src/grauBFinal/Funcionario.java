package grauBFinal;

public class Funcionario {

	private double salarioBruto;
	private double salarioLiquido;

	public Funcionario(double salarioBruto, double salarioLiquido) {
		this.salarioBruto = salarioBruto;
		this.salarioLiquido = salarioLiquido;
	}

	public Funcionario() {
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}
}
