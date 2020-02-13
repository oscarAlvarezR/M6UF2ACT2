import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

public class UF2ACT2Grafica extends JFrame {

	private JPanel contentPane;

	// Executem
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UF2ACT2Grafica frame = new UF2ACT2Grafica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public UF2ACT2Grafica() {
		
		// Fiquem les variables correctament
		this.setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		UF2ACT2 codiSentencia = new UF2ACT2();
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setMaximumSize(new Dimension(280, 100));
		textArea.setMinimumSize(new Dimension(280, 100));
		textArea.setPreferredSize(new Dimension(280, 100));
		textArea.setSize(new Dimension(280, 100));
		textArea.setEditable(false);
		panel_1.add(textArea);
		
		// Si cliquem cridem al metode de la clase principal
		JButton btnRealitzarConsulta = new JButton("REALITZAR CONSULTA");
		btnRealitzarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textArea.setText(codiSentencia.Consulta());
			}
		});
		panel.add(btnRealitzarConsulta);
		
		
	}

}
