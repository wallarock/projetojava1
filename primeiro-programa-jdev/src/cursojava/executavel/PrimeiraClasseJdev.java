package cursojava.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.constantes.StatusAluno;
import primeiro.jdev.Aluno;
import primeiro.jdev.Disciplina;
import primeiro.jdev.Secretario;

public class PrimeiraClasseJdev {

	public static void main(String[] args) {

		Secretario secretario = new Secretario();

		String login = JOptionPane.showInputDialog("Informe o Login");
		String senha = JOptionPane.showInputDialog("Informe a senha");

		secretario.setLogin(login);
		secretario.setSenha(senha);

		if (secretario.autenticar()) {

			List<Aluno> alunos = new ArrayList<Aluno>();
			/*
			 * List<Aluno> alunosAprovados = new ArrayList<Aluno>(); List<Aluno>
			 * alunosReprovados = new ArrayList<Aluno>();
			 */

			HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

			for (int qtd = 1; qtd <= 2; qtd++) {

				String aluno = JOptionPane.showInputDialog("Qual nome do Aluno " + qtd + "?");

				Aluno aluno1 = new Aluno();

				aluno1.setNome(aluno);

				for (int pos = 1; pos <= 1; pos++) {
					String nomeDisciplina = JOptionPane.showInputDialog("Qual a disciplina " + pos + "?");
					String notaDisciplina = JOptionPane.showInputDialog("qual a nota da disciplina " + pos + "?");

					Disciplina disciplina = new Disciplina();
					disciplina.setDisciplina(nomeDisciplina);
					disciplina.setNota(Double.valueOf(notaDisciplina));

					aluno1.getDisciplinas().add(disciplina);

				}

				/*
				 * int escolha = JOptionPane.showConfirmDialog(null,
				 * "Deseja remover alguma disciplina?");
				 * 
				 * if (escolha == 0) {
				 * 
				 * int continuarRemover = 0; int posicao = 0;
				 * 
				 * while (continuarRemover == 0){
				 * 
				 * String disciplinaRemover = JOptionPane.showInputDialog("Qual disciplina?");
				 * aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue()
				 * - posicao); posicao++;
				 * 
				 * continuarRemover = JOptionPane.showConfirmDialog(null,
				 * "Remover outra disciplina?");
				 * 
				 * } }
				 */

				alunos.add(aluno1);

			}

			maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

			for (Aluno aluno : alunos) {

				if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.APROVADO)) {

					maps.get(StatusAluno.APROVADO).add(aluno);

				} else if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.REPROVADO)) {

					maps.get(StatusAluno.REPROVADO).add(aluno);
				}

			}

			System.out.println("======================= Alunos Aprovados ==========================\n");

			for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
				System.out.println("Nome: " + aluno.getNome() + " \nResultado: " + aluno.getAlunoAprovado()
						+ "\nMédia: " + aluno.getMediaNota() + "\n");
			}

			System.out.println("======================= Alunos Reprovados =========================\n");

			for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
				System.out.println("Nome: " + aluno.getNome() + " \nResultado: " + aluno.getAlunoAprovado()
						+ "\nMédia: " + aluno.getMediaNota() + "\n");
			}
		}else {
			JOptionPane.showMessageDialog(null,"Erro de Autenticação");
		}
	}
}