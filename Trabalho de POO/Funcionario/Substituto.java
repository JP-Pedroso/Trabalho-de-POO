package Funcionario;

public class Substituto extends Docente {

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
    public String exibirFuncionario() {
        return "Nome: " + this.nome + "\n" +
               "Código: " + this.codigo + "\n" +
               "Salário: " + this.calcularSalario() + "\n" +
               "Nível: " + this.nivel + "\n" +
               "Titulação: " + this.titulaçao + "\n" +
               "Carga Horária: " + this.cargahoraria + "\n\n";
    }
}