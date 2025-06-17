import departamento.*;
import Funcionario.*;
import Universidade.Universidade;

public class App {
    public static void main(String[] args){

        Universidade u = new Universidade("unesp");

        Funcionario a = new Substituto("123", "Joao", 1000, "T1","bio", 12);

        Departamento d = new Departamento("321", "aulas");

        
        
        d.addFuncionario(a);
        u.addDepartamento(d);
        u.resumoDepEntre(1000, 2000);
        




    }
}
