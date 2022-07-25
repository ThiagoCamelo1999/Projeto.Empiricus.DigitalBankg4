package projeto.empicicus.digitalbank.g4;


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

	
	//Getters & Setters
	public float getEmprestimoEmpresa() {
		return emprestimoEmpresa;
	}

	public void setEmprestimoEmpresa(float emprestimoEmpresa) {
		this.emprestimoEmpresa = emprestimoEmpresa;
	}
	
	
	
}
