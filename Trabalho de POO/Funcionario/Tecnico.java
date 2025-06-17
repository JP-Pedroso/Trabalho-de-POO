package Funcionario;

public class Tecnico extends Funcionario {

    private String funcao;

        public Tecnico(String codigo, String nome, double salario, String nivel, String funcao) {
        super(codigo, nome, salario, nivel);
        this.funcao = funcao;
    }

    @Override
    public void exibirFuncionario(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Salário: " + this.calcularSalario());
        System.out.println("Nivel: " + this.nivel);
        System.out.println("Funcao: " + this.funcao);
        System.out.println("\n");


    }

}
