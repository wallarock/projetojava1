package primeiro.jdev;

public abstract class Pessoa {

	protected String nome;
	protected int idade;
	protected String dataNascimento;
	protected String numeroCPF;
	protected String numeroRG;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNumeroCPF() {
		return numeroCPF;
	}

	public void setNumeroCPF(String numeroCPF) {
		this.numeroCPF = numeroCPF;
	}

	public String getNumeroRG() {
		return numeroRG;
	}

	public void setNumeroRG(String numeroRG) {
		this.numeroRG = numeroRG;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", numeroCPF="
				+ numeroCPF + ", numeroRG=" + numeroRG + "]";
	}

	public boolean maiorIdade() {
		return idade >= 18;

	}

	public abstract double salario();

}
