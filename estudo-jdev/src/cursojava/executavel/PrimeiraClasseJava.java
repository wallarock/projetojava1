package cursojava.executavel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;


public class PrimeiraClasseJava {

	public static void main(String[] args) {

		List<Aluno> alunos = new ArrayList<Aluno>();

		for (int qtd = 1; qtd <= 2; qtd++) {

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

			/*
			 * int escolha = JOptionPane.showConfirmDialog(null,
			 * "Deseja remover alguma disciplina?");
			 * 
			 * if (escolha == 0) { // Escolha sim é igual a zero
			 * 
			 * int continuarRemover = 0; int posicao = 1;
			 * 
			 * while (continuarRemover == 0) { String disciplinaRemover =
			 * JOptionPane.showInputDialog("Qual disciplina 1, 2, 3 ou 4?");
			 * aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue()
			 * - posicao); posicao++; continuarRemover = JOptionPane.showConfirmDialog(null,
			 * "Deseja remover outra disciplina?"); }
			 * 
			 * }
			 */

			alunos.add(aluno1);

		}

		for (int pos = 0; pos < alunos.size(); pos ++) {
			
			Aluno aluno = alunos.get(pos);
			
			if(aluno.getNome().equalsIgnoreCase("wess")) {
				
				Aluno trocar = new Aluno();
				trocar.setNome("Will");
				
				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina("WWW");
				disciplina.setNota(99.5);
				
				trocar.getDisciplinas().add(disciplina);
				
				alunos.set(pos, trocar);
				aluno = alunos.get(pos);
				
			}
			
			System.out.println("Aluno: " + aluno.getNome());
			//System.out.println("Disciplina: " + aluno.getDisciplinas());
			System.out.println("Nota: " + aluno.getMediaNota());
			System.out.println("Resultado: " + aluno.getAlunoAprovado2());
			System.out.println("===============================================================================");
			
			for (int posd = 0; posd < aluno.getDisciplinas().size(); posd ++) {
				
				Disciplina disc = aluno.getDisciplinas().get(posd);				
				System.out.println("Matéria: " + disc.getDisciplina() + " Nota: " + disc.getNota());
			}
			
		}
		
	}

}
