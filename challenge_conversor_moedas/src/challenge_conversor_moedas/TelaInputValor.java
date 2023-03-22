package challenge_conversor_moedas;

import javax.swing.*;

public class TelaInputValor {
	
	
	//CONSTRUTOR
	public TelaInputValor () {
		
					
		//CRIANDO UM FRAME A SER UTILIZADO PELO JOPTIONPANE
		JFrame frame = new JFrame();

		//CRIANDO E INICIALIZANDO UMA VARIAVEL ICON PARA SER UTILIZADA PELO JOPTIONPANE
		Icon icon = null;
			
			
		//CRIANDO O SHOW INPUT DO JOPTION COM SEUS PARAMETROS (TIPOS DE OBJETO,
		//MESNAGEM INICIAL, TITULO DA JANELA, OPÇÃO DE ICONE, VALOR DE OPÇÃO NULL PARA
		//ABRIR UMA CAIXA DE TEXTO PARA QUE O USUÁRIO INSIRA UM VALOR.
			
		String inputValor = (String)JOptionPane.showInputDialog(frame, "INSIRA UM VALOR","INPUT", JOptionPane.QUESTION_MESSAGE, icon ,
			                    null,null);
		
	}
}
