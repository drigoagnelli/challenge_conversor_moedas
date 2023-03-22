package challenge_conversor_moedas;

import javax.swing.*;

public class TelaResultadoConversãoMoeda {
	
	
	//CONSTRUTOR
	public TelaResultadoConversãoMoeda() {
		
		//CRIANDO UM FRAME A SER UTILIZADO PELO JOPTIONPANE
				JFrame frame = new JFrame();
				int teste = 12;
				
		JOptionPane.showMessageDialog(frame, "O VALOR DA CONVERSÃO É : R$ " + teste, "RETORNO DA CONVERSÃO", JOptionPane.INFORMATION_MESSAGE, null);;
		
		
		
		
	}

}
