package challenge_conversor_moedas;

import javax.swing.*;

public class IniciarAplicacao {
	
	public static void main(String[] args) {
		// METODO PARA INVOCAR O FRAME
		SwingUtilities.invokeLater(() -> {
			
			//CHAMA O CONSTRUTOR DA CLASSE TELA UNICA.
			TelasRotinas menuPrincipal = new TelasRotinas();
			
			//EXIBE O MENU PRINCIPAL.
			menuPrincipal.telaMenuPrincipal();
			
			//ABRE O INPUT PARA O USUÁRIO DIGITAR O VALOR A SER CONVERTIDO.
			//VERIFICA SE O INPUT E UM NUMERO MESMO, CASO NÃO SEJA APRESENTA MENSAGEM DE ERRO.
			//CASO SEJA NUMERO, SAI DO LAÇO E RETOMA A SEQUENCIA, TRANSFORMA O INPUT DE
			//STRING PARA INTEGER PARA PODER REALIZAR OS CALCULOS.
			//SEGUE PARA A ROTINA DE CONVERSÃO ESCOLHIDA PELO USUÁRIO.
			menuPrincipal.analisarInput();
			
		});
		
		
		
	}

}
