package challenge_conversor_moedas;

import javax.swing.*;

public class TelasRotinas {
	
	//ATRIBUTOS TIPO STRING	
	private String opcoesIniciais;
	private String opcoesConversaoMoedas;
	private String opcoesConversaoTemperaturas;
	private String[] entradaSistema = {"CONVERSOR DE MOEDAS", "CONVERSOR DE TEMPERATURA"};
	private String[] opcoes = {"SIM", "NÃO", "CANCELAR"};
	private String[] listaConversoesMoedas = {"DE REAIS A DOLARES","DE REAIS A EUROS", "DE REAIS A LIBRAS",
				           "DE REAIS A IENES","DE REAIS A WON COREANO","DE DOLARES A REAIS","DE EUROS A REAIS",	
				           "DE LIBRAS A REAIS","DE IENES A REAIS","DE WON COREANO A REAIS"};
	private String [] simbolosMoeda = {"US$", "€", "£", "¥", "₩", "R$", "R$", "R$", "R$", "R$"};
	private String [] especieDinheiro = {"Dólares", "Euros", "Libras", "Ienes", "Wons", "Reais", "Reais", "Reais", "Reais", "Reais"};
	private String [] listaConversoesTemperaturas = {"DE CELSIUS A KELVIN", "DE CELSIUS A FAHRENHEIT",	 "DE KELVIN A CELSIUS",
				 			"DE FAHRENHEIT A CELSIUS","DE FAHRENHEIT A KELVIN","DE KELVIN A FAHRENHEIT"};
	private String [] simbolosTemperatura = {"K", "°F", "ºC", "ºC", "K", "°F"};
	private String [] tipoTemperatura = {"Kelvin", "Fahrenheit", "Celsius", "Celsius", "Kelvin", "Fahrenheit"};
	private String valorAConverter;
			
	//ATRIBUTOS TIPO JFRAME
	private JFrame frame = new JFrame();
		
	//ATRIBUTOS TIPO ICON
	private Icon icon = null;
		
	//ATRIBUTOS TIPO DOUBLE
	//VERIFICADO EM 23/03/2023 AS 03:08
	private double taxaConversaoMoeda[] = {0.2,0.17,0.15,24.9,244.6,5.26,5.67,6.43,0.04,0.004};
		
	
	//METODOS COMUNS A AMBOS, MOEDA E TEMPERATURA -----------------------------------------------------------------------
	
	//APRESENTA O VALOR DE OPCOES INICIAIS
	public String getOpcoesIniciais() {
		return this.opcoesIniciais;
	}	
	
	//APRESENTA O VALOR A SER CONVERTIDO
	public String getValorAConverter() {
		return this.valorAConverter;
	}
	
	//EXIBE O JOPTIONPANE DA TELA PRINCIPAL
	public void telaMenuPrincipal() {
		opcoesIniciais = (String)JOptionPane.showInputDialog(frame, "ESCOLHA SEU TIPO DE CONVERSOR","MENU", JOptionPane.QUESTION_MESSAGE, icon ,
		             entradaSistema,entradaSistema[0]);
		
		if(opcoesIniciais == null) {
			this.telaConcluidoPrograma();
		}else {
			this.telaInputValor();
		}
	}
		
	
	//EXIBE O JOPTIONPANE DA TELA DE INPUT DE VALOR
	public void telaInputValor() {
		valorAConverter = (String)JOptionPane.showInputDialog(frame, "INSIRA UM VALOR - DECIMAIS SEPARADOS POR PONTO","INPUT", JOptionPane.QUESTION_MESSAGE, icon ,
	                null,null);
		if(valorAConverter == null) {
			this.telaConcluidoPrograma();
		}
	}
	
	//EXIBE O JOPTIONPANE DA TELA DE DESEJA CONTINUAR CONVERSÃO MOEDAS OU TEMPERATURA
	public void telaDesejaContinuar() {
		int codigo = JOptionPane.showOptionDialog(frame,"DESEJA CONTINUAR","ESCOLHA UMA OPÇÃO",
				JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,	opcoes,	opcoes[0]);
	    if(codigo == 0) {
	    	 this.analisarInput();
	    }else if (codigo == 1){
	    	 this.telaFinalizarPrograma();
	    }else {
	    	 this.telaConcluidoPrograma();
	    }
	}
		
	//EXIBE O JOPTIONPANE DA TELA DE FINALIZAR O PROGRAMA	
	public void telaFinalizarPrograma() {
		JOptionPane.showMessageDialog(frame, "PROGRAMA FINALIZADO", "FIM DO SISTEMA", JOptionPane.INFORMATION_MESSAGE, null);;
	}
		
	//EXIBE O JOPTIONPANE DA TELA DE CONCLUIR O PROGRAMA	
	public void telaConcluidoPrograma() {
		JOptionPane.showMessageDialog(frame, "PROGRAMA CONCLUÍDO", "FIM DO SISTEMA", JOptionPane.INFORMATION_MESSAGE, null);;
	}
		
	//EXIBE O JOPTIONPANE DA TELA DE NÃO É NUMERO DIGITADO	
	public void telaNumeroNaoDigitado() {
		JOptionPane.showMessageDialog(frame, "VALOR INVÁLIDO - DECIMAIS SEPARADOS POR PONTO", "ERRO !!!", JOptionPane.INFORMATION_MESSAGE, null);;
	}
			
	//METODO COMPLETO PARA A VALIDAÇÃO DO INPUT CONVERSÃO DE MOEDAS OU DE TEMPERATURAS
	public void analisarInput() {
		
		
		while (this.validainputNumero(this.getValorAConverter()) == false) {
			this.telaNumeroNaoDigitado();
			this.telaMenuPrincipal();
			this.telaInputValor();
		}
			this.escolherAConversao(this.getOpcoesIniciais());
		if (this.getOpcoesIniciais() == entradaSistema[0] ) {
			this.converterMoedas(this.getOpcaoConversaoMoeda(), this.transformaInputEmInteger(this.getValorAConverter()));
		}else {
			this.converterTemperaturas(this.getOpcaoConversaoTemperaturas(), this.transformaInputEmInteger(this.getValorAConverter()));
		}
	}
		
	//METODO QUE ESCOLHE QUAL A TELA DE INPUT SERÁ APRESENTADA, DEPENDENDO DA ESCOLHA NO MENU PRINCIPAL
	public void escolherAConversao(String s) {
		if(s == entradaSistema[0]) {
			telaEscolhaConversaoMoedas();
		}else {
			telaEscolhaConversaoTemperaturas();
		}
	}
			
	//METODO QUE TRANSFORMA O VALOR DO INPUT DE STRING PARA INTEGER
	public double transformaInputEmInteger(String s) {
		double	valorDouble = Double.parseDouble(s);
		return valorDouble;
	}
			
	//METODO QUE VERIFICA SE O QUE FOI DIGITADO E NUMERO
	public boolean validainputNumero(String input){
		boolean valido = false;
		if(input.matches("[0-9].*")){
			valido = true;
		}
		return valido;
	}
		
	
	//METODOS CONVERSOR DE MOEDAS ---------------------------------------------------------------------------------------
	
			
	//APRESENTA O VALOR DE LISTA DE CONVERSÃO DE MOEDAS
	public String getOpcaoConversaoMoeda() {
		return this.opcoesConversaoMoedas;
	}
	
	//EXIBE O JOPTIONPANE DA TELA DE ESCOLHA DE CONVERSÃO DE MOEDA
	public void telaEscolhaConversaoMoedas() {
		opcoesConversaoMoedas = (String)JOptionPane.showInputDialog(frame, "ESCOLHA A MOEDA PARA A QUAL VOCÊ DESEJA GIRAR SEU DINHEIRO","MOEDAS", JOptionPane.PLAIN_MESSAGE, icon ,
					listaConversoesMoedas,listaConversoesMoedas[0]);
		if(opcoesConversaoMoedas == null) {
			this.telaConcluidoPrograma();
		}
	}
	
	//METODO CONVERSÃO MOEDAS
	public double converterMoedas(String s, double valor) {
				
		double resultado = 0;
				
		for (int i = 0; i < listaConversoesMoedas.length; i++) {
			if (s == listaConversoesMoedas[i]) {
			resultado = valor * taxaConversaoMoeda[i];
			telaResultadoCovertidoMoeda(simbolosMoeda[i], especieDinheiro[i], resultado);
			telaDesejaContinuar();
			}
		}
		return resultado;
	}
	
	//EXIBE O JOPTIONPANE DA TELA DE RESULTADO DA CONVERSÃO	DE MOEDAS
		public void telaResultadoCovertidoMoeda(String simbolo, String nomeMoeda, double resultado) {
			JOptionPane.showMessageDialog(frame, "O VALOR DA CONVERSÃO É : " + simbolo + " "  + Math.round(resultado*100.0)/100.0 + " " + nomeMoeda + " ." , "RETORNO DA CONVERSÃO", JOptionPane.INFORMATION_MESSAGE, null);;
		}
	
	//MWTODOS CONVERSOR DE TEMPERATURAS ---------------------------------------------------------------------------------
	
	
	//APRESENTA O VALOR DE LISTA DE CONVERSÃO DE TEMPERATURAS
	public String getOpcaoConversaoTemperaturas () {
	     return this.opcoesConversaoTemperaturas;	
	}
		
	//EXIBE O JOPTIONPANE DA TELA DE ESCOLHA DE CONVERSÃO DE TEMPERATURA
	public void telaEscolhaConversaoTemperaturas() {
		opcoesConversaoTemperaturas = (String)JOptionPane.showInputDialog(frame, "ESCOLHA A TEMPERATURA PARA A QUAL VOCÊ DESEJA GIRAR SEU DINHEIRO","MOEDAS", JOptionPane.PLAIN_MESSAGE, icon ,
						listaConversoesTemperaturas,listaConversoesTemperaturas[0]);
		if(opcoesConversaoTemperaturas == null) {
			this.telaConcluidoPrograma();
		}
	}
		
	//METODO CONVERSÃO TEMPERATURAS
	public double converterTemperaturas(String s, double valor) {
				
		double resultado = 0;
				
		switch (s) {

		case "DE CELSIUS A KELVIN":
			resultado = valor + 273 ;
			telaResultadoCovertidoTemperaturas(resultado, simbolosTemperatura[0], tipoTemperatura[0]);
		break;

		case "DE CELSIUS A FAHRENHEIT":
			resultado = 1.8 * valor +32 ;
			telaResultadoCovertidoTemperaturas(resultado, simbolosTemperatura[1], tipoTemperatura[1]);
		break;

		case "DE KELVIN A CELSIUS":
			resultado = valor - 273 ;
			telaResultadoCovertidoTemperaturas(resultado, simbolosTemperatura[2], tipoTemperatura[2]);
		break;

		case "DE FAHRENHEIT A CELSIUS":
			resultado = (valor - 32)/ 1.8 ;
			telaResultadoCovertidoTemperaturas(resultado, simbolosTemperatura[3], tipoTemperatura[3]);
		break;
		
		case "DE FAHRENHEIT A KELVIN":
			resultado = (valor - 32) * 5 / 9 + 273 ;
			telaResultadoCovertidoTemperaturas(resultado, simbolosTemperatura[4], tipoTemperatura[4]);
		break;
		
		default:
			resultado = (valor - 273) * 1.8 + 32 ;
			telaResultadoCovertidoTemperaturas(resultado, simbolosTemperatura[5], tipoTemperatura[5]);
		}
		telaDesejaContinuar();
		return resultado;
	}

	//EXIBE O JOPTIONPANE DA TELA DE RESULTADO DA CONVERSÃO	DE TEMPERATURAS
	public void telaResultadoCovertidoTemperaturas(double resultado, String simbolo, String tipoTemperatura) {
			JOptionPane.showMessageDialog(frame, "O VALOR DA CONVERSÃO É : " + Math.round(resultado*100.0)/100.0 + " "  + simbolo + " " + tipoTemperatura + " ." , "RETORNO DA CONVERSÃO", JOptionPane.INFORMATION_MESSAGE, null);;
	}
	
}
