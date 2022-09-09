package cursojava.executavel;

import primeiro.jdev.Aluno;
import primeiro.jdev.Diretor;
import primeiro.jdev.Secretario;

public class TesteClassesFilhas {

	public static void main(String[] args) {

		Aluno aluno = new Aluno();

		aluno.setNome("Wallace");
		aluno.setDataMatricula("10/10/2020");
		aluno.setIdade(21);

		Diretor diretor = new Diretor();
		diretor.setNome("Matuda");
		diretor.setNumeroRG("1234567890");
		diretor.setTempoDirecao(3);
		diretor.setIdade(50);

		Secretario secretario = new Secretario();
		secretario.setNome("Rodrigo");
		secretario.setExperiencia("Administração");
		secretario.setNumeroRG("2468135790");
		secretario.setIdade(33);

		System.out.println("Nome do aluno: " + aluno.getNome() + "\nData da matrícula: " + aluno.getDataMatricula());
		System.out.println("\nNome do secretário: " + secretario.getNome() + "\nNúmero do RG: "
				+ secretario.getNumeroRG() + "\nExperiência: " + secretario.getExperiencia());
		System.out.println("\nNome do diretor: " + diretor.getNome() + "\nTempo de direção: " + diretor.getTempoDirecao()
				+ " anos\n");
		System.out.println(aluno.salario());
		System.out.println(secretario.salario());
		System.out.println(diretor.salario());
		
		// System.out.println(aluno.msgMaiorIdade());
		// System.out.println(secretario.maiorIdade());
		// System.out.println(diretor.maiorIdade());

	}

}
