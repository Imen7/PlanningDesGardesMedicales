package com.sifast.stage.ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.sifast.stage.modele.Docteur;
import com.sifast.stage.modele.PdfClass;
import com.sifast.stage.modele.PrefEnum;

public class MembresDeGarde extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static ArrayList<Docteur> docteurs = new ArrayList<Docteur>();
	public static ArrayList<Object> dates = new ArrayList<Object>();
	public static JTable table;
	private String[] arg;

	public MembresDeGarde() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// text

		JTextArea textArea_1 = new JTextArea(AjouterPlanning.plan.getNomPlanning());
		textArea_1.setBackground(Color.LIGHT_GRAY);
		textArea_1.setBounds(213, 32, 156, 46);
		textArea_1.setFont(new Font("Myanmar Text", Font.ITALIC, 20));
		textArea_1.setEditable(false);
		contentPane.add(textArea_1);

		JTextArea textArea = new JTextArea("Membre de garde du " + String.format("%1$td/%1$tm/%1$tY", AjouterPlanning.plan.getDateDebut().getDate()) + " au "
				+ String.format("%1$td/%1$tm/%1$tY", AjouterPlanning.plan.getDateFin().getDate()));
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("Myanmar Text", Font.ITALIC, 20));
		textArea.setEditable(false);
		textArea.setBounds(57, 89, 466, 48);
		contentPane.add(textArea);

		// table

		Object[][] data = null;
		String[] colomname = { "membre", "Disponibilité" };
		DefaultTableModel model = new DefaultTableModel(data, colomname);
		table = new JTable(model);

		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.black);
		table.setRowHeight(30);

		// JScrollPane
		JScrollPane pane = new JScrollPane(table);
		pane.setEnabled(false);
		pane.setBounds(43, 223, 504, 258);

		contentPane.add(pane);

		// bouton ajouter
		Component[] row = new Component[2];
		JButton btnAdd = new JButton("Ajouter membre");
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnAdd.setBounds(88, 161, 169, 42);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				model.addRow(row);
				Docteur docteur = new Docteur();
				docteur.setPreference(new HashMap<String, PrefEnum>());
				docteurs.add(docteur);
				AfficherDisponibilité bt = new AfficherDisponibilité(new JCheckBox());

				TableColumn dispoColumn = table.getColumnModel().getColumn(1);

				dispoColumn.setCellRenderer(new AfficherBouton());
				dispoColumn.setCellEditor(bt);

			}

		});

		// boutton supprimer

		JButton btnSupprimerMembre = new JButton("Supprimer membre");
		btnSupprimerMembre.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnSupprimerMembre.setBounds(321, 161, 169, 42);
		contentPane.add(btnSupprimerMembre);

		btnSupprimerMembre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int indice = table.getSelectedRow();
				if (indice >= 0) {
					model.removeRow(indice);
					docteurs.remove(indice);
				} else {
					System.out.println("Delete Error");
				}
			}
		});

		// bouton Planning  (contient l'algorithme du planning)

		JButton btnPlanning = new JButton("Planning");
		contentPane.add(btnPlanning);
		btnPlanning.setBounds(259, 503, 98, 34);
		contentPane.add(btnPlanning);

		btnPlanning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// mettre les jours du planning dans une liste dates

				dates.clear();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(AjouterPlanning.plan.getDateDebut().getDate());
				Calendar calMax = Calendar.getInstance();
				calMax.setTime(AjouterPlanning.plan.getDateFin().getDate());
				dates.add(String.format("%1$td/%1$tm/%1$tY", calendar));
				while (!(String.format("%1$td/%1$tm/%1$tY", calendar).equals(String.format("%1$td/%1$tm/%1$tY", calMax)))) {
					calendar.add(Calendar.DATE, 1);
					dates.add(String.format("%1$td/%1$tm/%1$tY", calendar));

				}
				if (table.getValueAt(0, 0)==null) 
					JOptionPane.showMessageDialog(null, "Ajouter au moins un membre \n \n                  Svp réssayez", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				else{ 
				
				// ajout des docteurs dans une liste docteurs
				for (int i = 0; i < table.getRowCount(); i++) {
					docteurs.get(i).setNom(table.getValueAt(i, 0).toString());
				}
				
				try {
					PdfClass.main(arg);
				} catch (Exception ex) {
					Logger.getLogger(MembresDeGarde.class.getName()).log(Level.SEVERE, null, ex);
				}}

			}
		});

	}
}
