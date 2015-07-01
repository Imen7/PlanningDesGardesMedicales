package com.sifast.stage.ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import com.sifast.stage.classe.ButtonEditor;
import com.sifast.stage.classe.Docteur;
import com.sifast.stage.classe.PlanningGarde;
import com.sifast.stage.classe.Preference;

public class MembresDeGarde extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public MembresDeGarde() {

		System.out.println(AjouterPlanning.getNbDoc().getValue());
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// text
		JTextArea textArea = new JTextArea("Membre de garde ");
		textArea.setFont(new Font("Myanmar Text", Font.ITALIC, 20));
		textArea.setEditable(false);
		textArea.setBounds(30, 27, 926, 48);
		contentPane.add(textArea);

		// table

		Object[][] data = null;
		String[] colomname = { "membre",
				"nombre de garde maximale par semaine", "Disponibilité" };
		DefaultTableModel model = new DefaultTableModel(data, colomname);
		JTable table = new JTable(model);

		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.black);
		table.setRowHeight(30);

		// JScrollPane
		JScrollPane pane = new JScrollPane(table);
		pane.setEnabled(false);
		pane.setBounds(43, 172, 913, 258);

		contentPane.add(pane);

		// bouton ajouter
		Object[] row = new Object[3];
		JButton btnAdd = new JButton("Ajouter membre");
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnAdd.setBounds(787, 102, 169, 42);
		contentPane.add(btnAdd);
		final String[] items = { "1", "2", "3", "4", "5", "6" };

		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				TableColumn nbrGardeColumn = table.getColumnModel()
						.getColumn(1);
				TableColumn dispoColumn = table.getColumnModel().getColumn(2);
				TableColumn nameColumn = table.getColumnModel().getColumn(0);

				JComboBox<String> comboBox = new JComboBox<String>(items);
				JLabel text = new JLabel();
				nbrGardeColumn.setCellEditor(new DefaultCellEditor(comboBox));
				dispoColumn.setCellEditor(new ButtonEditor(new JCheckBox()));
				nameColumn.setIdentifier(text);
				
				model.addRow(row);
	

				Docteur d = new Docteur();
				// d.getMap().put(text.getText(),Preference.getMapPerference());
				// System.out.println(Preference.getMapPerference().toString());

			}

		});

		// boutton supprimer

		JButton btnSupprimerMembre = new JButton("Supprimer membre");
		btnSupprimerMembre.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnSupprimerMembre.setBounds(610, 102, 169, 42);
		contentPane.add(btnSupprimerMembre);

		btnSupprimerMembre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					model.removeRow(i);
				} else {
					System.out.println("Delete Error");
				}
			}
		});
		// bouton Planning

		JButton btnPlanning = new JButton("Planning");
		contentPane.add(btnPlanning);
		btnPlanning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Calendar calendar = Calendar.getInstance();
				calendar.setTime(AjouterPlanning.getDateFin().getDate());
				Calendar calMax = Calendar.getInstance();
				calMax.setTime(AjouterPlanning.getDateDebut().getDate());
				// System.out.println((String.format("%1$td/%1$tm/%1$tY",
				// calendar)));
				while (!(String.format("%1$td/%1$tm/%1$tY", calendar)
						.equals(String.format("%1$td/%1$tm/%1$tY", calMax)))) {
					calendar.add(Calendar.DATE, 1);
					// System.out.println((String.format("%1$td/%1$tm/%1$tY",
					// calendar))+ Docteur.map.toString());
					System.out.println(Docteur.map.toString());

				}

			}
		});
		btnPlanning.setBounds(842, 479, 89, 23);
		contentPane.add(btnPlanning);

	}
}
