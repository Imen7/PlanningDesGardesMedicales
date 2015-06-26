package com.sifast.stage.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;

public class Disponibilité extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Disponibilité frame = new Disponibilité();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Disponibilité() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(133, 96, 87, 20);
		contentPane.add(dateChooser);
		
		JDayChooser dayChooser = new JDayChooser();
		dayChooser.setBounds(38, 128, 182, 133);
		contentPane.add(dayChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(255, 96, 87, 20);
		contentPane.add(dateChooser_1);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(226, 127, 198, 153);
		contentPane.add(calendar);
	}
}
