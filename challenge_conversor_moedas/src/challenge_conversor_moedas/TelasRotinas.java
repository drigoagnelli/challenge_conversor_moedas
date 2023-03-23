package challenge_conversor_moedas;

import javax.swing.*;

public class TelasRotinas {
	
	//ATRIBUTOS TIPO STRING	
	protected String opcoesIniciais;
	protected String opcoesConversaoMoedas;
	protected String opcoesConversaoTemperaturas;
	protected String[] entradaSistema = {"CONVERSOR DE MOEDAS", "CONVERSOR DE TEMPERATURA"};
	protected String[] opcoes = {"SIM", "NÃO", "CANCELAR"};
	protected String[] listaConversoesMoedas = {"DE REAIS A DOLARES","DE REAIS A EUROS", "DE REAIS A LIBRAS",
				           "DE REAIS A IENES","DE REAIS A WON COREANO","DE DOLARES A REAIS","DE EUROS A REAIS",	
				           "DE LIBRAS A REAIS","DE IENES A REAIS","DE WON COREANO A REAIS"};
	protected String [] simbolosMoeda = {"US$", "€", "£", "¥", "₩", "R$", "R$", "R$", "R$", "R$"};
	protected String [] especieDinheiro = {"Dólares", "Euros", "Libras", "Ienes", "Wons", "Reais", "Reais", "Reais", "Reais", "Reais"};
	protected String[] listaConversoesTemperaturas = {"DE CELSIUS A KELVIN", "DE CELSIUS A FAHRENHEIT",	 "DE KELVIN A CELSIUS",
				 			"DE FAHRENHEIT A CELSIUS","DE FAHRENHEIT A KELVIN","DE KELVIN A FAHRENHEIT"};
	protected String [] simbolosTemperatura = {"K", "°F", "ºC", "ºC", "K", "°F"};
	protected String [] tipoTemperatura = {"Kelvin", "Fahrenheit", "Celsius", "Celsius", "Kelvin", "Fahrenheit"};
	protected String valorAConverter;
	protected String temperaturaAConverter;
		
	//ATRIBUTOS TIPO JFRAME
	protected JFrame frame = new JFrame();
		
	//ATRIBUTOS TIPO ICON
	protected Icon icon = null;
		
	//ATRIBUTOS TIPO DOUBLE
	//VERIFICADO EM 23/03/2023 AS 03:08
	protected double taxaConversaoMoeda[] = {0.2,0.17,0.15,24.9,244.6,5.26,5.67,6.43,0.04,0.004};
		
	//APRESENTA O VALOR DE OPCOES INICIAIS
	public String getOpcoesIniciais() {
		return this.opcoesIniciais;
	}	
		
	//APRESENTA O VALOR DE LISTA DE CONVERSÃO DE MOEDAS
	public String getOpcaoConversaoMoeda() {
		return this.opcoesConversaoMoedas;
	}
		
	//APRESENTA O VALOR DE VALOR A CONVERTER
	public String getvalorAConverter() {
		return this.valorAConverter;
	}

	//EXIBE O JOPTIONPANE DA TELA PRINCIPAL
	public String telaMenuPrincipal() {
		return opcoesIniciais = (String)JOptionPane.showInputDialog(frame, "ESCOLHA SEU TIPO DE CONVERSOR","MENU", JOptionPane.QUESTION_MESSAGE, icon ,
	                entradaSistema,entradaSistema[0]);
	}
		
	//EXIBE O JOPTIONPANE DA TELA DE ESCOLHA DE CONVERSÃO DE MOEDA
	public String telaEscolhaConversaoMoedas() {
		return opcoesConversaoMoedas = (String)JOptionPane.showInputDialog(frame, "ESCOLHA A MOEDA PARA A QUAL VOCÊ DESEJA GIRAR SEU DINHEIRO","MOEDAS", JOptionPane.PLAIN_MESSAGE, icon ,
					listaConversoesMoedas,listaConversoesMoedas[0]);
	}
		
	//EXIBE O JOPTIONPANE DA TELA DE ESCOLHA DE CONVERSÃO DE TEMPERATURA
	public String telaEscolhaConversaoTemperaturas() {
		return opcoesConversaoTemperaturas = (String)JOptionPane.showInputDialog(frame, "ESCOLHA A TEMPERATURA PARA A QUAL VOCÊ DESEJA GIRAR SEU DINHEIRO","MOEDAS", JOptionPane.PLAIN_MESSAGE, icon ,
						listaConversoesTemperaturas,listaConversoesTemperaturas[0]);
	}
		
	//EXIBE O JOPTIONPANE DA TELA DE INPUT DE VALOR DE MOEDA
	public String telaInputValor() {
		return valorAConverter = (String)JOptionPane.showInputDialog(frame, "INSIRA UM VALOR","INPUT", JOptionPane.QUESTION_MESSAGE, icon ,
	                null,null);
	}
		
	//EXIBE O JOPTIONPANE DA TELA DE DESEJA CONTINUAR
	public void telaDesejaContinuar() {
		JOptionPane.showOptionDialog(frame,"DESEJA CONTINUAR","ESCOLHA UMA OPÇÃO",
									JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,	opcoes,	opcoes[0]);
		//afirmativoContinuar();
	}
		
	//EXIBE O JOPTIONPANE DA TELA DE FINALIZAR O PROGRAMA	
	public void telaFinalizarPrograma() {
		JOptionPane.showMessageDialog(frame, "PROGRAMA FINALIZADO", "FIM DO SISTEMA", JOptionPane.INFORMATION_MESSAGE, null);;
	}
			
	//EXIBE O JOPTIONPANE DA TELA DE FINALIZAR O PROGRAMA	
	public void telaNumeroNaoDigitado() {
		JOptionPane.showMessageDialog(frame, "VALOR INVÁLIDO", "ERRO !!!", JOptionPane.INFORMATION_MESSAGE, null);;
	}
		
	//EXIBE O JOPTIONPANE DA TELA DE RESULTADO DA CONVERSÃO	
	public void telaResultadoCovertido(String simbolo, String nomeMoeda, double resultado) {
		JOptionPane.showMessageDialog(frame, "O VALOR DA CONVERSÃO É : " + simbolo + " "  + resultado + " " + nomeMoeda + " ." , "RETORNO DA CONVERSÃO", JOptionPane.INFORMATION_MESSAGE, null);;
	}
			
		
	//METODO PARA CONTIUAR EM CASO DE ESCOLHA AFIRMATIVA
	public void afirmativoContinuar() {
		telaInputValor();
		escolherAConversao(getOpcoesIniciais());
		converterMoedas(getOpcaoConversaoMoeda(), transformaInputEmInteger(getvalorAConverter()));
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
	public int transformaInputEmInteger(String s) {
		int	valorInt = Integer.parseInt(s);
		return valorInt;
	}
		
	//METODO QUE VERIFICA SE O QUE FOI DIGITADO E NUMERO
	public boolean validainputNumero(String input){
		boolean valido = false;
		if(input.matches("[0-9]*")){
			valido = true;
		}
		return valido;
	}
		
	//METODO CONVERSÃO MOEDAS
	public double converterMoedas(String s, int valor) {
			
		double resultado = 0;
			
		for (int i = 0; i < listaConversoesMoedas.length; i++) {
			if (s == listaConversoesMoedas[i]) {
			resultado = valor * taxaConversaoMoeda[i];
			telaResultadoCovertido(simbolosMoeda[i], especieDinheiro[i], resultado);
			telaDesejaContinuar();
					 
			}
				 
		}
		return resultado;
	}
		
	//METODO CONVERSÃO TEMPERATURAS
	public double converterTemperaturas(String s, int valor) {
				
		double resultado = 0;
				
		for (int i = 0; i < listaConversoesTemperaturas.length; i++) {
				if (s == listaConversoesTemperaturas[i]) {
					resultado = valor * taxaConversaoMoeda[i];
					telaResultadoCovertido(simbolosTemperatura[i], tipoTemperatura[i], resultado);
					telaDesejaContinuar();
				}
					 
		}
		return resultado;
	}

}
