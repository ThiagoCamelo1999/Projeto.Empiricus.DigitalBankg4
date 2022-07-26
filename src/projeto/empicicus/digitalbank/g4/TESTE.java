package projeto.empicicus.digitalbank.g4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

		//Thiago Da Silva Barbosa Camelo.
		//Felipe Morilho de Castro

public class TESTE {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		Scanner entrada = new Scanner(System.in);
		
		//VARIAVEIS
		int conta, numero, contador = 0, contadorEmp = 0;
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
				
				//PARA PEGAR A DATA ATUAL
				DateTimeFormatter date = DateTimeFormatter.ofPattern("dd");//DATA FORMATADA APENAS COM O DIA
		        String dataF = date.format(LocalDateTime.now());//PASSANDO A DATA FORMATADA DE STRING PARA INT
				int data = Integer.parseInt(dataF);
				
				
				ContaPoupanca cp1 = new ContaPoupanca(0, null);
				ContaPoupanca cp2 = new ContaPoupanca(0, null);
				
				float[] movimentacoesP = new float [10];
				int[] nconta = {9999, 2001};
				String[] cpfConta = {"11111111111", "22222222222"};
				
				
				
				
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
					cp2.setCpf(cpfConta[1]);
					cp2.setAtivo(true);
		
					} else {
						System.out.println("Conta inativa");
						break;
					}

					Thread.sleep(500);
				
					//CONTA NUMERO 1
					if(cp1.isAtivo() == true) {
						
						System.out.println("\nConta: " + cp1.getNumero());
						System.out.println("Cpf: " + cp1.getCpf());

						if(data == cp1.getDiaAniversarioPoupanca()) {
							Thread.sleep(500);
							System.out.printf("\nSaldo Atual: R$%.2f" , cp1.getSaldo());
							cp1.correcao(data);
					
						} else {
							System.out.printf("\nSaldo Atual: R$%.2f" , cp1.getSaldo());
							cp1.correcao(data);
						}  
					
					//VARIAVEIS USADAS LOCALMENTE
					continuar = null;
					vMovimento = 0;
							
					Thread.sleep(500);
							
					//LAÇO PARA REPETIR A MOVIMENTAÇÃO 10 VEZES 
					for(int i = 1; i <= 10; i++) {
					System.out.print("\nMOVIMENTO - D-debito ou C-crédito: ");
					String tipoMV = entrada.next();
								
					//VERIFICA SE O TIPO DA MOVIMENTAÇÃO É CREDITO.
					if(tipoMV.equalsIgnoreCase("C")) { 
						System.out.print("\nValor movimento: R$");
						vMovimento = entrada.nextFloat();
						cp1.credito(vMovimento);
						System.out.printf("\nSaldo atualizado: R$%.2f" , cp1.getSaldo());
						movimentacoesP[i-1] = vMovimento;			
								//VERIFICA SE O TIPO DA MOVIMENTAÇÃO É DEBITO.
					} else if(tipoMV.equalsIgnoreCase("D")) {
						System.out.print("Valor movimento: R$");
						vMovimento = entrada.nextFloat();
						if (vMovimento <= cp1.getSaldo()) {
						cp1.debitado(vMovimento);
						System.out.printf("\nSaldo atualizado: R$%.2f" , cp1.getSaldo());	
						movimentacoesP[i-1] = -vMovimento;
						}else {
							System.out.println("\nImpossivel realizar operação de debito, valor insuficiente!");//ERRO PARA QUE SALDO NÃO POSSA FICAR NEGATIVO DURANTE AS 10 MOVIMENTAÇÕES
							i--;
							contador--;
							break;
						}
						} else {
							System.out.println("\nOperação invalida!");
							System.out.println();
							contador--;
							i--;//PARA PODER FAZER MAIS UMA MOVIMENTAÇÃO CASO SEJA DIGITADA OPERAÇÃO INVALIDA
							}
					
					
					Thread.sleep(500);
								
					if(i == 10) {//IF PARA OPÇÃO CONTINUAR NÃO APAREÇA UMA VEZ A MAIS 
						break;
					}
								
					//PERGUNTA SE É PARA CONTINUAR COM AS MOVIMENTAÇÕES
					System.out.println("\n");
					System.out.print("Continuar: \nS - Sim \nN - Não ");
					continuar = entrada.next();
								 
					 //VERIFICAÇÃO, SE RESPOSTA DO USUARIO IGUAL A N/n IRA PARA AS MOVIMENTAÇÕES E CONTINUAR COM CODIGO
					if (continuar.equalsIgnoreCase("S")) {
						System.out.println("\nProxima movimentação: ");
					} else if (continuar.equalsIgnoreCase("N")) {
						
						System.out.println("\nMovimentações encerradas");
						 break;
			
					} else {
						System.out.println("\nOpção invalida!");
					}
					contador++;
					
						
					}
					for (int i = 0; i <= contador; i++) {
						System.out.printf("\n" + (i+1) + "ª movimentação: R$%.2f", movimentacoesP[i] , "\n" );
					}
							
					//CONTA NUMERO 2
				} else if (cp2.isAtivo() == true) {
					System.out.println("\nConta: " + cp2.getNumero());
					System.out.println("Cpf: " + cp2.getCpf());
					
					
					if(data == (cp2.getDiaAniversarioPoupanca())) {
					
						Thread.sleep(500);
						System.out.printf("\nSaldo Atual: R$%.2f" , cp2.getSaldo());
						cp2.correcao(data);
					
					} else {
						System.out.printf("\nSaldo atual: R$%.2f" , cp2.getSaldo());
						cp2.correcao(data);
					}
				
				
				
				//VARIAVEIS USADAS LOCALMENTE
				continuar = null;
				vMovimento = 0;
				
				Thread.sleep(500);
				
				//LAÇO PARA REPETIR A MOVIMENTAÇÃO 10 VEZES 
				for(int i = 1; i <= 10; i++) {
					System.out.print("\nMOVIMENTO - D-debito ou C-crédito: ");
					String tipoMV = entrada.next();
					
					//VERIFICA SE O TIPO DA MOVIMENTAÇÃO É CREDITO.
					if(tipoMV.equalsIgnoreCase("C")) { 
						System.out.print("\nValor movimento: R$ ");
						vMovimento = entrada.nextFloat();
						cp2.credito(vMovimento);
						System.out.printf("\nSaldo atualizado: R$%.2f" , cp2.getSaldo());
						movimentacoesP[i-1] = vMovimento;
						
						
					//VERIFICA SE O TIPO DA MOVIMENTAÇÃO É DEBITO.
					} else if(tipoMV.equalsIgnoreCase("D")) {
						System.out.print("Valor movimento: R$ ");
						vMovimento = entrada.nextFloat();
						if (vMovimento <= cp2.getSaldo()) {
						cp2.debitado(vMovimento);
						System.out.printf("\nSaldo atualizado: R$%.2f" , cp2.getSaldo());	
						movimentacoesP[i-1] = -vMovimento;
						break;
						} else {
							System.out.println("\nImpossivel realizar operação de debito, valor insuficiente!");//ERRO PARA QUE SALDO NÃO POSSA FICAR NEGATIVO DURANTE AS 10 MOVIMENTAÇÕES
							i--;
							contador--;
							break;
						}
						} else {
						System.out.println("\nOperação invalida!");
						System.out.println();
						contador--;
						i--;//PARA PODER FAZER MAIS UMA MOVIMENTAÇÃO CASO SEJA DIGITADA OPERAÇÃO INVALIDA
					}
				
					Thread.sleep(500);
					
					if(i == 10) {//IF PARA OPÇÃO CONTINUAR NÃO APAREÇA UMA VEZ A MAIS 
						break;
					}
					
					//PERGUNTA SE É PARA CONTINUAR COM AS MOVIMENTAÇÕES
					System.out.println("\n");
					System.out.print("Continuar: \nS - Sim \nN - Não ");
					continuar = entrada.next();
					 
					 //VERIFICAÇÃO, SE RESPOSTA DO USUARIO IGUAL A N/n IRA PARA AS MOVIMENTAÇÕES E CONTINUAR COM CODIGO
					if (continuar.equalsIgnoreCase("S")) {
						System.out.println("\nProxima movimentação: ");
					} else if (continuar.equalsIgnoreCase("N")) {
						
						System.out.println("\nMovimentções encerradas");
						 break;
			
					} else {
						System.out.println("\nOpção invalida!");
						i--;
					}
					System.out.println();
					contador++;
				}
				for (int i = 0; i <= contador; i++) {
					
					if ((i+1) <= 10) {
						System.out.printf("\n" + (i+1) + "ª movimentação: R$%.2f", movimentacoesP[i] , "\n" );
					}
					
				}
					} 
				System.out.println();	
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
				
				Thread.sleep(500);
				System.out.println("\nEstamos passando por manutenção nessa opção. Por favor, selecione outro tipo de conta.");
				Thread.sleep(500);
				System.out.println("\nAgradecemos a compreensão.");
				
				Thread.sleep(500);
				System.out.println("\nDigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
				
			break;
			
			
		
			case 3: //CONTA ESPECIAL
				System.out.println("\nDigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
				
				Thread.sleep(500);
				System.out.println("\nCONTA ESPECIAL");
				Thread.sleep(500);
				
				
				System.out.print("Digite o numero: ");
				numero = entrada.nextInt();
				
				
				System.out.print("Digite seu cpf: ");
				cpf = entrada.next();
				ContaEspecial ce = new ContaEspecial(numero, cpf); //Criação da conta
				do
				if (ce.getCpf().length() != 11) {
					System.out.println("\nCPF INVALIDO! TENTE NOVAMENTE \n");
					System.out.print("Digite seu cpf: ");
					ce.setCpf(entrada.next());				
				} while(ce.getCpf().length() != 11);
				
				Thread.sleep(500);
				
				
				
				//LAÇO PARA REPETIR A MOVIMENTAÇÃO 10 VEZES 
				for(int i = 1; i <= 10; i++) {
					System.out.print("MOVIMENTO - D-debito ou C-crédito: ");
					String tipoMV = entrada.next();
					
					//VERIFICA SE O TIPO DA MOVIMENTAÇÃO É CREDITO.
					if(tipoMV.equalsIgnoreCase("C")) { 
						System.out.print("Valor movimento: R$ ");
						vMovimento = entrada.nextFloat();
						ce.credito(vMovimento);
						System.out.println("Seu saldo atual é: "+ce.getSaldo());
						
					//VERIFICA SE O TIPO DA MOVIMENTAÇÃO É DEBITO.
					} else if(tipoMV.equalsIgnoreCase("D")) {
						System.out.print("Valor movimento: R$ ");
						vMovimento = entrada.nextFloat();
						ce.usarLimite(vMovimento);
						System.out.println("Seu saldo atual é: "+ce.getSaldo());
					} else {
						i--;
					}
					
					Thread.sleep(500);
					
					if(i == 10) {//IF PARA OPÇÃO CONTINUAR NÃO APAREÇA UMA VEZ MAIS 
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
				System.out.println("Seu saldo atual é: "+ce.getSaldo());
				
			break;
		
			
			case 4:
				
				//Felipe Morilho de Castro
				
				float valorEmprestimoEmpresa, valorDisponivelEmpresa = 10000;
				String cnpj;
				
				float[] movimentacoes = new float [10];
				float[] emprestimoSolicitado = new float [5];
								
				ContaEmpresa ce1 =new ContaEmpresa(0, null);
				ContaEmpresa ce2 =new ContaEmpresa(0, null);
				ContaEmpresa ce3 =new ContaEmpresa(0, null);
				ContaEmpresa ce4 =new ContaEmpresa(0, null);
				ContaEmpresa ce5 =new ContaEmpresa(0, null);
				ContaEmpresa ce6 =new ContaEmpresa(0, null); //Variável de suporte para contas ativas.
				
				
				int[] numContaEmp = {1001,2002,3003,4004,5005};
				String[] cnpjContaEmp = {"11111111111111","22222222222222","33333333333333","44444444444444","55555555555555"};
				
				
				System.out.println("\nDigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa.");
				
				
				Thread.sleep(500);
				System.out.println("\nCONTA EMPRESA\n");
				Thread.sleep(500);
				
				
				System.out.printf("Digite o número da conta: ");
				numero = entrada.nextInt();
				
				
				do{
					System.out.printf("Digite seu CNPJ: ");
					cnpj = entrada.next();
				}while (cnpj.length() != 14);

				for (int i = 0; i < numContaEmp.length; i++ ) {
					
					
					if (numero == numContaEmp[i] && cnpj.equals(cnpjContaEmp[i])) {
						if (i == 0) {

							ce1.setNumero(numContaEmp[i]);
							ce1.setCpf(cnpjContaEmp[i]);
							ce6.setAtivo(true);
							break;
						}
						if (i == 1) {
							
							ce2.setNumero(numContaEmp[i]);
							ce2.setCpf(cnpjContaEmp[i]);
							ce6.setAtivo(true);
							break;
						}
						if (i == 2) {
							
							ce3.setNumero(numContaEmp[i]);
							ce3.setCpf(cnpjContaEmp[i]);
							ce6.setAtivo(true);
							break;
						}
						if (i == 3) {
							
							ce4.setNumero(numContaEmp[i]);
							ce4.setCpf(cnpjContaEmp[i]);
							ce6.setAtivo(true);
							break;
						}
						if (i == 4) {
							
							ce5.setNumero(numContaEmp[i]);
							ce5.setCpf(cnpjContaEmp[i]);
							ce6.setAtivo(true);
							break;
						}
						
					} else if (i == 4 && ce6.isAtivo() == false){ 
						System.out.println("\nConta Inativa.");
					}
				}
				
				Thread.sleep(500);
				
				if (ce6.isAtivo() == true) {
			
				continuar = null;			
				
				Thread.sleep(500);
				
				//LAÇO PARA REPETIR A MOVIMENTAÇÃO 10 VEZES 
				for(int i = 1; i <= 10; i++) {
					
					//PERGUNTA SOBRE O EMPRÉSTIMO
					if (valorDisponivelEmpresa > 0) {
					System.out.printf("\nVocê tem aprovado para empréstimo: R$%.2f" , valorDisponivelEmpresa);	
					System.out.printf("\nDigite: S - Sim / N - Não: ");
					emprestimo = entrada.next();
					
					switch (emprestimo){
					
					case "s", "S":	
						
						do {
						System.out.println("\nQual valor deseja pegar de empréstimo? ");
						valorEmprestimoEmpresa = entrada.nextFloat();
						if (valorEmprestimoEmpresa <= 10000 && valorEmprestimoEmpresa <= valorDisponivelEmpresa) {
						valorDisponivelEmpresa -= valorEmprestimoEmpresa;
						ce6.pedirEmprestimo(valorEmprestimoEmpresa);
						emprestimoSolicitado[contadorEmp] = valorEmprestimoEmpresa;
						contadorEmp++;
						
						}else {
							System.out.printf("\nValor não aprovado. Tente um novo valor abaixo de R$%.2f" , valorDisponivelEmpresa);
						}
						} while (valorEmprestimoEmpresa > 10000);
					
					case "n","N":
						break;
					
					default:
						System.out.println("\nComando Inválido.");							
					}
					} else {
						System.out.println("\nSeu limite de crédito esgotou. Aproveite o empréstimo já realizado!\n");
					}
					
					System.out.printf("\nMovimento: D - Debito / C - Crédito: ");
					String tipoMV = entrada.next();
					
					//VERIFICA SE O TIPO DA MOVIMENTAÇÃO É CREDITO OU DÉBITO.
					switch (tipoMV) {
					
					case "C","c": 
						
						System.out.printf("\nValor movimento: R$");
						vMovimento = entrada.nextFloat();
						ce6.credito(vMovimento);
						System.out.printf("\nSaldo atualizado: R$%.2f" , ce6.getSaldo());
						
						movimentacoes[i-1] = vMovimento;
						
						
						break;
						
					case "D","d":
						
						System.out.printf("\nValor movimento: R$");
						vMovimento = entrada.nextFloat();
						if ((vMovimento+2.3f) <= ce6.getSaldo()) {

						ce6.debitado(vMovimento);
						System.out.printf("\nSaldo atualizado: R$%.2f" , ce6.getSaldo());
					
						movimentacoes[i-1] = -vMovimento;
						break;
						
						} else {
							System.out.println("\nImpossivel realizar operação de debito, valor insuficiente!");//ERRO PARA QUE SALDO NÃO POSSA FICAR NEGATIVO DURANTE AS 10 MOVIMENTAÇÕES
							i--;
							contador--;
							break;
						}
					
					default:
						
						System.out.println("\nComando inválido.");
						i--;
						contador--;
						break;
					}
										
					Thread.sleep(500);
					
					if(i == 10) {//IF PARA OPÇÃO CONTINUAR NÃO APAREÇA UMA VEZ A MAIS 
						
						//PERGUNTA SOBRE O EMPRÉSTIMO
						if (valorDisponivelEmpresa > 0) {
						System.out.printf("\nVocê tem aprovado para empréstimo: R$%.2f" , valorDisponivelEmpresa);	
						System.out.printf("\nDigite: S - Sim / N - Não: ");
						emprestimo = entrada.next();
						
						switch (emprestimo){
						
						case "s", "S":	
							
							do {
							System.out.println("\nQual valor deseja pegar de empréstimo? ");
							valorEmprestimoEmpresa = entrada.nextFloat();
							if (valorEmprestimoEmpresa <= 10000 && valorEmprestimoEmpresa <= valorDisponivelEmpresa) {
							valorDisponivelEmpresa -= valorEmprestimoEmpresa;
							ce6.pedirEmprestimo(valorEmprestimoEmpresa);
							emprestimoSolicitado[contadorEmp] = valorEmprestimoEmpresa;
							contadorEmp++;
							
							}else {
								System.out.printf("\nValor não aprovado. Tente um novo valor abaixo de R$%.2f" , valorDisponivelEmpresa);
							}
							} while (valorEmprestimoEmpresa > 10000);
						
						case "n","N":
							break;
						
						default:
							System.out.println("\nComando Inválido.");							
						}
						} else {
							System.out.println("\nSeu limite de crédito esgotou. Aproveite o empréstimo já realizado!\n");
						}
						
						Thread.sleep(500);
						System.out.println("\nMovimentações encerradas!" + "\nSegue extrato das movimentações: ");
						
						break;
						
					}
					
					//PERGUNTA SE É PARA CONTINUAR COM AS MOVIMENTAÇÕES
					System.out.println();
					System.out.printf("\nContinuar S - Sim / N - Não: ");
					continuar = entrada.next();
					
										
					 //Verificação para continuar ou não as movimentações
					
					if (continuar.equalsIgnoreCase("N")) {
						Thread.sleep(500);
						System.out.println("\nMovimentações encerradas!" + "\nSegue extrato das movimentações: ");
						
						break;
					 
					 } else if (continuar.equalsIgnoreCase("S")) {

						System.out.println("\nProxima movimentação: ");
			
					} else {
						System.out.println("\nOpção invalida! As movimentações irão continuar.");
					}
				
				contador++;
				}
				
				System.out.println();
				
				
				for (int j = 0; j < contadorEmp; j++) {
					
					System.out.printf("\n" + (j+1) + "° empréstimo: R$%.2f", emprestimoSolicitado[j] , "\n" );

				}
				
				System.out.println();
				
				for (int i = 0; i <= contador; i++) {
					
					System.out.printf("\n" + (i+1) + "ª movimentação: R$%.2f", movimentacoes[i] , "\n" );
				}
				}
				System.out.println();
				Thread.sleep(500);
				System.out.println("\nDigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");

			break;
			

			case 5:
				
				//Felipe Morilho de Castro
				
				float valorDisponivelEstudantil = 5000, valorEmprestimoEstudantil;
								
				float[] movimentacoesEst = new float [10];
				float[] emprestimoSolicitadoEst = new float [5];

				ContaEstudantil est1 =new ContaEstudantil(0, null);
				ContaEstudantil est2 =new ContaEstudantil(0, null);
				ContaEstudantil est3 =new ContaEstudantil(0, null);
				ContaEstudantil est4 =new ContaEstudantil(0, null);
				ContaEstudantil est5 =new ContaEstudantil(0, null);
				ContaEstudantil est6 =new ContaEstudantil(0, null);
				
				
				int[] numContaEst = {1001,2002,3003,4004,5005};
				String[] cpfContaEst = {"11111111111","22222222222","33333333333","44444444444","55555555555"};
				
				
				System.out.println("\nDigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
				
				Thread.sleep(500);
				System.out.println("\nCONTA ESTUDANTIL\n");
				Thread.sleep(500);
				
				System.out.printf("Digite o número da conta: ");
				numero = entrada.nextInt();
				
				do{
					System.out.printf("Digite seu CPF: ");
					cpf = entrada.next();
				}while (cpf.length() != 11);

				for (int i = 0; i < numContaEst.length; i++ ) {
					
					
					if (numero == numContaEst[i] && cpf.equals(cpfContaEst[i])) {
						if (i == 0) {

							est1.setNumero(numContaEst[i]);
							est1.setCpf(cpfContaEst[i]);
							est6.setAtivo(true);
							break;
						}
						if (i == 1) {
							
							est2.setNumero(numContaEst[i]);
							est2.setCpf(cpfContaEst[i]);
							est6.setAtivo(true);
							break;
						}
						if (i == 2) {
							
							est3.setNumero(numContaEst[i]);
							est3.setCpf(cpfContaEst[i]);
							est6.setAtivo(true);
							break;
						}
						if (i == 3) {
							
							est4.setNumero(numContaEst[i]);
							est4.setCpf(cpfContaEst[i]);
							est6.setAtivo(true);
							break;
						}
						if (i == 4) {
							
							est5.setNumero(numContaEst[i]);
							est5.setCpf(cpfContaEst[i]);
							est6.setAtivo(true);
							break;
						
						}
					} else if (i == 4 && est6.isAtivo() == false){
						System.out.println("\nConta Inativa.");
					}
				}
				
				Thread.sleep(500);
				
				if (est6.isAtivo() == true) {
			
				continuar = null;
				
				Thread.sleep(500);
				
				//LAÇO PARA REPETIR A MOVIMENTAÇÃO 10 VEZES 
				for(int i = 1; i <= 10; i++) {
					
					//PERGUNTA SOBRE O EMPRÉSTIMO
					
					if (valorDisponivelEstudantil > 0 ) {
						
					System.out.printf("\nVocê tem aprovado para empréstimo: R$%.2f" , valorDisponivelEstudantil);	
					System.out.printf("\nDigite: S - Sim / N - Não: ");
					emprestimo = entrada.next();
					
					
					switch (emprestimo){
						
					case "s", "S":	
					
					//if (emprestimo.equalsIgnoreCase("S")) {
						do {
						System.out.printf("\nQual valor deseja pegar de empréstimo? ");
						valorEmprestimoEstudantil = entrada.nextFloat();
						if (valorEmprestimoEstudantil <= 5000 && valorEmprestimoEstudantil <= valorDisponivelEstudantil) {
						valorDisponivelEstudantil -=  valorEmprestimoEstudantil;
						est6.usarEstudantil(valorEmprestimoEstudantil);
						emprestimoSolicitadoEst[contadorEmp] = valorEmprestimoEstudantil;
						contadorEmp++;
						
						}else {
							System.out.printf("\nValor não aprovado. Tente um novo valor abaixo de R$%.2f" , valorDisponivelEstudantil);
						}
						} while (valorEmprestimoEstudantil > 5000);
						
					
					case "n","N":
						break;
					
					default:
						System.out.println("\nComando Inválido.");
					}
					} else {
						System.out.println("Seu limite de crédito esgotou. Aproveite o empréstimo já realizado!\n");
					}
					System.out.printf("\nMovimento: D - Debito / C - Crédito: ");
					String tipoMV = entrada.next();
					
					//VERIFICA SE O TIPO DA MOVIMENTAÇÃO É CREDITO.
					switch (tipoMV) {
					
					case "C","c": 
						
						System.out.printf("\nValor movimento: R$");
						vMovimento = entrada.nextFloat();
						est6.credito(vMovimento);
						System.out.printf("\nSaldo atualizado: R$%.2f" , est6.getSaldo());
						
						movimentacoesEst[i-1] = vMovimento;

						
						break;
						
					
					case "D","d":
						
						System.out.printf("\nValor movimento: R$");
						vMovimento = entrada.nextFloat();
						if ((vMovimento+0.7f) <= est6.getSaldo()) {
						est6.debitado(vMovimento);
						System.out.printf("\nSaldo atualizado: R$%.2f" , est6.getSaldo());
						movimentacoesEst[i-1] = -vMovimento;
						break;
						} else {
							System.out.println("\nImpossivel realizar operação de debito, valor insuficiente!");//ERRO PARA QUE SALDO NÃO POSSA FICAR NEGATIVO DURANTE AS 10 MOVIMENTAÇÕES
							i--;
							contador--;
							break;
						}
						
					default:
						
						System.out.println("\nComando inválido.");
						
						i--; 
						contador--;
						break;
					}
										
					Thread.sleep(500);
					
					if(i == 10) {//IF PARA OPÇÃO CONTINUAR NÃO APAREÇA UMA VEZ A MAIS 
						if (valorDisponivelEstudantil > 0 ) {
							
							System.out.printf("\nVocê tem aprovado para empréstimo: R$%.2f" , valorDisponivelEstudantil);	
							System.out.printf("\nDigite: S - Sim / N - Não: ");
							emprestimo = entrada.next();
							
							
							switch (emprestimo){
								
							case "s", "S":	
							
							//if (emprestimo.equalsIgnoreCase("S")) {
								do {
								System.out.printf("\nQual valor deseja pegar de empréstimo? ");
								valorEmprestimoEstudantil = entrada.nextFloat();
								if (valorEmprestimoEstudantil <= 5000 && valorEmprestimoEstudantil <= valorDisponivelEstudantil) {
								valorDisponivelEstudantil -=  valorEmprestimoEstudantil;
								est6.usarEstudantil(valorEmprestimoEstudantil);
								emprestimoSolicitadoEst[contadorEmp] = valorEmprestimoEstudantil;
								contadorEmp++;
								
								}else {
									System.out.printf("\nValor não aprovado. Tente um novo valor abaixo de R$%.2f" , valorDisponivelEstudantil);
								}
								} while (valorEmprestimoEstudantil > 5000);
								
							
							case "n","N":
								break;
							
							default:
								System.out.println("\nComando Inválido.");
							}
							} else {
								System.out.println("Seu limite de crédito esgotou. Aproveite o empréstimo já realizado!\n");
							}
						
						Thread.sleep(500);
						System.out.println("\nMovimentações encerradas!" + "\nSegue extrato das movimentações: ");
						
						break;
					}
					
					//PERGUNTA SE É PARA CONTINUAR COM AS MOVIMENTAÇÕES
					System.out.println();
					System.out.printf("\nContinuar S - Sim / N - Não: ");
					continuar = entrada.next();
					 
					 //Verificação para continuar ou não as movimentações
					if (continuar.equalsIgnoreCase("N")) {
						Thread.sleep(500);
						System.out.println("\nMovimentações encerradas!" + "\nSegue extrato das movimentações: ");
						
						break;
					 
					 } else if (continuar.equalsIgnoreCase("S")) {

						System.out.println("\nProxima movimentação: ");
			
					} else {
						System.out.println("\nOpção invalida! As movimentações irão continuar.");
					}
					contador++;
					
				}
				
				System.out.println();
				
				for (int j = 0; j < contadorEmp; j++) {
					
					System.out.printf("\n" + (j+1) + "° empréstimo: : R$%.2f", emprestimoSolicitadoEst[j] , "\n" );

				}

				System.out.println();
				
					for (int i = 0; i <= contador; i++) {
						
						if ((i+1) <= 10) {
						System.out.printf("\n" + (i+1) + "ª movimentação: R$%.2f", movimentacoesEst[i] , "\n" );
						}	
					}
					}
					System.out.println();
					Thread.sleep(500);
					System.out.println("\nDigitalBank G4");
					Thread.sleep(500);
					System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
					Thread.sleep(500);
					System.out.println("\nAgradecemos a preferência!");
				
			break;
			case 6:
				System.out.println("\nDigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
			break;
			default:

				System.out.println();
				System.out.println("Opção inválida! Tente novamente");

				
				Thread.sleep(500);

		} 
		} while (conta < 1 || conta > 6);
		

		
				
		
		//FECHAMENDO DO SCANNER
		entrada.close();
}
	
}