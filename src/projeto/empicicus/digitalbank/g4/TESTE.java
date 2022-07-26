package projeto.empicicus.digitalbank.g4;

import java.util.Scanner;

		//Autor Thiago Da Silva Barbosa Camelo.
		//Felipe Morilho de Castro

public class TESTE {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		Scanner entrada = new Scanner(System.in);
		
		//VARIAVEIS
		int conta, numero;
		String cpf, continuar, emprestimo;
		float vMovimento;
		
		
		
		
		//Autor Thiago Da Silva Barbosa Camelo.
		
		do { //PARA REPETIR A OPÇÃO DE ESCOLHA ENQUANTO NÃO DIGITAR UM VALOR VALIDO
			System.out.println("\nDigitalBank G4");
			Thread.sleep(500);
			System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
			
		Thread.sleep(500);
		
		System.out.print("\n 1 - CONTA POUPANÇA \n 2 - CONTA CORRENTE \n "
				+ "3 - CONTA ESPECIAL \n 4 - CONTA EMPRESA \n "
				+ "5 - CONTA ESTUDANTIL \n 6 - SAIR \n");
		
		Thread.sleep(500);
		System.out.print("\nDIGITE O CODIGO DA OPÇÃO SELECIONADA: ");
		conta = entrada.nextInt();
		
		Thread.sleep(500);
		
		
		switch (conta) {
		
		//Autor Thiago Da Silva Barbosa Camelo.
		
			//CONTA POUPANÇA
			case 1:
				
				ContaPoupanca cp1 = new ContaPoupanca(0, null);
				ContaPoupanca cp2 = new ContaPoupanca(0, null);
				
				
				int[] nconta = new int[2];
				nconta[0] = 9999; 
				nconta[1] = 2001;
				String cpfConta[] = new String[2];
				cpfConta[0] = "11111111111";
				cpfConta[1] = "22222222222";
				
				
				
				System.out.println("\nDigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
				
				Thread.sleep(500);
				System.out.println("\nCONTA POUPANÇA");
				Thread.sleep(500);
				
				
				System.out.print("Digite o numero da conta: ");
				numero = entrada.nextInt();
				System.out.print("Digite seu cpf: ");
				cpf = entrada.next();
				
					
				if(numero == nconta[0] && cpf.equals(cpfConta[0])) {
				cp1.setNumero(nconta[0]);
				cp1.setCpf(cpfConta[0]);
				cp1.setAtivo(true);
					
				} else if (numero == nconta[1] && cpf.equals(cpfConta[1])) {
					cp2.setNumero(numero);;
					cp1.setCpf(cpfConta[1]);
					cp2.setAtivo(true);
		
					} else {
						System.out.println("Conta inativa");
						break;
					}

					Thread.sleep(500);
				
					if(cp1.isAtivo() == true) {
						
						System.out.println("Conta: " + cp1.getNumero());
						System.out.println("Cpf: " + cp1.getCpf());
						System.out.print("Informe a Data: ");
						int data = entrada.nextInt();
					
						if(data == cp1.getDiaAniversarioPoupanca()) {

							Thread.sleep(500);
							System.out.print("Saldo Atual: R$ " + cp1.getSaldo()+ " - ");
							cp1.correcao(data);
					
					
						} else {
							System.out.print("Saldo Atual: R$ " + cp1.getSaldo()+ "  ");
							cp1.correcao(data);
						}  
					
					//VARIAVEIS USADAS LOCALMENTE
					continuar = null;
					vMovimento = 0;
							
					Thread.sleep(500);
							
					//LAÇO PARA REPETIR A MOVIMENTAÇÃO 10 VEZES 
					for(int i = 1; i <= 10; i++) {
					System.out.print("MOVIMENTO - D-debito ou C-crédito: ");
					String tipoMV = entrada.next();
								
					//VERIFICA SE O TIPO DA MOVIMENTAÇÃO É CREDITO.
					if(tipoMV.equalsIgnoreCase("C")) { 
						System.out.print("Valor movimento: R$ ");
						vMovimento = entrada.nextFloat();
						cp1.credito(vMovimento);
						System.out.println(cp1.getSaldo());
									
								//VERIFICA SE O TIPO DA MOVIMENTAÇÃO É DEBITO.
					} else if(tipoMV.equalsIgnoreCase("D")) {
						System.out.print("Valor movimento: R$ ");
						vMovimento = entrada.nextFloat();
						cp1.debitado(vMovimento);
						System.out.println(cp1.getSaldo());	
						} else {
							System.out.println("Operação invalida!");
							System.out.println();
							i--;//PARA PODER FAZER MAIS UMA MOVIMENTAÇÃO CASO SEJA DIGITADA OPERAÇÃO INVALIDA
							}
					
					Thread.sleep(500);
								
					if(i == 10) {//IF PARA OPÇÃO CONTINUAR NÃO APAREÇA UMA VEZ A MAIS 
						break;
					}
								
					//PERGUNTA SE É PARA CONTINUAR COM AS MOVIMENTAÇÕES
					System.out.println("\n");
					System.out.print("Continuar S/N: ");
					continuar = entrada.next();
								 
					 //VERIFICAÇÃO, SE RESPOSTA DO USUARIO IGUAL A N/n IRA PARA AS MOVIMENTAÇÕES E CONTINUAR COM CODIGO
					if (continuar.equalsIgnoreCase("N")) {
						break;
					}	
					}
							
				} else if (cp2.isAtivo() == true) {
					System.out.println("Conta: " + cp1.getNumero());
					System.out.println("Cpf: " + cp1.getCpf());
					System.out.print("Informe a Data: ");
					int data = entrada.nextInt();
					
					if(data == cp2.getDiaAniversarioPoupanca()) {
					
					Thread.sleep(500);
					System.out.print("Saldo Atual: R$ " + cp1.getSaldo()+ " - ");
					cp2.correcao(data);
					
					} else {
						System.out.print("Saldo Atual: R$ " + cp1.getSaldo()+ "  ");
						cp2.correcao(data);
					}
				
				
				
				//VARIAVEIS USADAS LOCALMENTE
				continuar = null;
				vMovimento = 0;
				
				Thread.sleep(500);
				
				//LAÇO PARA REPETIR A MOVIMENTAÇÃO 10 VEZES 
				for(int i = 1; i <= 10; i++) {
					System.out.print("MOVIMENTO - D-debito ou C-crédito: ");
					String tipoMV = entrada.next();
					
					//VERIFICA SE O TIPO DA MOVIMENTAÇÃO É CREDITO.
					if(tipoMV.equalsIgnoreCase("C")) { 
						System.out.print("Valor movimento: R$ ");
						vMovimento = entrada.nextFloat();
						cp2.credito(vMovimento);
						System.out.println(cp2.getSaldo());
						
					//VERIFICA SE O TIPO DA MOVIMENTAÇÃO É DEBITO.
					} else if(tipoMV.equalsIgnoreCase("D")) {
						System.out.print("Valor movimento: R$ ");
						vMovimento = entrada.nextFloat();
						cp2.debitado(vMovimento);
						System.out.println(cp2.getSaldo());	
						
						} else {
						System.out.println("Operação invalida!");
						System.out.println();
						i--;//PARA PODER FAZER MAIS UMA MOVIMENTAÇÃO CASO SEJA DIGITADA OPERAÇÃO INVALIDA
					}
				
					Thread.sleep(500);
					
					if(i == 10) {//IF PARA OPÇÃO CONTINUAR NÃO APAREÇA UMA VEZ A MAIS 
						break;
					}
					
					//PERGUNTA SE É PARA CONTINUAR COM AS MOVIMENTAÇÕES
					System.out.println("\n");
					System.out.print("Continuar S/N: ");
					continuar = entrada.next();
					 
					 //VERIFICAÇÃO, SE RESPOSTA DO USUARIO IGUAL A N/n IRA PARA AS MOVIMENTAÇÕES E CONTINUAR COM CODIGO
					if (continuar.equalsIgnoreCase("N")) {
						 break;
					}
				}	
				} 
					
				System.out.println("\nDigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
				System.out.println("\nAgradecemos a preferência!");
		
			break;
			
			
			
			//CONTA CORRENTE
			case 2:
				System.out.println("\nDigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
			break;
			
			//CONTA ESPECIAL
			case 3:
				System.out.println("\nDigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
			break;
			
			
			case 4:
				
				//Felipe Morilho de Castro
				
				float valorEmprestimoEmpresa, valorDisponivelEmpresa = 10000;
				
				System.out.println("\nDigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
				
				
				Thread.sleep(500);
				System.out.println("\nCONTA EMPRESA");
				Thread.sleep(500);
				
				
				System.out.print("Digite o numero: ");
				numero = entrada.nextInt();
				
				do{
					System.out.print("Digite seu CPF: ");
					cpf = entrada.next();
				}while (cpf.length() != 11);

				ContaEmpresa ce1 = new ContaEmpresa(numero, cpf);
				
				Thread.sleep(500);
					
			
				continuar = null;			
				
				Thread.sleep(500);
				
				//LAÇO PARA REPETIR A MOVIMENTAÇÃO 10 VEZES 
				for(int i = 1; i <= 10; i++) {
					
					//PERGUNTA SOBRE O EMPRÉSTIMO
					if (valorDisponivelEmpresa > 0) {
					System.out.println("\n");
					System.out.println("Você tem R$" + valorDisponivelEmpresa + " aprovados para empréstimo. Vamos dar um upgrade na sua empresa?");	
					System.out.println("Digite: \n S - Sim  \n N - Não");
					emprestimo = entrada.next();
					
					switch (emprestimo){
					
					case "s", "S":	
					//if (emprestimo.equalsIgnoreCase("S")) {
						do {
						System.out.println("Qual valor deseja pegar de empréstimo?");
						valorEmprestimoEmpresa = entrada.nextFloat();
						if (valorEmprestimoEmpresa <= 10000 && valorEmprestimoEmpresa <= valorDisponivelEmpresa) {
						valorDisponivelEmpresa -= valorEmprestimoEmpresa;
						ce1.pedirEmprestimo(valorEmprestimoEmpresa);
						}else {
							System.out.println("Valor não aprovado. Tente um novo valor abaixo de R$" + valorDisponivelEmpresa);
						}
						} while (valorEmprestimoEmpresa > 10000);
					
					case "n","N":
						break;
					
					default:
						System.out.println("Comando Inválido.");							
					}
					} else {
						System.out.println("Seu limite de crédito esgotou. Aproveite o empréstimo já realizado!");
					}
					
					System.out.print("MOVIMENTO \nD - Debito \nC - Crédito: ");
					String tipoMV = entrada.next();
					
					//VERIFICA SE O TIPO DA MOVIMENTAÇÃO É CREDITO OU DÉBITO.
					switch (tipoMV) {
					
					case "C","c": 
						
						System.out.print("Valor movimento: R$");
						vMovimento = entrada.nextFloat();
						ce1.credito(vMovimento);
						System.out.println("Saldo atualizado: R$" + ce1.getSaldo());
						
						
						break;
						
					case "D","d":
						
						System.out.print("Valor movimento: R$");
						vMovimento = entrada.nextFloat();
						ce1.debitado(vMovimento);
						System.out.println("Saldo atualizado: R$" + ce1.getSaldo());
					
						break;
					
					default:
						
						System.out.println("Comando inválido.");
						break;
					}
										
					Thread.sleep(500);
					
					if(i == 10) {//IF PARA OPÇÃO CONTINUAR NÃO APAREÇA UMA VEZ A MAIS 
						break;
					}
					
					//PERGUNTA SE É PARA CONTINUAR COM AS MOVIMENTAÇÕES

					System.out.print("\nContinuar S/N: ");
					continuar = entrada.next();
					 
					 //Verificação para continuar ou não as movimentações
					if (continuar.equalsIgnoreCase("N")) {
						 break;
					 
					 }
				}				
		
				System.out.println("\nAgradecemos a preferência!");

			break;
			case 5:
				
				//Felipe Morilho de Castro
				
				float valorDisponivelEstudantil = 5000;
				float valorEmprestimoEstudantil;
				
				System.out.println("DigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
				
				Thread.sleep(500);
				System.out.println("CONTA ESTUDANTIL");
				Thread.sleep(500);
				
				System.out.print("Digite o numero: ");
				numero = entrada.nextInt();
				
				do{
					System.out.print("Digite seu CPF: ");
					cpf = entrada.next();
				}while (cpf.length() != 11);

				ContaEstudantil est1 = new ContaEstudantil(numero, cpf);
				
				Thread.sleep(500);
					
			
				continuar = null;
				
				Thread.sleep(500);
				
				//LAÇO PARA REPETIR A MOVIMENTAÇÃO 10 VEZES 
				for(int i = 1; i <= 10; i++) {
					
					//PERGUNTA SOBRE O EMPRÉSTIMO
					
					if (valorDisponivelEstudantil > 0 ) {
						
					System.out.println("\nVocê tem R$" + valorDisponivelEstudantil + " aprovados para empréstimo. Vamos aproveitar?");	
					System.out.println("Digite: \nS - Sim  \nN - Não");
					emprestimo = entrada.next();
					
					
					switch (emprestimo){
						
					case "s", "S":	
					
					//if (emprestimo.equalsIgnoreCase("S")) {
						do {
						System.out.println("Qual valor deseja pegar de empréstimo?");
						valorEmprestimoEstudantil = entrada.nextFloat();
						if (valorEmprestimoEstudantil <= 5000 && valorEmprestimoEstudantil <= valorDisponivelEstudantil) {
						valorDisponivelEstudantil -=  valorEmprestimoEstudantil;
						est1.usarEstudantil(valorEmprestimoEstudantil);
						}else {
							System.out.println("Valor não aprovado. Tente um novo valor abaixo de R$" + valorDisponivelEstudantil);
						}
						} while (valorEmprestimoEstudantil > 5000);
						
					case "n","N":
						break;
					
					default:
						System.out.println("Comando Inválido.");
					}
					} else {
						System.out.println("Seu limite de crédito esgotou. Aproveite o empréstimo já realizado!");
					}
					
					System.out.print("MOVIMENTO \nD - Debito  \nC - Crédito: ");
					String tipoMV = entrada.next();
					
					//VERIFICA SE O TIPO DA MOVIMENTAÇÃO É CREDITO.
					switch (tipoMV) {
					
					case "C","c": 
						
						System.out.print("Valor movimento: R$");
						vMovimento = entrada.nextFloat();
						est1.credito(vMovimento);
						System.out.println("Saldo atualizado: R$" + est1.getSaldo());
						
						
						break;
						
					
					case "D","d":
						
						System.out.print("Valor movimento: R$");
						vMovimento = entrada.nextFloat();
						est1.debitado(vMovimento);
						System.out.println("Saldo atualizado: R$" + est1.getSaldo());
					
						break;
						
					default:
						
						System.out.println("Comando inválido.");
						break;
					}
										
					Thread.sleep(500);
					
					if(i == 10) {//IF PARA OPÇÃO CONTINUAR NÃO APAREÇA UMA VEZ A MAIS 
						break;
					}
					
					//PERGUNTA SE É PARA CONTINUAR COM AS MOVIMENTAÇÕES

					System.out.print("\nContinuar S/N: ");
					continuar = entrada.next();
					 
					 //Verificação para continuar ou não as movimentações
					if (continuar.equalsIgnoreCase("N")) {
						 break;
					
					 }
				}
				
				System.out.println("\nAgradecemos a preferência!");
		
			break;
			case 6:
				System.out.println("\nDigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
			break;
			default:

				System.out.println();
				System.out.println("OPÇÃO INVALIDA! TENTE NOVAMENTE");

				
				Thread.sleep(500);
				System.out.println("Comando Inválido! Tente novamente.");

		} 
		} while (conta < 1 || conta > 6);
		

		
		
		
		
		
		
		
		
		
		//FECHAMENDO DO SCANNER
		entrada.close();
}
	
}