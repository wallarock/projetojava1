package cursojava.executavel;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

public class PrimeiraClasseJava {

	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog("Nome do aluno: ");
		//String idade = JOptionPane.showInputDialog("idade: ");
		
		Aluno aluno1 = new Aluno();
				
		aluno1.setNome(nome);
		//aluno1.setIdade(Integer.valueOf(idade));
		
		for (int pos = 1; pos <= 3; pos++) {
			
			String nomeDisciplina = JOptionPane.showInputDialog("Qual é o nome da disciplina "+pos+" ?: ");
			String notaDisciplina = JOptionPane.showInputDialog("Qual a nota da disciplina " +pos+"?: ");
			
			Disciplina disciplina = new Disciplina();
			disciplina.setDisciplina(nomeDisciplina);
			disciplina.setNota(Double.valueOf(notaDisciplina));
			
			aluno1.getDisciplinas().add(disciplina);
		}
		
		int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");
		
		if (escolha == 0) { //Escolha sim é igual a zero
			
			int continuarRemover = 0;
			int posicao = 1;
			
			while(continuarRemover == 0) {
				String disciplinaRemover = JOptionPane.showInputDialog("Qual disciplina 1, 2, 3 ou 4?");
				aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
				posicao ++;
				continuarRemover = JOptionPane.showConfirmDialog(null, "Deseja remover outra disciplina?");
			}
			
		}
				
		System.out.println("O nome é: " + aluno1.getNome());
		//System.out.println("A Idade é: " + aluno1.getIdade());
		System.out.println("Nome das disciplinas: " + aluno1.getDisciplinas());
		System.out.println("A média da nota é: " + aluno1.getMediaNota());
		//System.out.println("Resultado: " + (aluno1.getAlunoAprovado() ? "Aprovado" : "Reprovado"));
		System.out.println("Resultado: " + aluno1.getAlunoAprovado2());

	}

}
