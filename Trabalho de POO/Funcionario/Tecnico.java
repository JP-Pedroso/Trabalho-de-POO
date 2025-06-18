package Funcionario;

public class Tecnico extends Funcionario {

    private String funcao;

        public Tecnico(String codigo, String nome, double salario, String nivel, String funcao) {
        super(codigo, nome, salario, nivel);
        this.funcao = funcao;
    }

@Override
        public String exibirFuncionario() {
        return String.format(
        "Nome: %s\nCódigo: %s\nSalário: R$%,.2f\nNível: %s\nFunção: %s\n\n",
        this.nome,
        this.codigo,
        this.calcularSalario(),
        this.nivel,
        this.funcao
    );
}

    }


