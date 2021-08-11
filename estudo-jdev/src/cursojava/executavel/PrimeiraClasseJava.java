package cursojava.executavel;

import cursojava.classes.Aluno;

public class PrimeiraClasseJava {

	public static void main(String[] args) {
		
		Aluno aluno1 = new Aluno();
		Aluno aluno2 = new Aluno();
		
		Aluno aluno3 = new Aluno("Maria");
		
		aluno1.setNome("Wallace");
		aluno1.setDataNascimento("10/10/1983");
		aluno1.setNota1(90);
		aluno1.setNota2(80);
		aluno1.setNota3(70);
		aluno1.setNota4(85);
		
		System.out.println("O nome é: " + aluno1.getNome());
		System.out.println("A data de nascimento é: " + aluno1.getDataNascimento());
		System.out.println("A média da nota é: " + aluno1.getMediaNota());
		System.out.println("Resultado: " + (aluno1.getAlunoAprovado() ? "Aprovado" : "Reprovado"));
		
		

	}

}
