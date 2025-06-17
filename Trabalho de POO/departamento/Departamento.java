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

    public void addFuncionario(Funcionario func){
        if (cont< MAX) {
            this.funcionarios[cont] = func;
            cont++;
        }else{
            System.out.println("Não é possivel adicionar funcionários neste departamento.");
        }
    }

    public double totalGasto(){
        double soma = 0;

        for (int i = 0; i< cont; i++){
            soma += funcionarios[i].calcularSalario();
        }
        return soma;
    }

    
    public void exibirFuncionarios(){        
        
        for (int i = 0; i < cont; i++) {
            if (funcionarios[i] != null) {
                funcionarios[i].exibirFuncionario();
            } else {
                System.out.println("Funcionário não existe (null)");
            }
        }
    }

    public void exibirGeralDepartamento(){

        System.out.println("Departamanto: " + this.nome);
        System.out.println("Codigo do departamanto: " + this.codigo);
        System.out.println("Numero de funcionarios: " + this.cont);
        System.out.println("funcionarios: ");
        this.exibirFuncionarios();
        System.out.println("Total gasto com salaio: " + this.totalGasto());
    
    }

    public void resumoDepartamento(){

        System.out.println("Departamanto: " + this.nome);
        System.out.println("Codigo do departamanto: " + this.codigo);
        System.out.println("Numero de funcionarios: " + this.cont);
        System.out.println("Total gasto com salaio: " + this.totalGasto());
    
    }

    public Funcionario buscarFuncByCod(String codigo){
        for (int i = 0; i < cont; i++) {
            if (funcionarios[i].getCodigo() == codigo) {
                return funcionarios[i];
            }
        }
        return null;
    }
    public Funcionario buscarFuncByNome(String nome){
        for (int i = 0; i < cont; i++) {
            if (funcionarios[i].getNome() == nome) {
                return funcionarios[i];
            }
        }
        return null;
    }
}
