public class Conta {
    
    private int numero;
    private double saldo;
    private double limite;
    private double[] extrato;
    private int operacoesRealizadas;
    private static final int max_op = 10;

    public Conta(int numero, double saldoInicial){
        this.numero = numero;
        this.saldo = saldoInicial + limite;
        this.limite = 100;
        this.extrato = new double[max_op];
        this.operacoesRealizadas = 0;
    }
    public double getSaldo() {
        return this.saldo + this.limite;
    }

    public void saldoConta(){
        this.saldo = saldo + limite;
    }
    public boolean sacar(double saque){

        if (operacoesRealizadas >= max_op) {
            System.out.println("Limite de operações atingido!");
            return false;
        }

        if(saque <= 0){
            
            System.out.println("Não é possível sacar valores negativos ou iguais a zero!");
            return false;

        }
        if(saque > getSaldo()){
            System.out.println("Saldo insuficiente!");
            return false;
        }

        saldo = saldo - saque;
        registrarOperacao(-saque);
        System.out.println("Saque efetuado com sucesso!");
        return true;

    }
    public boolean depositar(double deposito){

        if (operacoesRealizadas >= max_op) {
            System.out.println("Limite de operações atingido.");
            return false;
        }
        if (deposito <= 0) {
            System.out.println("Erro! insira um valor positivo.");
            return false;
        }
        saldo = saldo + deposito;
            registrarOperacao(deposito);
            System.out.println("Depósito realizado com sucesso!");
            return true;

        }
    
        public boolean transferir(double valort, Conta destino){
            if (operacoesRealizadas >= max_op) {
                System.out.println("Limite de operações atingido!");
                return false;
            }
            if (valort <= 0) {
                System.out.println("Erro! valor negativo ou zero.");
                return false;
            }
            if (valort > getSaldo()) {
                System.out.println("Saldo insuficiente!");
                return false;
            }
        
            saldo = saldo - valort;
            registrarOperacao(-valort);  // Registrar a retirada na conta de origem
            destino.depositar(valort);    // Depositar o valor na conta de destino
            destino.registrarOperacao(valort);  // Registrar o depósito na conta de destino
        
            System.out.println("Transferência efetuada com sucesso para a conta " + destino.numero);
            return true;
        }
        
        

        public double[] verExtrato(){
            return extrato.clone();
        }

        @Override
        public String toString(){
            return "Conta " + numero + ": Saldo disponível = " + saldo + ", Limite = " + limite + ", Saldo Total = " + getSaldo();
        }

        private void registrarOperacao(double val){
            if (operacoesRealizadas < max_op) {
                extrato[operacoesRealizadas] = val;
                operacoesRealizadas++;
                
            }else {
                System.out.println("Lotado!");
            }
        }

    }
    
