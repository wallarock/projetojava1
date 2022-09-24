package cursojava.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.constantes.StatusAluno;

public class PrimeiraClasseJava {

	public static void main(String[] args) {

		List<Aluno> alunos = new ArrayList<Aluno>();

		HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();
		
		String user = JOptionPane.showInputDialog("Uduário:");
		String senha = JOptionPane.showInputDialog("Semha:");
		
		if(user.equalsIgnoreCase("wallarock") && senha.equalsIgnoreCase("4995")) {

		for (int qtd = 1; qtd <= 6; qtd++) {

			String nome = JOptionPane.showInputDialog("Nome do aluno: ");

			Aluno aluno1 = new Aluno();

			aluno1.setNome(nome);

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

		maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
		maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

		for (Aluno aluno : alunos) {

			if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
				maps.get(StatusAluno.APROVADO).add(aluno);
			} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				maps.get(StatusAluno.RECUPERACAO).add(aluno);
			} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.REPROVADO)) {
				maps.get(StatusAluno.REPROVADO).add(aluno);
			}

		}

		System.out.println("---------------------Aprovados--------------------");

		for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {

			System.out.println("Nome: " + aluno.getNome() + " Resultado: " + aluno.getAlunoAprovado2() + " Nota: "
					+ aluno.getMediaNota());
		}

		System.out.println("---------------------Recuperação--------------------");

		for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {

			System.out.println("Nome: " + aluno.getNome() + " Resultado: " + aluno.getAlunoAprovado2() + " Nota: "
					+ aluno.getMediaNota());
		}

		System.out.println("---------------------Reprovados--------------------");

		for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {

			System.out.println("Nome: " + aluno.getNome() + " Resultado: " + aluno.getAlunoAprovado2() + " Nota: "
					+ aluno.getMediaNota());
		}
		
		}

	}

}
