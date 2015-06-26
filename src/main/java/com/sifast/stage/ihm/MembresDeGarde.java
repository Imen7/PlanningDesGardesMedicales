package com.sifast.stage.ihm;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class MembresDeGarde extends JFrame {
		private JPanel contentPane;

		public MembresDeGarde() {

			// System.out.println(AjouterPlanning.getNbDoc().getValue());

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1000, 600);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			// text
			JTextArea textArea = new JTextArea("Membre de plannning de garde (du");
			// + plan.getDateDebut().getDate().toInstant().toString()
			// .substring(0, 10)
			// + " au"
			// + plan.getDateFin().getDate().toInstant().toString()
			// .substring(0, 10) + ")");
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
			Font font = new Font("", 1, 22);
			table.setFont(font);
			table.setRowHeight(30);

			// JScrollPane
			JScrollPane pane = new JScrollPane(table);
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
					//CTRL + SHIFT + O pour générer les imports
					 class TableComponent extends DefaultTableCellRenderer {

					  /**
						 * 
						 */
						private static final long serialVersionUID = 1L;

					public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
					    //Si la valeur de la cellule est un JButton, on transtype cette valeur
					    if (value instanceof JButton)
					      return (JButton) value;
					    else
					      return this;
					  }
					}
					table.setDefaultRenderer(JButton.class, new TableComponent());

					JButton btn= new JButton("Ajouter membre");

					TableColumn nbrGardeColumn = table.getColumnModel()
							.getColumn(1);
					TableColumn dispoColumn = table.getColumnModel()
							.getColumn(2);
					JComboBox<String> comboBox = new JComboBox<String>(items);

					nbrGardeColumn.setCellEditor(new DefaultCellEditor(comboBox));			

					row[0] = new TextField().getText();
					row[2]= new Button();

					model.addRow(row);
				}
			});

			// bouton supprimer

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

		}
	}
