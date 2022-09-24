package cursojava.classes;

import java.util.ArrayList;
import java.util.List;

import cursojava.constantes.StatusAluno;

public class Aluno extends Pessoa {
	

	private String dataMatricula;
	private String nomeEscola;
	private String serieMatriculado;

	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public Aluno() {
		
		
	}
	
	public Aluno (String nomePadrao) {
		
		nome = nomePadrao;
		
	}
	

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

	public String getRegistroGeral() {
		return registroGeral;
	}

	public void setRegistroGeral(String registroGeral) {
		this.registroGeral = registroGeral;
	}

	public String getNumeroCPF() {
		return numeroCPF;
	}

	public void setNumeroCPF(String numeroCPF) {
		this.numeroCPF = numeroCPF;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public String getSerieMatriculado() {
		return serieMatriculado;
	}

	public void setSerieMatriculado(String serieMatriculado) {
		this.serieMatriculado = serieMatriculado;
	}
	
	

		
	@Override
	public String toString() {
		return "Aluno [dataMatricula=" + dataMatricula + ", nomeEscola=" + nomeEscola + ", serieMatriculado="
				+ serieMatriculado + ", disciplinas=" + disciplinas + ", nome=" + nome + ", idade=" + idade
				+ ", dataNascimento=" + dataNascimento + ", registroGeral=" + registroGeral + ", numeroCPF=" + numeroCPF
				+ ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + "]";
	}
	
	

	public double getMediaNota() {
		
		double somaNotas = 0.0;
		
		for (Disciplina disciplina : disciplinas) {
			
			somaNotas += disciplina.getNota();
			
		}
		
		return somaNotas / disciplinas.size();
	}
	
	public boolean getAlunoAprovado() {
		
		double media = this.getMediaNota();
		if (media >= 70) {
			return true;
			
		}else {
			return false;
		}
		
	}
	
	public String getAlunoAprovado2() {
		
		double media = this.getMediaNota();
		
		if(media >=50) {
			if(media >= 70) {
				return StatusAluno.APROVADO;							
			}else {	
				return StatusAluno.RECUPERACAO;
			}
		}
		else {
			return StatusAluno.REPROVADO;
		}
	}
		
	@Override
	public boolean pessoaMaiorIdade() {
		
		return idade >= 16;
	}
	
	public String msgMaiorIdade() {
		return this.pessoaMaiorIdade() ? "Falow ô véião!!!" : "Hahaha bebezão!!!";
	}
	
}

