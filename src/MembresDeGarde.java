import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class MembresDeGarde extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MembresDeGarde frame = new MembresDeGarde();
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
	public MembresDeGarde() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// text
		JTextArea textArea = new JTextArea(
				"Membre de plannning de garde (du plan.DateDebut  au plan.DateDebut ");
		textArea.setFont(new Font("Myanmar Text", Font.ITALIC, 20));
		textArea.setEditable(false);
		textArea.setBounds(30, 27, 926, 48);
		contentPane.add(textArea);

		JTable table = new JTable();

		// table
		Object[] columns = { "membre", "nombre de garde maximale",
				"Disponibilité" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);

		table.setModel(model);

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
		Object[] row = new Object[4];

		JButton btnAdd = new JButton("Ajouter membre");
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnAdd.setBounds(787, 102, 169, 42);
		contentPane.add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				row[0] = new TextField().getText();
				row[1] = new TextField().getText();
				row[2] = new TextField().getText();

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
