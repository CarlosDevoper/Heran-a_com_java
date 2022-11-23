import java.io.IOException;
import java.util.Scanner;

public class App {
    
    public static void limparTela() throws IOException, InterruptedException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
    public static void main(String[] args) throws Exception {
        
        // inserir alguns objetos para ter algo para aparecer na hora de lista
        PDF doc1 = new PDF("Documento1");
        ODS doc2 = new ODS("TrabalhoFinal");
        DOC doc3 = new DOC("TrabalhoFinal2");

        Scanner scan = new Scanner(System.in);
		int opcaoMenu = 0;

        // laço de repetição para aparecer o menu, o menu aparecer o menu
        do {
			limparTela();
			menuPincipal();
			opcaoMenu = lerOpcaoMenu(scan);
			
			if(!processarOpcaoMenu(scan, opcaoMenu)){
				System.out.println("Opção inválida. Tente novamente");
				Thread.sleep(2000);

			}

		} while (opcaoMenu != 4);
		scan.close();
    }


    /*  esse método processa a opção escolhida pelo usuário no menu
    e encaminha para os respequitivos métodos
    */
    private static boolean processarOpcaoMenu(Scanner scan, int opcaoMenu) throws IOException, InterruptedException {
        switch (opcaoMenu){
			case 1:
				mostrarDocumentos();
				return true;
			case 2:
				inserirDoc(scan);
				return true;
			case 3:
				processarDoc(scan);
				return true;

            case 4:
                sairDoPrograma();
                return true;
			default:
			return false;	
		}
    }

    /* 
    método que processa um documento escolhido na lista
    de documentos ja inseridos no programa
     */

    private static void processarDoc(Scanner scan) throws IOException, InterruptedException {
        limparTela();
		System.out.println("PROCESSAR DOCUMENTO");
		System.out.println("-------------------");
        System.out.println("Digite o ID do documento que queira processar");
		System.out.print(">> ID:");
		String IDStr = scan.nextLine();
        int ID = Integer.parseInt(IDStr);
        limparTela();
        int teste = Documento.Documentos.size();

        if(ID < teste | ID > teste ){
            System.out.println("ID não existente!");
            System.out.print(">> Pressione ENTER para voltar ao menu...");
            System.in.read();
            
        } else{
            System.out.println("Aguarde...");
            Thread.sleep(2000);
            Documento.Documentos.get(ID).processarDoc();
            Thread.sleep(2000);
            System.out.println("Documento Processado com sucesso!");
            System.out.print(">> Pressione ENTER para voltar ao menu...");
            System.in.read();
        }
    }

    /* 
    método que encessa o programa, pois ao selecionar a opção você
    sai do laço de repetição que mostra o menu
    */
    private static void sairDoPrograma() throws InterruptedException, IOException {
        limparTela();
        System.out.println("Saindo do Programa...");
		Thread.sleep(1000);
		limparTela();

    }


    /*
    esse método insere um documento ao array de
    objetos criado na classe Documento,java 

     */
    private static void inserirDoc(Scanner scan) throws IOException, InterruptedException {
        limparTela();
		System.out.println("INSERIR DOCUMENTO");
		System.out.println("-----------------");
		System.out.print(">> Nome:");
		String name = scan.nextLine();
		System.out.print(">> Tipo:");
		String tipo = scan.nextLine();
        tipo = tipo.toUpperCase();
        if (tipo.equals("PDF")){
            PDF doc = new PDF(name);
            validarInsercao();
        }else if (tipo.equals("ODS")){
            ODS doc = new ODS(name);
            validarInsercao();
        }else if (tipo.equals("DOC")){
            DOC doc = new DOC(name);
            validarInsercao();
        }else{
            limparTela();
            System.out.println("Opção de documento inválida");
            Thread.sleep(300);
            System.out.print(">> Pressione ENTER para voltar ao menu...");
            System.in.read();
        }
    }

    /*
    esse método eu criei apenas para evitar
    repetição de código no laço de repetição 
    que fiz para inseir um novo documento
     */
    public static void validarInsercao() throws IOException, InterruptedException{
        limparTela();
		System.out.println("Inserindo Documento...");
        Thread.sleep(3000);
        System.out.println("Documento Cadastrado com sucesso!");
		System.out.print(">> Pressione ENTER para voltar ao menu...");
        System.in.read();
    }

    /*
    método para mostrar todos os documentos do array
    que utiliza o mpetodo da classe documentos de listar
    arrays
     */
    private static void mostrarDocumentos() throws IOException, InterruptedException {
        limparTela();
		System.out.println("    DOCUMENTOS PROCESSADOS");
		System.out.println("------------------------------");
		Documento.listarDocumentos();
		System.out.println("------------------------------");
		System.out.print(">> Pressione ENTER para voltar ao menu...");
		System.in.read();

    }

    /*
    método auxiliar que le a opção do menu
    e é passado como argumento para o método de
    processarOpcaoMenu
     */

    private static int lerOpcaoMenu(Scanner scan) {
        System.out.print(">> Opção desejada: ");
		int opcaoEscolhida = scan.nextInt();
		scan.nextLine();
		return opcaoEscolhida;
    }

    /*
    método que mostra o menu principal na tela
     */
    private static void menuPincipal() {
        System.out.println("---------------------------------");
		System.out.println("          DOCUMENTOS");
		System.out.println("---------------------------------");
		System.out.println("1 - Listar Documentos Processados");
		System.out.println("2 - Inserir Documento");
        System.out.println("3 - Processar Documento");
		System.out.println("4 - Sair do Programa");
		System.out.println("---------------------------------");

    }
}
