package projeto.empicicus.digitalbank.g4;

import java.util.Scanner;

public class TESTE {

	public static void main(String[] args) throws InterruptedException {
		
		//Autor Thiago Da Silva Barbosa Camelo.
		
		Scanner entrada = new Scanner(System.in);
		
		//VARIAVEIS
		int conta;
		
		
		do { //PARA REPETIR A OPÇÃO DE ESCOLHA ENQUANTO NÃO DIGITAR UM VALOR VALIDO
			System.out.println("\nDigitalBank G4");
			Thread.sleep(500);
			System.out.println("Cuidamos do seu dinheiro, para você cuidar do realmente importa");
			
		Thread.sleep(500);
		
		System.out.print("\n 1 - CONTA POUPANÇA \n 2 - CONTA CORRENTE \n "
				+ "3 - CONTA ESPECIAL \n 4 - CONTA EMPRESA \n "
				+ "5 - CONTA ESTUDANTIL \n 6 - SAIR \n");
		
		Thread.sleep(500);
		System.out.print("\nDIGITE O CODIGO DA OPÇÃO SELECIONADA: ");
		conta = entrada.nextInt();
		
		Thread.sleep(500);
		
		
		//Autor Thiago Da Silva Barbosa Camelo.
		
		switch (conta) {
		
		//Autor Thiago Da Silva Barbosa Camelo.
		
			case 1:
				
				System.out.println("\nDigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
				
				Thread.sleep(500);
				System.out.println("\nCONTA POUPANÇA");
				Thread.sleep(500);
				
				
				System.out.print("Digite o numero: ");
				int numero = entrada.nextInt();
				
				
				System.out.print("Digite seu cpf: ");
				String cpf = entrada.next();
				ContaPoupanca cp1 = new ContaPoupanca(numero, cpf);
				do
				if (cp1.getCpf().length() != 11) {
					System.out.println("\nCPF INVALIDO! TENTE NOVAMENTE \n");
					System.out.print("Digite seu cpf: ");
					cp1.setCpf(entrada.next());				
				} while(cp1.getCpf().length() != 11);
				
				Thread.sleep(500);
				
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
				String continuar = null;
				float vMovimento = 0;
				
				Thread.sleep(500);
				
				//LAÇÕ PARA REPETIR A MOVIMENTAÇÃO 10 VEZES 
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
						i--;
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
				System.out.println(cp1.getSaldo());
			
				
		
			break;
			case 2:
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
						System.out.println(ce.getSaldo());
						
					//VERIFICA SE O TIPO DA MOVIMENTAÇÃO É DEBITO.
					} else if(tipoMV.equalsIgnoreCase("D")) {
						System.out.print("Valor movimento: R$ ");
						vMovimento = entrada.nextFloat();
						ce.usarLimite(vMovimento);
						
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
				System.out.println(ce.getSaldo());
				
			break;
			case 4:
				System.out.println("\nDigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
			break;
			case 5:
				System.out.println("\nDigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
			break;
			case 6:
				System.out.println("\nDigitalBank G4");
				Thread.sleep(500);
				System.out.println("Cuidamos do seu dinheiro, para você cuidar do que realmente importa");
			break;
			default:
				System.out.println();
				System.out.println("OPÇÃO INVALIDA! TENTE NOVAMENTE");
		} 
		} while (conta < 1 || conta > 6);
		

		
		
		
		
		
		
		
		
		
		//FECHAMENDO DO SCANNER
		entrada.close();
}
	
}