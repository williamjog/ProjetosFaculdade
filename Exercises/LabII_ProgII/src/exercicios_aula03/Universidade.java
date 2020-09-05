package exercicios_aula03;

public class Universidade {
	
	private String nome;
	private String endereco;
	private int quantidadeAlunos;
	private int quantProfessores;
	
	public Universidade(String nome, String endereco, int quantidadeAlunos, int quantProfessores) {
		this.nome = nome;
		this.endereco = endereco;
		this.quantidadeAlunos = quantidadeAlunos;
		this.quantProfessores = quantProfessores;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getQuantidadeAlunos() {
		return quantidadeAlunos;
	}

	public void setQuantidadeAlunos(int quantidadeAlunos) {
		this.quantidadeAlunos = quantidadeAlunos;
	}

	public int getQuantProfessores() {
		return quantProfessores;
	}

	public void setQuantProfessores(int quantProfessores) {
		this.quantProfessores = quantProfessores;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + '\n' +
				"Endereço: " + endereco + '\n' +
				"Quantidade de Alunos: " + quantidadeAlunos + '\n' +
				"Quantidade de Professores: " + quantProfessores;	
	}
}
