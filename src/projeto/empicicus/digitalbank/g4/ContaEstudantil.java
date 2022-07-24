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
				System.out.println("Você ainda tem R$" + limiteEstudantil + " de crédito para você.");
			}else {
				System.out.println("Você utilizou todos seu limite de empréstimo estudantil. Aproveite com sabedoria!");
			}
		} else {
			System.out.println("Valor não liberado. Você tem um crédito de até R$5.000,00");
		}
	}

	
	//Getters & Setters
	public float getLimiteEstudantil() {
		return limiteEstudantil;
	}

	public void setLimiteEstudantil(float limiteEstudantil) {
		this.limiteEstudantil = limiteEstudantil;
	}
	
	
}
