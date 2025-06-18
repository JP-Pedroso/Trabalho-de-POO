package src;

import Funcionario.*;
import Universidade.Universidade;
import departamento.Departamento;

public class SistemaUniversidadeController {
    private Universidade universidade;
    
    public SistemaUniversidadeController() {
        this.universidade = new Universidade("FCT/UNESP - Presidente Prudente");
    }

    
    
    // Métodos para gerenciar departamentos
    public boolean adicionarDepartamento(String codigo, String nome) {
        try {
            Departamento dept = new Departamento(codigo, nome);
            universidade.addDepartamento(dept);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    // Métodos para gerenciar funcionários
    public boolean adicionarTecnico(String codigoDept, String codigo, String nome, 
                                   double salario, String nivel, String funcao) {
        try {
            Departamento dept = universidade.buscarDepartamento(codigoDept);
            if (dept != null) {
                Tecnico tecnico = new Tecnico(codigo, nome, salario, nivel, funcao);
                dept.addFuncionario(tecnico);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean adicionarDocenteEfetivo(String codigoDept, String codigo, String nome, 
                                          double salario, String nivel, String titulacao, String area) {
        try {
            Departamento dept = universidade.buscarDepartamento(codigoDept);
            if (dept != null) {
                Efetivo efetivo = new Efetivo(codigo, nome, salario, nivel, titulacao, area);
                dept.addFuncionario(efetivo);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean adicionarDocenteSubstituto(String codigoDept, String codigo, String nome, 
                                             double salario, String nivel, String titulacao, int cargaHoraria) {
        try {
            Departamento dept = universidade.buscarDepartamento(codigoDept);
            if (dept != null) {
                Substituto substituto = new Substituto(codigo, nome, salario, nivel, titulacao, cargaHoraria);
                dept.addFuncionario(substituto);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    // Métodos para relatórios
    public String gerarRelatorioGeral() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== RELATÓRIO GERAL ===\n");
        sb.append("Universidade: ").append(universidade.getNome()).append("\n\n");
        
        // Implementar captura da saída do método geral()
        return sb.toString();
    }
    
    public String gerarResumoDepartamentos() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== RESUMO DOS DEPARTAMENTOS ===\n");
        // Implementar lógica para resumo
        return sb.toString();
    }
    
    public String gerarResumoDepartamentosPorFaixa(double valorMin, double valorMax) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== DEPARTAMENTOS COM GASTO ENTRE R$ ").append(valorMin)
          .append(" E R$ ").append(valorMax).append(" ===\n");
        // Usar método existente resumoDepEntre
        return sb.toString();
    }
    
    public String gerarFuncionariosPorFaixaSalarial(double salarioMin, double salarioMax) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== FUNCIONÁRIOS COM SALÁRIO ENTRE R$ ").append(salarioMin)
          .append(" E R$ ").append(salarioMax).append(" ===\n");
        // Usar método existente funcionarioEntre
        return sb.toString();
    }
    
    public String gerarRelatorioTodosFuncionarios() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== TODOS OS FUNCIONÁRIOS ===\n");
        // Usar método existente exibirTodosFunc
        return sb.toString();
    }
    
    public String gerarRelatorioTecnicos() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== TODOS OS TÉCNICOS ===\n");
        // Usar método existente exibirTecnicos
        return sb.toString();
    }
    
    public String gerarRelatorioDocentes() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== TODOS OS DOCENTES ===\n");
        // Usar método existente exibirDocentes
        return sb.toString();
    }
    
    public String gerarRelatorioDocentesEfetivos() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== DOCENTES EFETIVOS ===\n");
        // Usar método existente exibirDocentesEfetivos
        return sb.toString();
    }
    
    public String gerarRelatorioDocentesSubstitutos() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== DOCENTES SUBSTITUTOS ===\n");
        // Usar método existente exibirDocentesSubstitutos
        return sb.toString();
    }
    
    public String buscarFuncionarioPorCodigo(String codigo) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== BUSCA POR CÓDIGO: ").append(codigo).append(" ===\n");
        // Usar método existente exibirFuncByCod
        return sb.toString();
    }
    
    public String buscarFuncionarioPorNome(String nome) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== BUSCA POR NOME: ").append(nome).append(" ===\n");
        // Usar método existente exibirFuncByNome
        return sb.toString();
    }
    
    public String exibirInformacoesDepartamento(String codigo) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== INFORMAÇÕES DO DEPARTAMENTO ===\n");
        // Usar método existente exibirInfoDepartamento
        return sb.toString();
    }
    
    // Métodos utilitários
    public String[] getFuncoesTecnico() {
        return new String[]{"Assessor", "Laboratório", "Secretário"};
    }
    
    public String[] getTitulacoes() {
        return new String[]{"Graduação", "Mestrado", "Doutorado", "Livre-Docente", "Titular"};
    }
    
    public String[] getAreas() {
        return new String[]{"Biológicas", "Exatas", "Humanas", "Saúde"};
    }
    
    public String[] getNiveisTecnico() {
        return new String[]{"T1", "T2"};
    }
    
    public String[] getNiveisDocente() {
        return new String[]{"D1", "D2", "D3"};
    }
    
    public String[] getNiveisSubstituto() {
        return new String[]{"S1", "S2"};
    }
    
    public Integer[] getCargasHorarias() {
        return new Integer[]{12, 24};
    }
    
    public Universidade getUniversidade() {
        return universidade;
    }



    public void setUniversidade(Universidade universidade) {
        this.universidade = universidade;
    }
}