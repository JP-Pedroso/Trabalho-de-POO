package Funcionario;

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

    //Getter

    public String getCodigo(){
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public String getNivel() {
        return nivel;
    }

    //Setters

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    

    
}
