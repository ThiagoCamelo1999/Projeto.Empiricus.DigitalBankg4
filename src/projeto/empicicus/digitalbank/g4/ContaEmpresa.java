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
			System.out.println("PARABÉNS!!! Você acaba de pegar R$" + valorEmprestimo + " emprestados. \n");
			System.out.println("Seu novo saldo: " + this.getSaldo());
			if (emprestimoEmpresa > 0) {
				System.out.println("Você ainda tem R$" + emprestimoEmpresa + " de crédito para você. \n");
			}else {
				System.out.println("Você utilizou todos seu limite de empréstimo empresarial. Aproveite com sabedoria! \n");
			}
		}
		
		
		
	}

	private void debito(float valor) {//RETIRA O VALOR DO SALDO CASO TENHA USADO A FUNÇÃO DE DEBITO
		if(this.getSaldo() >= valor) {
		this.setSaldo(this.getSaldo() - (valor + 2.3f));
		} else {
			System.out.println("Impossivel realizar operação de debito, valor insuficiente!");//ERRO PARA QUE SALDO NÃO POSSA FICAR NEGATIVO DURANTE AS 10 MOVIMENTAÇÕES
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
