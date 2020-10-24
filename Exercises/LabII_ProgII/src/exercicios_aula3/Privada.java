package exercicios_aula3;

public class Privada extends Universidade {
	
	private double mensalidade;

	public Privada(String nome, String endereco, int quantidadeAlunos, int quantProfessores, double mensalidade) {
		super(nome, endereco, quantidadeAlunos, quantProfessores);
		this.mensalidade = mensalidade;
	}

	public double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(int mensalidade) {
		this.mensalidade = mensalidade;
	}
	
	public void increaseMensalidade(double valor) {
		mensalidade += valor;
	}
	
	@Override
	public String toString() {
		return "Nome: " + getNome() + '\n' +
				"Endereço: " + getEndereco() + '\n' +
				"Quantidade de Alunos: " + getQuantidadeAlunos() + '\n' +
				"Quantidade de Professores: " + getQuantProfessores() + '\n' +
				"Valor da mensalidade: " + mensalidade;		
	}
}
