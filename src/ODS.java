public class ODS extends Documento {
    
    @Override
    public void processarDoc(){
        System.out.printf("Processando ODS: %s.%s\n", this.getNome(), this.getTipo());
    }

    ODS(String nome){
        this.nome = setNome(nome);
        this.tipo = "ODS";
        Documentos.add(this);
    }

}
