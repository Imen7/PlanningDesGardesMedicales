package com.sifast.stage.ihm;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import com.sifast.stage.ihm.Disponibilite;
import com.sifast.stage.modele.Preference;

public class AfficherDisponibilité extends DefaultCellEditor {

	private static final long serialVersionUID = 1L;

	protected JButton button;
	public ArrayList<Preference> preference;
	private String label;

	private boolean isPushed;

	public AfficherDisponibilité(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(preference);
				fireEditingStopped();

			}
		});
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		if (isSelected) {
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());
		} else {
			button.setForeground(table.getForeground());
			button.setBackground(table.getBackground());
		}
		label = (value == null) ? "afficher disponibilité" : value.toString();
		button.setText(label);
		isPushed = true;
		return button;
	}

	public Object getCellEditorValue() {

		if (isPushed) {
			Disponibilite frame = new Disponibilite();

			frame.setVisible(true);
			frame.setLocationRelativeTo(null);

		}
		isPushed = false;
		return new String(label);
	}

	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}

	public ArrayList<Preference> getPreference() {
		return preference;
	}

	public void setPreference(ArrayList<Preference> preference) {
		this.preference = preference;
	}

	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}
}
