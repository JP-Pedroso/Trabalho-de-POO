package Universidade;

import Funcionario.Docente;
import Funcionario.Efetivo;
import Funcionario.Substituto;
import Funcionario.Tecnico;
import departamento.*;

public class Universidade {

    private String nome;
    private int contDep;
    private int MAX;
    private Departamento[] departamentos;

    public Universidade(String nome) {
        this.nome = nome;
        this.contDep = 0;
        this.MAX = 7;
        this.departamentos = new Departamento[MAX];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getContDep() {
        return contDep;
    }

    public Departamento[] getDepartamentos() {
        return departamentos;
    }

    public String geral() {
        String resultado = "\n\n";
        for (int i = 0; i < contDep; i++) {
            if (departamentos[i] != null) {
                resultado += departamentos[i].exibirGeralDepartamento() + "\n";
            }
        }
        return resultado;
    }

    public String resumoDepartamento(){

        String resultado = "";
        for (int i = 0; i < contDep; i++) {
            if (departamentos[i] != null){
                resultado += departamentos[i].resumoDepartamento() + "\n";
            }
        }
        return resultado;


    }

    public String resumoDepEntre(double inicio, double fim) {
        String resultado = "";
        for (int i = 0; i < contDep; i++) {
            if (departamentos[i] != null && 
                departamentos[i].totalGasto() >= inicio && 
                departamentos[i].totalGasto() <= fim) {
                resultado += departamentos[i].resumoDepartamento() + "\n";
            }
        }
        return resultado;
    }

    public String funcionarioEntre(double inicio, double fim) {
        String resultado = "";
        for (int i = 0; i < contDep; i++) {
            if (departamentos[i] != null) {
                for (int j = 0; j < departamentos[i].getCont(); j++) {
                    if (departamentos[i].getFuncionarios()[j] != null &&
                        departamentos[i].getFuncionarios()[j].calcularSalario() >= inicio && 
                        departamentos[i].getFuncionarios()[j].calcularSalario() <= fim) {
                        resultado += departamentos[i].getFuncionarios()[j].exibirFuncionario();
                    }
                }
            }
        }
        return resultado;
    }

    public String exibirTodosFunc() {
        String resultado = "";
        for (int i = 0; i < contDep; i++) {
            if (departamentos[i] != null) {
                resultado += departamentos[i].exibirFuncionarios();
            }
        }
        return resultado;
    }

    public String exibirTecnicos() {
        String resultado = "";
        for (int i = 0; i < contDep; i++) {
            if (departamentos[i] != null) {
                for (int j = 0; j < departamentos[i].getCont(); j++) {
                    if (departamentos[i].getFuncionarios()[j] instanceof Tecnico) {
                        resultado += departamentos[i].getFuncionarios()[j].exibirFuncionario();
                    }
                }
            }
        }
        return resultado;
    }

    public String exibirDocentes() {
        String resultado = "";
        for (int i = 0; i < contDep; i++) {
            if (departamentos[i] != null) {
                for (int j = 0; j < departamentos[i].getCont(); j++) {
                    if (departamentos[i].getFuncionarios()[j] instanceof Docente) {
                        resultado += departamentos[i].getFuncionarios()[j].exibirFuncionario();
                    }
                }
            }
        }
        return resultado;
    }

    public String exibirDocentesEfetivos() {
        String resultado = "";
        for (int i = 0; i < contDep; i++) {
            if (departamentos[i] != null) {
                for (int j = 0; j < departamentos[i].getCont(); j++) {
                    if (departamentos[i].getFuncionarios()[j] instanceof Efetivo) {
                        resultado += departamentos[i].getFuncionarios()[j].exibirFuncionario();
                    }
                }
            }
        }
        return resultado;
    }

    public String exibirDocentesSubstitutos() {
        String resultado = "";
        for (int i = 0; i < contDep; i++) {
            if (departamentos[i] != null) {
                for (int j = 0; j < departamentos[i].getCont(); j++) {
                    if (departamentos[i].getFuncionarios()[j] instanceof Substituto) {
                        resultado += departamentos[i].getFuncionarios()[j].exibirFuncionario();
                    }
                }
            }
        }
        return resultado;
    }

    public void addDepartamento(Departamento dep) {
        if (contDep < MAX) {
            this.departamentos[contDep] = dep;
            contDep++;
        } else {
            System.out.println("Não é possível adicionar mais departamentos nesta universidade.");
        }
    }

    public String exibirFuncByCod(String codigo) {
        String resultado = "";
        for (int i = 0; i < contDep; i++) {
            if (departamentos[i] != null && departamentos[i].buscarFuncByCod(codigo) != null) {
                resultado += departamentos[i].buscarFuncByCod(codigo).exibirFuncionario();
            }
        }
        return resultado;
    }

    public String exibirFuncByNome(String nome) {
        String resultado = "";
        for (int i = 0; i < contDep; i++) {
            if (departamentos[i] != null && departamentos[i].buscarFuncByNome(nome) != null) {
                resultado += departamentos[i].buscarFuncByNome(nome).exibirFuncionario();
            }
        }
        return resultado;
    }

    public Departamento buscarDepartamento(String codigo) {
        if (codigo == null || departamentos == null) {
            return null;
        }
        String codigoBusca = codigo.trim();
        for (int i = 0; i < departamentos.length; i++) {
            if (departamentos[i] != null && 
                departamentos[i].getCodigo().trim().equalsIgnoreCase(codigoBusca)) {
                return departamentos[i];
            }
        }
        return null;
    }

    public String exibirInfoDepartamento(String codigo) {
        Departamento dep = buscarDepartamento(codigo);
        if (dep != null) {
            return dep.exibirGeralDepartamento();
        }
        return "Departamento não encontrado";
    }
}