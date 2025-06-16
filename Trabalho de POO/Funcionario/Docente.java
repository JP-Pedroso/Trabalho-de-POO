package Funcionario;


public abstract class Docente extends Funcionario {

    protected String titulaçao;

    public Docente(String codigo, String nome, double salario, String nivel, String titulaçao) {
        super(codigo, nome, salario, nivel);
        this.titulaçao = titulaçao;
    }

    public String getTitulaçao() {
        return titulaçao;
    }

    public void setTitulaçao(String titulaçao) {
        this.titulaçao = titulaçao;
    }

       

}
