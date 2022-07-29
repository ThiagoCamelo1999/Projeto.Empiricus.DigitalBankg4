package projeto.empicicus.digitalbank.g4;

public class ContaEspecial extends Conta{
	//ATRIBUTOS DA CLASSE
	private float limite = 1000; //LIMITE DE R$ 1.000,00

	public ContaEspecial(int numero, String cpf) {
		super(numero, cpf);
	}

	
	//Método
	public void usarLimite(float valor) {
		float valorAcrescimo = 0; //variavel local

		
		this.setSaldo(this.getSaldo() - valor); //fazendo debito
System.out.println("S: "+this.getSaldo());
System.out.println("L: "+this.getLimite());

if(this.getSaldo() < 0 && limite > 0) { //saldo negativou - usar do limite
			valorAcrescimo -= this.getSaldo(); // valor a ser emprestado
			System.out.println("L: "+this.getLimite());
			System.out.println("A: "+valorAcrescimo);

			if(valorAcrescimo >= 0) {		
			this.setSaldo(this.getSaldo() + valorAcrescimo); //Ajustando o saldo
			this.setLimite((this.getLimite() - valorAcrescimo)); //Atualizando o limite
			System.out.println("L: "+this.getLimite());
			} else {
				System.out.println("Débito não liberado. Você tem um limite de até R$1.000,00");
				this.setSaldo(this.getSaldo() + valor); //Voltar o valor do saldo ao anterior
			}
		} else	{
			System.out.println("Débito foi realizado com sucesso! Seu saldo é de: "+this.getSaldo());
		}
	}
	
	//GETTERS & SETTERS
	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	

}
