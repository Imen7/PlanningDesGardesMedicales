package com.sifast.stage.ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.sifast.stage.modele.PrefEnum;
import com.toedter.calendar.JDateChooser;

public class Disponibilite extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private HashMap<String, PrefEnum> preference = new HashMap<String, PrefEnum>();

	// constructeur

	public Disponibilite() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Nom docteur

		JLabel lblNomDuDocteur = new JLabel(MembresDeGarde.table.getValueAt(MembresDeGarde.table.getSelectedRow(), 0).toString());
		lblNomDuDocteur.setBounds(161, 34, 131, 14);
		contentPane.add(lblNomDuDocteur);

		// choisir la date

		JDateChooser dateDispo = new JDateChooser();
		dateDispo.setBounds(143, 87, 105, 20);
		contentPane.add(dateDispo);

		// choisir de preference (dispo,dispo_but,dispo_ok)

		JRadioButton rbDispo = new JRadioButton("dispo ");
		buttonGroup.add(rbDispo);
		rbDispo.setBounds(46, 130, 87, 23);
		contentPane.add(rbDispo);

		JRadioButton rbDispoBut = new JRadioButton("dispo_but");
		buttonGroup.add(rbDispoBut);
		rbDispoBut.setBounds(161, 130, 87, 23);
		contentPane.add(rbDispoBut);

		JRadioButton rbNotDispo = new JRadioButton("Not_dispo");
		buttonGroup.add(rbNotDispo);
		rbNotDispo.setBounds(286, 130, 95, 23);
		contentPane.add(rbNotDispo);

		// table (affichage de disponibilité)

		Object[][] data = null;
		String[] colomname = { "Date", "Disponibilité" };
		DefaultTableModel model = new DefaultTableModel(data, colomname);
		JTable table1 = new JTable(model);
		table1.setBackground(Color.LIGHT_GRAY);
		table1.setForeground(Color.black);
		table1.setRowHeight(30);

		// JScrollPane
		JScrollPane pane = new JScrollPane(table1);
		pane.setBounds(46, 221, 363, 197);
		contentPane.add(pane);

		// bouton ajouter

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(169, 174, 89, 23);
		contentPane.add(btnAjouter);
		Object[] row = new Object[2];
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] = String.format("%1$td/%1$tm/%1$tY", dateDispo.getDate());

				if (rbDispo.isSelected()) {
					row[1] = PrefEnum.dispo_ok;
				} else if (rbDispoBut.isSelected()) {
					row[1] = PrefEnum.dispo_but;
				} else if (rbNotDispo.isSelected()) {
					row[1] = PrefEnum.not_dispo;
				}
				model.addRow(row);
			
				preference.put(String.format("%1$td/%1$tm/%1$tY", dateDispo.getDate()),(PrefEnum)row[1]);

			}
		});

		// bouton valider

		JButton btnValider = new JButton("valider ");
		btnValider.setBounds(159, 429, 89, 23);
		contentPane.add(btnValider);
		btnValider.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MembresDeGarde.docteurs.get(MembresDeGarde.table.getSelectedRow()).setPreference(preference);
				setVisible(false);
			}

		});

	}

	// preference set,get

	

}
