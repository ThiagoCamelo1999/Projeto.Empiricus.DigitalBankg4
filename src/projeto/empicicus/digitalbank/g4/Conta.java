package projeto.empicicus.digitalbank.g4;

//Autor Thiago Da Silva Barbosa Camelo

public abstract class Conta implements ControladorConta{
	
	//ATRIBUTOS
	private int numero;
	private String cpf;
	private float saldo = 500;
	private boolean ativo;
	
	
	
	//CONSTRUTOR
	public Conta(int numero, String cpf) {
		super();
		this.numero = numero;
		this.cpf = cpf;
		if (cpf.equals("00000000000") || cpf.equals("11111111111") ||	
	        cpf.equals("22222222222") || cpf.equals("33333333333") ||
	        cpf.equals("44444444444") || cpf.equals("55555555555") ||
	        cpf.equals("66666666666") || cpf.equals("77777777777") ||
	        cpf.equals("88888888888") || cpf.equals("99999999999") ||
	        (cpf.length() == 11)) {    
		} else {
			System.out.println("CPF INVALIDO!");
		}
	}
	
	
	
	//MÉTODOS
	
	private void debito(float valor) {//RETIRA O VALOR DO SALDO CASO TENHA USADO A FUNÇÃO DE DEBITO
		if(this.getSaldo() >= valor) {
		this.saldo = this.getSaldo() - valor;
		} else {
			System.out.println("Impossivel realizar operação de debito, valor insuficiente!");//ERRO PARA QUE SALDO NÃO POSSA FICAR NEGATIVO DURANTE AS 10 MOVIMENTAÇÕES
		}
	}
	public void credito(float valor) {
		this.saldo = this.getSaldo() + valor;//COLOCA O VALOR NO SALDO CASO TENHA USADO A FUNÇÃO DE CREDITO
	}
		
			@Override
	public void debitado(float valor) { //IMPLEMENTO DE INTERFACE ContaControlador PARA ENCAPSULAMENTO DE MÉTODO
			this.debito(valor);
	}
	
	
	
	//MÉTODOS GETTERS E SETTERS
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
	
	
}
