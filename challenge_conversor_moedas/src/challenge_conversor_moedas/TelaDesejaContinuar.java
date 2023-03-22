package challenge_conversor_moedas;

import javax.swing.*;

public class TelaDesejaContinuar {
	
	//CONSTRUTOR
	public TelaDesejaContinuar () {
		
		
		//CRIANDO UM FRAME A SER UTILIZADO PELO JOPTIONPANE
				JFrame frame = new JFrame();

				Object[] opcoes = {"SIM", "NÃO", "CANCELAR"};
				
				int n = JOptionPane.showOptionDialog(frame,
				        "DESEJA CONTINUAR",
						"ESCOLHA UMA OPÇÃO",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opcoes,
				opcoes[0]);
  }

}
