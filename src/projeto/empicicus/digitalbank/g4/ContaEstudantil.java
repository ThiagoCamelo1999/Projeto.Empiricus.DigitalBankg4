package projeto.empicicus.digitalbank.g4;


//Felipe Morilho de Castro

public class ContaEstudantil extends Conta {
	
	private float limiteEstudantil = 5000;
	
	//Construtor
	public ContaEstudantil(int numero, String cpf) {
		super(numero, cpf);

	}

	//Métodos
	public void usarEstudantil (float valorSolicitado) {
		if (valorSolicitado > 0 && valorSolicitado <= 5000) {
			this.setSaldo(this.getSaldo()+ valorSolicitado);
			limiteEstudantil -= valorSolicitado;
			System.out.println("PARABÉNS!!! Você acaba de pegar R$" + valorSolicitado + " emprestados.");
			System.out.println("Seu novo saldo: " + this.getSaldo());
			if (limiteEstudantil > 0) {
				System.out.println("Você ainda tem R$" + limiteEstudantil + " de crédito para você. \n");
			}else {
				System.out.println("Você utilizou todos seu limite de empréstimo estudantil. Aproveite com sabedoria! \n");
			}
		} 
	}

	private void debito(float valor) {//Função débito. Retira o valor solicitado do saldo, acrescido da taxa de movimentação
		if(this.getSaldo() >= valor) {
		this.setSaldo(this.getSaldo() - (valor + 0.7f));
		} else {
			System.out.println("Impossivel realizar operação de debito, valor insuficiente!");//ERRO PARA QUE SALDO NÃO POSSA FICAR NEGATIVO DURANTE AS 10 MOVIMENTAÇÕES
		}
	}
	
	public void debitado(float valor) { 
		this.debito(valor);
	}
	
	//Getters & Setters
	public float getLimiteEstudantil() {
		return limiteEstudantil;
	}

	public void setLimiteEstudantil(float limiteEstudantil) {
		this.limiteEstudantil = limiteEstudantil;
	}
	
	
}
