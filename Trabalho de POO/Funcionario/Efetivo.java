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
    public void exibirFuncionario(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Salário: " + this.calcularSalario());
        System.out.println("Nivel: " + this.nivel);
        System.out.println("Titulaçao: " + this.titulaçao);
        System.out.println("Area: " + this.area);
        System.out.println("\n");

    }

    

}
