package exercicios_aula3;

public class Publica extends Universidade {
	
	private int quantConcursados;

	public Publica(String nome, String endereco, int quantidadeAlunos, int quantProfessores, int quantConcursados) {
		super(nome, endereco, quantidadeAlunos, quantProfessores);
		this.quantConcursados = quantConcursados;
	}

	public int getQuantConcursados() {
		return quantConcursados;
	}

	public void setQuantConcursados(int quantConcursados) {
		this.quantConcursados = quantConcursados;
	}
	
	public void increaseConcursados() {
		quantConcursados += 1;
	}
	
	@Override
	public String toString() {
		return "Nome: " + getNome() + '\n' +
				"Endereço: " + getEndereco() + '\n' +
				"Quantidade de Alunos: " + getQuantidadeAlunos() + '\n' +
				"Quantidade de Professores: " + getQuantProfessores() + '\n' +
				"Quantidade de Concursados: " + quantConcursados;		
	}

}
