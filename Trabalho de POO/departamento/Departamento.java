package departamento;

import Funcionario.*;

public class Departamento {

    private String codigo;
    private String nome;
    private int cont;
    private final int MAX = 7;
    private Funcionario[] funcionarios;
    

    public Departamento(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.cont = 0;
        this.funcionarios = new Funcionario[MAX];
    }

    // Getters (mantidos iguais)
    public Funcionario[] getFuncionarios() {
        return funcionarios;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCont() {
        return this.cont;
    }

    public void addFuncionario(Funcionario func) {
        if (cont < MAX) {
            this.funcionarios[cont] = func;
            cont++;
        } else {
            System.out.println("Não é possível adicionar funcionários neste departamento.");
        }
    }

    public double totalGasto() {
        double soma = 0;
        for (int i = 0; i < cont; i++) {
            soma += funcionarios[i].calcularSalario();
        }
        return soma;
    }

    public String exibirFuncionarios() {
        String resultado = "";
        for (int i = 0; i < cont; i++) {
            if (funcionarios[i] != null) {
                resultado += funcionarios[i].exibirFuncionario();
            } else {
                resultado += "Funcionário não existe (null)\n";
            }
        }
        return resultado;
    }

            public String exibirGeralDepartamento() {
            return "Departamento: " + this.nome + "\n" +
           "Código do departamento: " + this.codigo + "\n" +
           "Número de funcionários: " + this.cont + "\n" +
           "Total gasto com salário: " + String.format("R$%,.2f", this.totalGasto()) + "\n" +
           "\nFuncionários:\n" + this.exibirFuncionarios();
}

            public String resumoDepartamento() {
            return "Departamento: " + this.nome + "\n" +
           "Código do departamento: " + this.codigo + "\n" +
           "Número de funcionários: " + this.cont + "\n" +
           "Total gasto com salário: " + String.format("R$%,.2f", this.totalGasto()) + "\n";
}
    public Funcionario buscarFuncByCod(String codigo) {
        for (int i = 0; i < cont; i++) {
            if (funcionarios[i].getCodigo().equals(codigo)) {
                return funcionarios[i];
            }
        }
        return null;
    }

    public Funcionario buscarFuncByNome(String nome) {
        for (int i = 0; i < cont; i++) {
            if (funcionarios[i].getNome().equals(nome)) {
                return funcionarios[i];
            }
        }
        return null;
    }
}