package grauBFinal;

public class Deputado {

	protected String nome;
	protected String partido;
	protected double salarioBruto;
	protected double salarioLiquido;
	protected Funcionario[] funcionarios;

	public Deputado(String nome, String partido, double salarioBruto, double salarioLiquido, int numeroDeFuncionarios) {
		this.nome = nome;
		this.partido = partido;
		this.salarioBruto = salarioBruto;
		this.salarioLiquido = salarioLiquido;
		this.funcionarios = new Funcionario[numeroDeFuncionarios];
		geraFuncionarios();
	}

	public String getNome() {
		return nome;
	}

	public double getSalarioBruto70() {
		return salarioBruto * 0.70;
	}

	public double getSalarioBruto80() {
		return salarioBruto * 0.80;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public Funcionario[] getFuncionarios() {
		return funcionarios;
	}

	public Funcionario getFuncionarios(int i) {
		return funcionarios[i];
	}

	private void geraFuncionarios() {
		for (int i = 0; i < funcionarios.length; i++) {
			funcionarios[i] = new Funcionario();
			funcionarios[i].setSalarioBruto(((int) (Math.random() * 2000)) + 3000);
			funcionarios[i].setSalarioLiquido(
					funcionarios[i].getSalarioBruto() + ((int) (Math.random() * -2000) + (int) (Math.random() * 3000)));
		}
	}
}
