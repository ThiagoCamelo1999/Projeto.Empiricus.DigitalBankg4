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
			System.out.println("\nPARABÉNS!!! Você acaba de pegar R$" + valorSolicitado + " emprestados.");
			System.out.printf("\nSeu novo saldo: R$%.2f" , this.getSaldo());
			if (limiteEstudantil > 0) {
				System.out.printf("\nVocê ainda tem de crédito: R$%.2f" , limiteEstudantil);
			}else {
				System.out.printf("\nVocê utilizou todos seu limite de empréstimo estudantil. Aproveite com sabedoria! \n");
			}
		} 
	}

	private void debito(float valor) {//Função débito. Retira o valor solicitado do saldo, acrescido da taxa de movimentação
		if(this.getSaldo() >= (valor + 0.7f)) {
		this.setSaldo(this.getSaldo() - (valor + 0.7f));
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
