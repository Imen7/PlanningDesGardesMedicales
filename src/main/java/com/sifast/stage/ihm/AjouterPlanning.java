package com.sifast.stage.ihm;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import com.sifast.stage.classe.PlanningGarde;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class AjouterPlanning extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	public static JSpinner nbDoc;
	public static JDateChooser dateDebut;
	public static JDateChooser dateFin;
	private JTextField textField_2;
	

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

		JDateChooser dateD = new JDateChooser();
		dateD.setDateFormatString("dd-MM-yyyy");
		dateD.setBounds(516, 218, 97, 20);
		contentPane.add(dateD);
		dateDebut=dateD;

		JDateChooser dateF = new JDateChooser();
		dateF.setDateFormatString("dd-MM-yyyy");
		dateF.setBounds(516, 159, 97, 20);
		contentPane.add(dateF);
		dateFin= dateF;

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
	public static JDateChooser getDateDebut() {
		return dateDebut;
	}


	public static JDateChooser getDateFin() {
		return dateFin;
	}
	public static JSpinner getNbDoc() {
		return nbDoc;
	}
}
