public abstract class Funcionario {

    protected String codigo;
    protected String nome;
    protected double salario;
    protected String nivel;


    public Funcionario (String codigo, String nome, double salario, String nivel){
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario;
        this.nivel= nivel;
    }

    public abstract double calcularSalario();

    public String getCodigo(){
    }
}
