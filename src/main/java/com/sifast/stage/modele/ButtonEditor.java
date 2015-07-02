package com.sifast.stage.modele;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import com.sifast.stage.ihm.Disponibilite;

public class ButtonEditor extends DefaultCellEditor {

	private static final long serialVersionUID = 1L;

	protected JButton button;
    public Preference preference;
	private String label;

	private boolean isPushed;

	public ButtonEditor(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	System.out.println(preference);
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
			preference=frame.getPreference();
		//	System.out.println(preference.getMapPerference().toString());

		}
		isPushed = false;
		return new String(label);
	}

	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}

	public Preference getPreference() {
		return preference;
	}

	public void setPreference(Preference preference) {
		this.preference = preference;
	}

	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}
}
