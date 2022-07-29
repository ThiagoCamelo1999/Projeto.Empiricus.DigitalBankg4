package projeto.empicicus.digitalbank.g4;


//Felipe Morilho de Castro

public class ContaEmpresa extends Conta {

	//Atributos
	private float emprestimoEmpresa = 10000;
	private String cnpj;
	
	
	//Construtor
	public ContaEmpresa(int numero, String cnpj) {
		super(numero, cnpj);
		this.cnpj = cnpj;
	}
	
	

	//Métodos
	public void pedirEmprestimo(float valorEmprestimo) {
		
		if (valorEmprestimo > 0 && valorEmprestimo <= 10000) {
			this.setSaldo(this.getSaldo() + valorEmprestimo);
			emprestimoEmpresa -= valorEmprestimo;
			System.out.println("\nPARABÉNS!!! Você acaba de pegar R$" + valorEmprestimo + " emprestados. \n");
			System.out.printf("\nSeu novo saldo: " + this.getSaldo());
			if (emprestimoEmpresa > 0) {
				System.out.printf("\nVocê ainda tem de crédito: R$%.2f" , emprestimoEmpresa);
			}else {
				System.out.println("\nVocê utilizou todos seu limite de empréstimo empresarial. Aproveite com sabedoria! \n");
			}
		}
		
		
		
	}

	private void debito(float valor) {//RETIRA O VALOR DO SALDO CASO TENHA USADO A FUNÇÃO DE DEBITO
		if(this.getSaldo() >= (valor + 2.3f)) {
		this.setSaldo(this.getSaldo() - (valor + 2.3f));
		} 
	}
	
	public void debitado(float valor) { 
		this.debito(valor);
	}
	
	//Getters & Setters
	public float getEmprestimoEmpresa() {
		return emprestimoEmpresa;
	}

	public void setEmprestimoEmpresa(float emprestimoEmpresa) {
		this.emprestimoEmpresa = emprestimoEmpresa;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
