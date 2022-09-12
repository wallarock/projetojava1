package cursojava.executavel;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

public class PrimeiraClasseJava {

	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog("Nome do aluno: ");
		String idade = JOptionPane.showInputDialog("idade: ");
		
		Aluno aluno1 = new Aluno();
				
		aluno1.setNome(nome);
		aluno1.setIdade(Integer.valueOf(idade));
		
		for (int pos = 1; pos <= 3; pos++) {
			
			String nomeDisciplina = JOptionPane.showInputDialog("Qual é o nome da disciplina "+pos+" ?: ");
			String notaDisciplina = JOptionPane.showInputDialog("Qual a nota da disciplina " +pos+"?: ");
			
			Disciplina disciplina = new Disciplina();
			disciplina.setDisciplina(nomeDisciplina);
			disciplina.setNota(Double.valueOf(notaDisciplina));
			
			aluno1.getDisciplinas().add(disciplina);
		}
		
				
		System.out.println("O nome é: " + aluno1.getNome());
		System.out.println("A Idade é: " + aluno1.getIdade());
		System.out.println("Nome das disciplinas: " + aluno1.getDisciplinas());
		System.out.println("A média da nota é: " + aluno1.getMediaNota());
		System.out.println("Resultado: " + (aluno1.getAlunoAprovado() ? "Aprovado" : "Reprovado"));
		
		

	}

}
