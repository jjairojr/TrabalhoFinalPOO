import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Tela extends JPanel {
	/**
	 * AUTHORS: Artur Frazão, Jairo Júnior VERSION: 1.0
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	public Lista lista = new Lista();
	String str1 = "";
	Date data = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    String strData = formatter.format(data);  

	public Tela() {

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setToolTipText("Digite seu texto aqui");
		textField.setColumns(4);
		// NOME E ESPECIFICAÇÕES DO SISTEMA
		JLabel lblTwitter = new JLabel("TWITTER");
		lblTwitter.setForeground(Color.BLACK);
		lblTwitter.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTwitter.setBackground(SystemColor.controlShadow);
		// DATA E ESPECIFICAÇÕES
		JLabel lblData = new JLabel("DATA: " + strData);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblGetdata = new JLabel();
		// CRIAÇÃO DO BOTÃO SALVAR
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				EntradaDeTexto edt1 = new EntradaDeTexto();
				edt1.setTexto(textField.getText());
				edt1.setData(data);
				if(edt1.verificarLimite() == true & edt1.verificarVazio() == true) {
					lista.salvarNaLista(edt1);
					JOptionPane.showMessageDialog(null, "Salvo com sucesso");
				}
			}
		});
		// CRIAÇÃO DO BOTÃO IMPRIMIR

		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lista.verificarListaVazia() == true){
			JOptionPane.showMessageDialog(null, lista.imprimirLista());
				}
			}
		});
		// CRIAÇÃO DO BOTÃO ARQUIVAR
		JButton btnSalvarArquivo = new JButton("ARQUIVAR");
		btnSalvarArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileWriter fileW = null;
				try {
					fileW = new FileWriter("Twitter.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
				PrintWriter printW = new PrintWriter(fileW);
				printW.print(lista.imprimirLista());
				printW.close();
				if(lista.verificarListaVazia() == true){
					JOptionPane.showMessageDialog(null, "Arquivado com sucesso");
					}
			}
		});

		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i;
				for(i = 0; i < lista.lista.size(); i++) {
					comboBox.addItem(i+1);
					System.out.println(i);
				}
				i = comboBox.getSelectedIndex();
				lista.selecionarNaLista(i);
				System.out.println(comboBox.getSize());
			}
		});
		// CRIAÇÃO DO BOTÃO LISTAR
		JButton btnListar = new JButton("LISTAR");
		btnListar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lista.verificarListaVazia() == true) {
					int i = comboBox.getSelectedIndex();
					if(comboBox.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(null, "Selecione uma entrada válida");
					}
					else JOptionPane.showMessageDialog(null, lista.selecionarNaLista(i));
					comboBox.removeAllItems();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTwitter, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblData)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblGetdata))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSalvarArquivo, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(btnImprimir, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnListar)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(btnSalvar, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))))
					.addContainerGap(20, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTwitter, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addComponent(lblData)
						.addComponent(lblGetdata))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnListar)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnImprimir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSalvarArquivo))
						.addComponent(textField))
					.addGap(134))
		);
		setLayout(groupLayout);
		setVisible(true);

	}
	// INICIALIZAÇÃO DO MAIN
	public static void main(String[] args) {

		JFrame janela = new JFrame("Twitter");
		Tela tela = new Tela();
		janela.getContentPane().add(tela);
		janela.setSize(500, 250);
		janela.setResizable(false);
		janela.setVisible(true);
		tela.setVisible(true);

	}

}
