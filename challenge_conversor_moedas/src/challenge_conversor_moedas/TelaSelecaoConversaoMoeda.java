package challenge_conversor_moedas;

import javax.swing.*;

public class TelaSelecaoConversaoMoeda {

	
		 // CONSTRUTOR
		 public TelaSelecaoConversaoMoeda() {
						
			 //CRIANDO UM FRAME A SER UTILIZADO PELO JOPTIONPANE
			 JFrame frame = new JFrame();

			 //CRIANDO UM ARRAY DE OPÇÕES PARA MOSTRAR NAS ESCOLAS DA JANELA
			 Object[] listaConversoes = {"DE REAIS A DOLARES",
				                    "DE REAIS A EUROS",
				                    "DE REAIS A LIBRAS",
				                    "DE REAIS A YENES",
				                    "DE REAIS A WON COREANO",
				 					"DE DOLARES A REAIS",
				 					"DE EUROS A REAIS",
				 					"DE LIBRAS A REAIS",
				 					"DE YENES A REAIS",
				 					"DE WON COREANO A REAIS"};
				
			 //CRIANDO E INICIALIZANDO UMA VARIAVEL ICON PARA SER UTILIZADA PELO JOPTIONPANE
			 Icon icon = null;
				
				
			 //CRIANDO O SHOW INPUT DO JOPTION COM SEUS PARAMETROS (TIPOS DE OBJETO,
			 //MESNAGEM INICIAL, TITULO DA JANELA, OPÇÃO DE ICONE, ENTRADA DE VALORES DE OPÇÕES
			 //USANDO O OBJETC QUE CRIAMOS ACIMA E POR FIM, SETANDO QUAL SERA NOSSA OPÇÃO INICIAL
			 // A SER MOSTRADA NA LISTA
				
			 String opcoesConversao = (String)JOptionPane.showInputDialog(frame, "ESCOLHA A MOEDA PARA A QUAL VOCÊ DESEJA GIRAR SEU DINHEIRO","MOEDAS", JOptionPane.PLAIN_MESSAGE, icon ,
					listaConversoes,listaConversoes[0]);
		}
}
