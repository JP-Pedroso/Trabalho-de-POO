package Funcionario;

public class Efetivo extends Docente {

    private String area;

    public Efetivo(String codigo, String nome, double salario, String nivel, String titulaçao, String area) {
        super(codigo, nome, salario, nivel, titulaçao);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String exibirFuncionario() {
        return "Nome: " + this.nome + "\n" +
               "Código: " + this.codigo + "\n" +
               "Salário: " + this.calcularSalario() + "\n" +
               "Nível: " + this.nivel + "\n" +
               "Titulação: " + this.titulaçao + "\n" +
               "Área: " + this.area + "\n\n";
    }
}