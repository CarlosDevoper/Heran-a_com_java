public class DOC extends Documento{
    
    @Override
    public void processarDoc(){
        System.out.printf("Processando DOC: %s.%s\n", this.getNome(), this.getTipo());
    }

    DOC(String nome){
        this.nome = setNome(nome);
        this.tipo = "DOC";
        Documentos.add(this);
    }

}
