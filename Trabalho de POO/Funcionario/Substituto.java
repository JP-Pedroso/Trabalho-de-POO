public class Substituto extends Docente{

    private int cargahoraria;

    public Substituto(String codigo, String nome, double salario, String nivel, String titulaçao, int cargahoraria) {
        super(codigo, nome, salario, nivel, titulaçao);
        this.cargahoraria = cargahoraria;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }
    
    

}
