import java.util.HashSet;

public class ContaBanco {

    private int numConta;
    private String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    private float limite;

    private HashSet<ContaBanco> clientes;

    public ContaBanco(int numConta, String tipo, String dono) {
        this.numConta = numConta;
        this.tipo = tipo;
        this.dono = dono;
        this.saldo = 0f;
        this.status = false;
        this.limite = 0f;
        this.clientes = new HashSet<>();
    }

    public ContaBanco(String dono, String cpfOuId) {
        this.dono = dono;
        this.tipo = "cliente"; // só para controle
        this.numConta = -1; // sem número de conta
        this.saldo = 0f;
        this.status = false;
        this.limite = 0f;
    }

    public void abrirConta() {
        if (!this.status) {
            this.status = true;
            if (this.tipo.equals("cc")) {
                this.saldo = 50f;
                this.limite = 200f;
            } else if (this.tipo.equals("cp")) {
                this.saldo = 150f;
                this.limite = 500f;
            } else {
                System.out.println("Tipo de conta inválido.");
                this.status = false;
            }
        }
    }

    public void adicionarCliente(ContaBanco cliente) {
        if (this.clientes != null) {
            this.clientes.add(cliente);
        }
    }

    public void mostrarInfo() {
        System.out.println("\n=== INFORMAÇÕES DA CONTA ===");
        System.out.println("Número da Conta: " + numConta);
        System.out.println("Tipo: " + tipo);
        System.out.println("Dono: " + dono);
        System.out.println("Saldo: R$" + saldo);
        System.out.println("Limite: R$" + limite);
        System.out.println("Status: " + (status ? "Ativa" : "Inativa"));

        if (clientes != null) {
            System.out.println("\n--- CLIENTES ASSOCIADOS ---");
            for (ContaBanco c : clientes) {
                try {
                    System.out.println("Nome: " + c.dono);
                } catch (NullPointerException e) {
                    System.out.println("Cliente nulo encontrado.");
                }
            }
        }
    }
}
