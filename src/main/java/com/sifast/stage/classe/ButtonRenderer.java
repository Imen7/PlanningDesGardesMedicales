package com.sifast.stage.classe;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

import com.sifast.stage.ihm.Disponibilité;

public class ButtonRenderer implements TableCellRenderer 
{     
JButton button;     

public ButtonRenderer() 
{     
    button = new JButton();     
}     

public Component getTableCellRendererComponent(JTable table,     
        Object value,     
        boolean isSelected,     
        boolean hasFocus,     
        int row, int column) 
{   

    button.setText("afficher disponibilité"); 
    button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Disponibilité frame =new Disponibilité();
			frame.setVisible(true);
		}
	});
    return button;     
}     

}     