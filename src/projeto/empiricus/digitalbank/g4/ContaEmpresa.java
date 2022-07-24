package projeto.empiricus.digitalbank.g4;

	//Felipe Morilho de Castro

public class ContaEmpresa extends Conta {

	//Atributos
	private float emprestimoEmpresa = 10000;
	
	
	//Construtor
	public ContaEmpresa(int numero, String cpf) {
		super(numero, cpf);
	}
	
	//Métodos
	public void pedirEmprestimo(float valorEmprestimo) {
		//System.out.println("Você tem um limite de R$10 mil aprovados para empréstimo. Vamos dar um upgrade na sua empresa?");
		//System.out.println("Digite: S para levar sua empresa para outro patamar ou N para continuar na mesma.");
		if (valorEmprestimo > 0 && valorEmprestimo <= 10000) {
			this.setSaldo(this.getSaldo() + valorEmprestimo);
			emprestimoEmpresa -= valorEmprestimo;
			System.out.println("PARABÉNS!!! Você acaba de pegar R$" + valorEmprestimo + " emprestados.");
			System.out.println("Seu novo saldo: " + this.getSaldo());
			if (emprestimoEmpresa > 0) {
				System.out.println("Você ainda tem R$" + emprestimoEmpresa + " de crédito para você.");
			}else {
				System.out.println("Você utilizou todos seu limite de empréstimo empresarial. Aproveite com sabedoria!");
			}
		} else {
			System.out.println("Valor não liberado. Você tem um crédito de até R$10.000,00.");
		}
		
		
	}

	
	//Getters & Setters
	public float getEmprestimoEmpresa() {
		return emprestimoEmpresa;
	}

	public void setEmprestimoEmpresa(float emprestimoEmpresa) {
		this.emprestimoEmpresa = emprestimoEmpresa;
	}
	
	
	
}
