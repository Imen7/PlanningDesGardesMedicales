package com.sifast.stage.ihm;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sifast.stage.modele.PlanningGarde;
import com.toedter.calendar.JDateChooser;

public class AjouterPlanning extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	public static PlanningGarde plan= new PlanningGarde() ;

	// classe principale
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

	// constructeur
	public AjouterPlanning() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Nom du planning

		JLabel lblAjouterNouveauPlanning = new JLabel("Ajouter nouveau planning :");
		lblAjouterNouveauPlanning.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblAjouterNouveauPlanning.setBounds(93, 32, 240, 32);
		contentPane.add(lblAjouterNouveauPlanning);

		JLabel lblNomDuPlanning = new JLabel("Nom du Planning:");
		lblNomDuPlanning.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNomDuPlanning.setBounds(344, 106, 128, 15);
		contentPane.add(lblNomDuPlanning);

		textField = new JTextField();
		textField.setBounds(516, 101, 154, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		// Date debut

		JLabel lblDateDeDbut = new JLabel("Date de d\u00E9but:");
		lblDateDeDbut.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblDateDeDbut.setBounds(344, 165, 110, 14);
		contentPane.add(lblDateDeDbut);

		JDateChooser dateD = new JDateChooser();
		dateD.setDateFormatString("dd-MM-yyyy");
		dateD.setBounds(516, 218, 97, 20);
		contentPane.add(dateD);

		// Date fin

		JLabel lblDateDeFin = new JLabel("Date de fin:");
		lblDateDeFin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblDateDeFin.setBounds(344, 218, 97, 14);
		contentPane.add(lblDateDeFin);

		JDateChooser dateF = new JDateChooser();
		dateF.setDateFormatString("dd-MM-yyyy");
		dateF.setBounds(516, 159, 97, 20);
		contentPane.add(dateF);
		plan.setDateDebut(dateD);
		plan.setDateFin(dateF);
		plan.setNomPlanning(textField.getText());

		// bouton ajouter

		JButton butAjouter = new JButton("Ajouter");
		butAjouter.setBounds(421, 388, 200, 50);
		contentPane.add(butAjouter);
		butAjouter.setBounds(421, 388, 200, 50);
		contentPane.add(butAjouter);

		butAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MembresDeGarde frame = new MembresDeGarde();
				frame.setSize(1000, 600);
				frame.setLocationRelativeTo(null);
				frame.setTitle("Membres de garde");
				frame.setVisible(true);

			}
		});

	}

}
