package Funcionario;

public abstract class Funcionario {

    protected String codigo;
    protected String nome;
    protected double salario;
    protected String nivel;

    public Funcionario(String codigo, String nome, double salario, String nivel) {
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario;
        this.nivel = nivel;
    }

    // Getters
    public String getCodigo() {
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

    // Setters
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

    // Métodos
    public double calcularSalario() {
        double salarioCalculado = this.salario;

        switch (this.nivel.toUpperCase()) {
            case "T1":
                salarioCalculado *= Auxiliar.t1;
                break;
            case "T2":
                salarioCalculado *= Auxiliar.t2;
                break;
            case "D1":
                salarioCalculado *= Auxiliar.d1;
                break;
            case "D2":
                salarioCalculado *= Auxiliar.d2;
                break;
            case "D3":
                salarioCalculado *= Auxiliar.d3;
                break;
            case "S1":
                salarioCalculado *= Auxiliar.s1;
                break;
            case "S2":
                salarioCalculado *= Auxiliar.s2;
                break;
        }

        return salarioCalculado;
    }

    public abstract String exibirFuncionario();

protected String formatarDadosBasicos() {
    return "Nome: " + this.nome + "\n" +
           "Código: " + this.codigo + "\n" +
           "Salário: " + String.format("%.2f", this.calcularSalario()) + "\n" +
           "Nível: " + this.nivel + "\n";
}
}