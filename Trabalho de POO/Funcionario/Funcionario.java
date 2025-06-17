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

    public double calcularSalario() {

        double salarioadicionado = 0;

        switch (this.nivel) {
            case "t1", "T1":
            salarioadicionado = (this.salario)*(Auxiliar.t1);
            
            case "t2", "T2":
            salarioadicionado = (this.salario)*(Auxiliar.t2);

            case "d1", "D1":
            salarioadicionado = (this.salario)*(Auxiliar.d1);

            case "d2", "D2":
            salarioadicionado = (this.salario)*(Auxiliar.d2);

            case "d3", "D3":
            salarioadicionado = (this.salario)*(Auxiliar.d3);

            case "s1", "S1":
            salarioadicionado = (this.salario)*(Auxiliar.s1);

            case "s2", "S2":
            salarioadicionado = (this.salario)*(Auxiliar.s2);
        }

        return salarioadicionado;
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

    //metodos gerais

    public void exibirFuncionario(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Salário: " + this.calcularSalario());
        System.out.println("Nivel: " + this.nivel);
        System.out.println("\n");
    }
    

    
}
