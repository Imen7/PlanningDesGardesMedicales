package com.sifast.stage.ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import com.sifast.stage.classe.PrefEnum;
import com.sifast.stage.classe.Preference;
import com.toedter.calendar.JDateChooser;
public class Disponibilite extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public Disponibilite() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser dateDispo = new JDateChooser();
		dateDispo.setBounds(161, 87, 87, 20);
		contentPane.add(dateDispo);
		
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
		
		JLabel lblNomDuDocteur = new JLabel("Nom du Docteur ");
		lblNomDuDocteur.setBounds(161, 34, 131, 14);
		contentPane.add(lblNomDuDocteur);
		
		
		Object[][] data = null;
		String[] colomname = { "Date", "Disponibilité" };
		DefaultTableModel model = new DefaultTableModel(data, colomname);
		JTable table = new JTable(model);

		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.black);
		table.setRowHeight(30);
		

		// JScrollPane
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(46, 221, 363, 197);

		contentPane.add(pane);
		Object[] row = new Object[2];

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] = dateDispo.getDate().toInstant().toString().substring(0,10);
				
				if (rbDispo.isSelected()){
				row[1] = PrefEnum.dispo_ok; 
				}
				else if (rbDispoBut.isSelected()){
					row[1] = PrefEnum.dispo_but; 
					}
				else if (rbNotDispo.isSelected()){
					row[1] = PrefEnum.not_dispo; 
					}
				
				model.addRow(row);
               
				Preference.getMapPerference().put(dateDispo.getDate(),(PrefEnum) row[1]);
			}
		});
		
		btnAjouter.setBounds(169, 174, 89, 23);
		contentPane.add(btnAjouter);
		
		JButton btnValider = new JButton("valider ");
		btnValider.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {

			}
			
		});
		btnValider.setBounds(159, 429, 89, 23);
		contentPane.add(btnValider);

	}
	
}
