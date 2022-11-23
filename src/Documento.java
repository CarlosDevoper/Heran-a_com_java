import java.util.ArrayList;

public class Documento {
    protected String nome;
    protected String tipo;
    public static ArrayList<Documento> Documentos = new ArrayList<>();
    
    public String getNome(){
        return nome;
    }

    public String setNome(String nome){
        this.nome = nome;
        return nome;
    }

    public String getTipo(){
        return tipo;
    }

    public String setTipo(String tipo){
        this.tipo = tipo;
        return tipo;
    }
    public void processarDoc(){
        System.out.println("Processando documento");
    }

    public static void listarDocumentos(){
        int n = Documentos.size();
        int v = 1;
        System.out.printf("%-7s|%-15s|%-12s\n", "ID","Nome"," Tipo");
        for(int i = 0; i<n; i++ ){
            System.out.printf("%06d |%-15s| %s\n",v, Documentos.get(i).nome, Documentos.get(i).tipo);
            v++;
        }
    }
}
