package com.sifast.stage.classe;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.sifast.stage.ihm.Disponibilite;

public class ButtonEditor extends DefaultCellEditor {
	protected JButton button;

	private String label;

	private boolean isPushed;

	public ButtonEditor(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setText("afficher disponibilité");

		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Disponibilite frame = new Disponibilite();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);

			}
		});
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		button.setForeground(table.getForeground());
		button.setBackground(table.getBackground());

		isPushed = true;
		return button;
	}

}
