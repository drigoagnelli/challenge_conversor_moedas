package challenge_conversor_moedas;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Choice;

public class TelaInicial extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaInicial() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblEscolhaUmaOpo = new JLabel("ESCOLHA UMA OPÇÃO");
		lblEscolhaUmaOpo.setBounds(23, 51, 122, 20);
		add(lblEscolhaUmaOpo);
		
		Choice choice = new Choice();
		choice.setBounds(23, 77, 28, 20);
		add(choice);

	}
}
