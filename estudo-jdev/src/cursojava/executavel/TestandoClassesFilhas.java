package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Secretario;

public class TestandoClassesFilhas {

	public static void main(String[] args) {

		Aluno aluno = new Aluno();

		aluno.setNome("Wallace");
		aluno.setIdade(38);
		aluno.setNomeEscola("NOC FAT");
		aluno.setIdade(17);
		
		Diretor diretor = new Diretor();

		diretor.setNome("Rudson");
		diretor.setTempoDirecao(2);
		diretor.setIdade(38);
		
		Secretario secretario = new Secretario();
		
		secretario.setNome("Michel");
		secretario.setExperiencia("Boa!");
		secretario.setIdade(29);
		
		System.out.println(aluno.getNome() + " - " + aluno.pessoaMaiorIdade()
		+ " - " + aluno.msgMaiorIdade());
		
		System.out.println(diretor.getNome() + " - " +  diretor.pessoaMaiorIdade());
		
		System.out.println(secretario.getNome() + " - " +  secretario.pessoaMaiorIdade());
		
		
		
	}

}
