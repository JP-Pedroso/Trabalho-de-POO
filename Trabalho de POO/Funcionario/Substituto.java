package Funcionario;

public class Substituto extends Docente{

    private int cargahoraria;

    public Substituto(String codigo, String nome, double salario, String nivel, String titulaçao, int cargahoraria) {
        super(codigo, nome, salario, nivel, titulaçao);
        this.cargahoraria = cargahoraria;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }


    @Override
    public void exibirFuncionario(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Salário: " + this.calcularSalario());
        System.out.println("Nivel: " + this.nivel);
        System.out.println("Titulação: " + this.titulaçao);
        System.out.println("Carga Horária: " + this.cargahoraria);
        System.out.println("\n");
    }


    

}
