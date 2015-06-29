package com.sifast.stage.ihm;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JDateChooser;

public class AjouterPlanning extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	public static JSpinner nbDoc;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterPlanning frame = new AjouterPlanning();
					frame.setVisible(true);
					frame.setSize(1000, 600);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Ajouter Planning");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public AjouterPlanning() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAjouterNouveauPlanning = new JLabel(
				"Ajouter nouveau planning :");
		lblAjouterNouveauPlanning.setFont(new Font("Tahoma", Font.BOLD
				| Font.ITALIC, 15));
		lblAjouterNouveauPlanning.setBounds(93, 32, 240, 32);
		contentPane.add(lblAjouterNouveauPlanning);

		JLabel lblNomDuPlanning = new JLabel("Nom du Planning:");
		lblNomDuPlanning
				.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNomDuPlanning.setBounds(344, 106, 128, 15);
		contentPane.add(lblNomDuPlanning);

		JLabel lblDateDeDbut = new JLabel("Date de d\u00E9but:");
		lblDateDeDbut.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblDateDeDbut.setBounds(344, 165, 110, 14);
		contentPane.add(lblDateDeDbut);

		JLabel lblDateDeFin = new JLabel("Date de fin:");
		lblDateDeFin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblDateDeFin.setBounds(344, 218, 97, 14);
		contentPane.add(lblDateDeFin);

		JLabel lblNombreDeDocteurs = new JLabel("Nombre de docteurs:");
		lblNombreDeDocteurs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				12));
		lblNombreDeDocteurs.setBounds(344, 279, 140, 14);
		contentPane.add(lblNombreDeDocteurs);

		textField = new JTextField();
		textField.setBounds(516, 101, 154, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		nbDoc = new JSpinner();
		nbDoc.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		nbDoc.setBounds(516, 277, 37, 20);
		contentPane.add(nbDoc);

		JDateChooser dateDeb = new JDateChooser();
		dateDeb.setDateFormatString("dd-MM-yyyy");
		dateDeb.setBounds(516, 218, 97, 20);
		contentPane.add(dateDeb);

		JDateChooser dateFin = new JDateChooser();
		dateFin.setDateFormatString("dd-MM-yyyy");
		dateFin.setBounds(516, 159, 97, 20);
		contentPane.add(dateFin);

		JButton butAjouter = new JButton("Ajouter");
		butAjouter.setBounds(421, 388, 200, 50);
		contentPane.add(butAjouter);
		butAjouter.setBounds(421, 388, 200, 50);
		contentPane.add(butAjouter);

		butAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new MembresDeGarde().setVisible(true);

				MembresDeGarde frame = new MembresDeGarde();
				frame.setSize(1000, 600);
				frame.setLocationRelativeTo(null);
				frame.setTitle("Membres de garde");
				frame.setVisible(true);

				/*
				 * PlanningGarde plan = new PlanningGarde(textField.getText(),
				 * dateDeb, dateFin);
				 * 
				 * textField_1.setText(plan.NomPlanning);
				 * textField_2.setText(plan
				 * .DateDebut.getDate().toInstant().toString().substring(0,
				 * 10));
				 * textField_3.setText(plan.DateFin.getDate().toInstant().toString
				 * ().substring(0, 10));
				 */

			}
		});

	}

	public static JSpinner getNbDoc() {
		return nbDoc;
	}

}
