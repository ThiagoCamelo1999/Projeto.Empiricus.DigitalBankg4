package projeto.empicicus.digitalbank.g4;


//Autor Thiago Da Silva Barbosa Camelo.

public class ContaPoupanca extends Conta {
	
	//ATRIBUTOS
	private int diaAniversarioPoupanca;
	
	
	//CONSTRUTOR
	public ContaPoupanca(int numero, String cpf) {
		super(numero, cpf);
		this.diaAniversarioPoupanca = 25;	
		}
	
	
	
	//MÉTODOS
	public void correcao(int data) {
		
		if (data == diaAniversarioPoupanca) {//VERIFICANDO CONDIÇÃO PARA MÉTODO SER UTILIZADO
			this.setSaldo((this.getSaldo() * 0.05f) + this.getSaldo() );
			System.out.print("Saldo corrigido: " + this.getSaldo() );
		}
	}
	
	
	
	//MÉTODOS GETTERS E SETTERS
	public int getDiaAniversarioPoupanca() {
		return diaAniversarioPoupanca;
	}

	public void setDiaAniversarioPoupanca(int diaAniversarioPoupanca) {
		this.diaAniversarioPoupanca = diaAniversarioPoupanca;
	}
	
	
	
	
	
}
