public class Main {
    public static void main(String[] args) {

        ContaBanco conta = new ContaBanco(12345, "cc", "João Brito");
        conta.abrirConta();

        ContaBanco cliente1 = new ContaBanco("Maria", "112");
        ContaBanco cliente2 = new ContaBanco("Carlos", "223");
        ContaBanco clienteNulo = null;

        conta.adicionarCliente(cliente1);
        conta.adicionarCliente(cliente2);
        conta.adicionarCliente(clienteNulo);


        conta.mostrarInfo();

        System.out.println("\nPrograma executado até o final.");
    }
}
