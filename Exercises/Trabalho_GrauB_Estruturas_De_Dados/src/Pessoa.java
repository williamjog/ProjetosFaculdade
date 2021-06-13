import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {
	
	private long CPF;
	private int RG;
	private String nome;
	private Date dataDeNascimento;
	private String nomeDaCidade;
	
	public Pessoa(long CPF, int RG, String nome, Date dataDeNascimento, String nomeDaCidade) {
		this.CPF = CPF;
		this.RG = RG;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.nomeDaCidade = nomeDaCidade;
	}

	public long getCPF() {
		return this.CPF;
	}

	public void setCPF(int CPF) {
		this.CPF = CPF;
	}

	public int getRG() {
		return this.RG;
	}

	public void setRG(int RG) {
		this.RG = RG;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNomeDaCidade() {
		return nomeDaCidade;
	}

	public void setNomeDaCidade(String nomeDaCidade) {
		this.nomeDaCidade = nomeDaCidade;
	}

	@Override
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formato.format(this.getDataDeNascimento());
		
		return "\tCPF: " + this.getCPF() + "\n" +
			   "\tRG: " + this.getRG() + "\n" +
			   "\tNome: " + this.getNome() + "\n" +
			   "\tData de Nascimento: " + dataFormatada + "\n" +
			   "\tCidade: " + this.getNomeDaCidade() + "\n";
	}
		
}
