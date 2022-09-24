package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Secretario;

public class TestandoClassesFilhas {

	public static void main(String[] args) {

		Aluno aluno = new Aluno();

		aluno.setNome("Wallace");
		aluno.setIdade(38);
		aluno.setNomeEscola("JDev treinamento");

		Diretor diretor = new Diretor();

		diretor.setNome("Rudson");
		diretor.setTempoDirecao(2);

		Secretario secretario = new Secretario();
		
		secretario.setNome("Michel");
		secretario.setExperiencia("Boa!");
		
		System.out.println(aluno);
		System.out.println(diretor.getNome());
		System.out.println(secretario.getNome());
	}

}
