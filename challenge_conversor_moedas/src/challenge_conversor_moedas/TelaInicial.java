package challenge_conversor_moedas;

import javax.swing.*;

public class TelaInicial extends JFrame{
	
	
	// CONSTRUTOR
	public TelaInicial() {
				
		//CRIANDO UM FRAME A SER UTILIZADO PELO JOPTIONPANE
		JFrame frame = new JFrame();

		//CRIANDO UM ARRAY DE OPÇÕES PARA MOSTRAR NAS ESCOLAS DA JANELA
		Object[] entradaSistema = {"CONVERSOR DE MOEDAS", "CONVERSOR DE TEMPERATURA"};
		
		//CRIANDO E INICIALIZANDO UMA VARIAVEL ICON PARA SER UTILIZADA PELO JOPTIONPANE
		Icon icon = null;
		
		
		//CRIANDO O SHOW INPUT DO JOPTION COM SEUS PARAMETROS (TIPOS DE OBJETO,
		//MESNAGEM INICIAL, TITULO DA JANELA, OPÇÃO DE ICONE, ENTRADA DE VALORES DE OPÇÕES
		//USANDO O OBJETC QUE CRIAMOS ACIMA E POR FIM, SETANDO QUAL SERA NOSSA OPÇÃO INICIAL
		// A SER MOSTRADA NA LISTA
		
		String opcoesIniciais = (String)JOptionPane.showInputDialog(frame, "ESCOLHA SEU TIPO DE CONVERSOR","MENU", JOptionPane.QUESTION_MESSAGE, icon ,
		                    entradaSistema,entradaSistema[0]);

		
		
		
	}
	
	
}
