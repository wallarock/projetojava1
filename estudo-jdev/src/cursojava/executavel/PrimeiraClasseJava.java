package cursojava.executavel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.constantes.StatusAluno;

public class PrimeiraClasseJava {

	public static void main(String[] args) {

		List<Aluno> alunos = new ArrayList<Aluno>();

		List<Aluno> alunosAprovados = new ArrayList<Aluno>();
		List<Aluno> alunosRecuperacao = new ArrayList<Aluno>();
		List<Aluno> alunosReprovados = new ArrayList<Aluno>();

		for (int qtd = 1; qtd <= 6; qtd++) {

			String nome = JOptionPane.showInputDialog("Nome do aluno: ");
			// String idade = JOptionPane.showInputDialog("idade: ");

			Aluno aluno1 = new Aluno();

			aluno1.setNome(nome);
			// aluno1.setIdade(Integer.valueOf(idade));

			for (int pos = 1; pos <= 1; pos++) {

				String nomeDisciplina = JOptionPane.showInputDialog("Qual é o nome da disciplina " + pos + " ?: ");
				String notaDisciplina = JOptionPane.showInputDialog("Qual a nota da disciplina " + pos + "?: ");

				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(nomeDisciplina);
				disciplina.setNota(Double.valueOf(notaDisciplina));

				aluno1.getDisciplinas().add(disciplina);
			}

			alunos.add(aluno1);

		}

		for (Aluno aluno : alunos) {

			if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
				alunosAprovados.add(aluno);
			} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				alunosRecuperacao.add(aluno);
			} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.REPROVADO)) {
				alunosReprovados.add(aluno);
			}

		}

		System.out.println("---------------------Aprovados--------------------");

		for (Aluno aluno : alunosAprovados) {

			System.out.println("Nome: " + aluno.getNome() + " Resultado: " + aluno.getAlunoAprovado2() + " Nota: "
					+ aluno.getMediaNota());
		}
		
		System.out.println("---------------------Recuperação--------------------");

		for (Aluno aluno : alunosRecuperacao) {

			System.out.println("Nome: " + aluno.getNome() + " Resultado: " + aluno.getAlunoAprovado2() + " Nota: "
					+ aluno.getMediaNota());
		}
		
		System.out.println("---------------------Reprovados--------------------");

		for (Aluno aluno : alunosReprovados) {

			System.out.println("Nome: " + aluno.getNome() + " Resultado: " + aluno.getAlunoAprovado2() + " Nota: "
					+ aluno.getMediaNota());
		}

	}

}
