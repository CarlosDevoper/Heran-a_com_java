public class PDF extends Documento {



    @Override
    public void processarDoc(){
        System.out.printf("Processando PDF: %s.%s\n", this.getNome(), this.getTipo());
    }

    PDF(String nome){
        this.nome = setNome(nome);
        this.tipo = "PDF";
        Documentos.add(this);
    }
}

