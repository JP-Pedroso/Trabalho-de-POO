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


    public void geral(){
        System.out.println("Universidade: "+ this.nome);
        for (int i = 0; i < contDep; i++) {
            departamentos[i].exibirGeralDepartamento();
        }
    }

    public void resumoDepEntre(int inicio, int fim){
        for (int i = 0; i < contDep; i++) {
            
            if (departamentos[i].totalGasto() >= inicio && departamentos[i].totalGasto() <= fim ) {
                departamentos[i].resumoDepartamento();                
            }

        }
    }

    public void funcionarioEntre(int inicio, int fim){
        for (int i = 0; i < contDep; i++) {

            if (departamentos[i] != null) {
                
                for (int j=0; j < departamentos[i].getCont(); j++) {
                    
                    if (departamentos[i].getFuncionarios()[j].calcularSalario() >= inicio && departamentos[i].getFuncionarios()[j].calcularSalario() <= fim ) {
    
                        departamentos[i].getFuncionarios()[j].exibirFuncionario();
                        
                    }           
                } 
            }
            
        }
    }

    public void exibirTodosFunc(){

        for (int i = 0; i < contDep; i++) {
            departamentos[i].exibirFuncionarios();
        }
    }

    public void exibirTecnicos(){
        for (int i = 0; i < contDep; i++) {

            if (departamentos[i] != null) {
                
                for (int j=0; j < departamentos[i].getCont(); j++) {
                    
                    if (departamentos[i].getFuncionarios()[j] instanceof Tecnico) {
    
                        departamentos[i].getFuncionarios()[j].exibirFuncionario();
                        
                    }           
                } 
            }
            
        }
    }

    public void exibirDocentes(){
        for (int i = 0; i < contDep; i++) {

            if (departamentos[i] != null) {
                
                for (int j=0; j < departamentos[i].getCont(); j++) {
                    
                    if (departamentos[i].getFuncionarios()[j] instanceof Docente) {
    
                        departamentos[i].getFuncionarios()[j].exibirFuncionario();
                        
                    }           
                } 
            }
            
        }
    }

    public void exibirDocentesEfetivos(){
        for (int i = 0; i < contDep; i++) {

            if (departamentos[i] != null) {
                
                for (int j=0; j < departamentos[i].getCont(); j++) {
                    
                    if (departamentos[i].getFuncionarios()[j] instanceof Efetivo) {
    
                        departamentos[i].getFuncionarios()[j].exibirFuncionario();
                        
                    }           
                } 
            }
            
        }
    }

    public void exibirDocentesSubstitutos(){
        for (int i = 0; i < contDep; i++) {

            if (departamentos[i] != null) {
                
                for (int j=0; j < departamentos[i].getCont(); j++) {
                    
                    if (departamentos[i].getFuncionarios()[j] instanceof Substituto) {
    
                        departamentos[i].getFuncionarios()[j].exibirFuncionario();
                        
                    }           
                } 
            }
            
        }
    }

    
    
    public void addDepartamento(Departamento dep){

        if (contDep< MAX) {
            this.departamentos[contDep] = dep;
            contDep++;
        }else{
            System.out.println("Não é possivel adicionar mais departamentos neste universidade.");
        }

    }

    public void exibirFuncByCod(String codigo){

        for (int i = 0; i < contDep; i++) {

            if(departamentos[i].buscarFuncByCod(codigo) != null){
                departamentos[i].buscarFuncByCod(codigo).exibirFuncionario();
            }
        }
    }
    public void exibirFuncByNome(String nome){

        for (int i = 0; i < contDep; i++) {

            if(departamentos[i].buscarFuncByNome(nome) != null){
                departamentos[i].buscarFuncByNome(nome).exibirFuncionario();
            }
        }
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
    
    public void exibirInfoDepartamento(String codigo){

        for (int i = 0; i < contDep; i++) {
            if (departamentos[i].getCodigo() == codigo) {

                this.buscarDepartamento(codigo).exibirGeralDepartamento();
                
            }
        }
    }

    



}
