package challenge_conversor_moedas;

import javax.swing.*;

public class IniciarAplicacao {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			
			//CHAMA O CONSTRUTOR DA CLASSE TELA UNICA
			TelasRotinas menuPrincipal = new TelasRotinas();
			
			//EXIBE O MENU PRINCIPAL
			menuPrincipal.telaMenuPrincipal();
			
			//ABRE O INPUT DE ACORDO COM A ESCOLHA DO USUÁRIO
			menuPrincipal.telaInputValor();
			
			//VERIFICA SE O INPUT E UM NUMERO MESMO, CASO NÃO SEJA APRESENTA MENSAGEM DE ERRO
			while (menuPrincipal.validainputNumero(menuPrincipal.getvalorAConverter()) == false) {
					menuPrincipal.telaNumeroNaoDigitado();
					menuPrincipal.telaMenuPrincipal();
					menuPrincipal.telaInputValor();
			}
			
			//CASO SEJA NUMERO, SAI DO LAÇO E RETOMA A SEQUENCIA, TRANSFORMA O INPUT DE
			//STRING PARA INTEGER PARA PODER REALIZAR OS CALCULOS.
			menuPrincipal.escolherAConversao(menuPrincipal.getOpcoesIniciais());
			menuPrincipal.converterMoedas(menuPrincipal.getOpcaoConversaoMoeda(), menuPrincipal.transformaInputEmInteger(menuPrincipal.getvalorAConverter()));
			
			});
		
		
		
	}

}
