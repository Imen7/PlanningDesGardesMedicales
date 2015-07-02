package com.sifast.stage.ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import com.sifast.stage.classe.ButtonEditor;
import com.sifast.stage.classe.Docteur;

public class MembresDeGarde extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public MembresDeGarde() {

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
		String[] colomname = { "membre", "nombre de garde maximale par semaine", "Disponibilité" };
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
		Component[] row = new Component[3];
		JButton btnAdd = new JButton("Ajouter membre");
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnAdd.setBounds(787, 102, 169, 42);
		contentPane.add(btnAdd);
		final String[] items = { "1", "2", "3", "4", "5", "6" };
		int numeroLigne = 0;
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				TableColumn nbrGardeColumn = table.getColumnModel().getColumn(1);
				TableColumn dispoColumn = table.getColumnModel().getColumn(2);
				ButtonEditor bt= new ButtonEditor(new JCheckBox());
				JComboBox<String> comboBox = new JComboBox<String>(items);
				nbrGardeColumn.setCellEditor(new DefaultCellEditor(comboBox));
				dispoColumn.setCellEditor(bt);
				model.addRow(row);
				
				Docteur.getMap().put((String) table.getValueAt(numeroLigne, 0),	bt.preference);
				System.out.println(Docteur.getMap().toString());

			}

		});

		// boutton supprimer

		JButton btnSupprimerMembre = new JButton("Supprimer membre");
		btnSupprimerMembre.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnSupprimerMembre.setBounds(610, 102, 169, 42);
		contentPane.add(btnSupprimerMembre);

		btnSupprimerMembre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index >= 0) {
					model.removeRow(index);
				} else {
					System.out.println("Delete Error");
				}
			}
		});

		// bouton Planning

		JButton btnPlanning = new JButton("Planning");
		contentPane.add(btnPlanning);
		btnPlanning.setBounds(842, 479, 89, 23);
		contentPane.add(btnPlanning);
		btnPlanning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Calendar calendar = Calendar.getInstance();
				calendar.setTime(AjouterPlanning.plan.getDateFin().getDate());
				Calendar calMax = Calendar.getInstance();
				calMax.setTime(AjouterPlanning.plan.getDateDebut().getDate());
				// System.out.println((String.format("%1$td/%1$tm/%1$tY",
				// calendar)));
				while (!(String.format("%1$td/%1$tm/%1$tY", calendar).equals(String.format("%1$td/%1$tm/%1$tY", calMax)))) {
					calendar.add(Calendar.DATE, 1);
					// System.out.println((String.format("%1$td/%1$tm/%1$tY",
					// calendar))+ Docteur.map.toString());
					System.out.println(Docteur.map.toString());

				}

			}
		});

	}
}
