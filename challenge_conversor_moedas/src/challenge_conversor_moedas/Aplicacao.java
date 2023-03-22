package challenge_conversor_moedas;

import javax.swing.*;

public class Aplicacao {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			TelaInicial menuPrincipal = new TelaInicial();
			TelaInputValor valorAConverter = new TelaInputValor();
			TelaSelecaoConversaoMoeda menuConverter = new TelaSelecaoConversaoMoeda();
			TelaResultadoConversãoMoeda resultadoConversao = new TelaResultadoConversãoMoeda();
			TelaNumeronaoDigitado erroTipoEntreda = new TelaNumeronaoDigitado();
			TelaDesejaContinuar desejaContinuar = new TelaDesejaContinuar();
			
		});
		
	}
}
