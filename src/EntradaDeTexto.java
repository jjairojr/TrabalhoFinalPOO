import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class EntradaDeTexto extends Diario {

	Date data;
	String texto;

	public void novaEntrada() {
		// TODO Auto-generated method stub
	}
	// Verificação do limite de caracteres usando Try e Catch
	public boolean verificarLimite() {
		try {
			if (texto.length() > 140) {
				JOptionPane.showMessageDialog(null, "Texto muito longo. Limite de 140 caracteres");
				return false;
			} else
				return true;
		} catch (Exception e) {
			throw e;
		}

	}
	// Verifica se o texto está vazio usando try e catch
	public boolean verificarVazio() {
		try {
			if (texto.equals(null) || texto.isEmpty() == true) {
				JOptionPane.showMessageDialog(null, "Texto vazio");
				return false;
			} else
				return true;
		} catch (Exception e) {
			throw e;
		}
	}
	// Pegando a data do programa
	public Date getData() {
		return data;
	}
	// Formatando a data para Dia/Mes/ANo
	public String getDataFormat() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strData = formatter.format(data);
		return strData;
	}
	// Set da data
	public void setData(Date data) {
		this.data = data;
	}
	// Get do texto
	public String getTexto() {
		return texto;
	}
	// Set do texto
	public void setTexto(String texto) {
		this.texto = texto;
	}

}
