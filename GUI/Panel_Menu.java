import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;

public class Panel_Menu extends JPanel {
	private GUI_Settings GS = new GUI_Settings();
	/**
	 * Create the panel.
	 */
	public Panel_Menu() {
		setLayout(null);
		setBackground(GS.colors.menu_backround);
		
		JButton btnMaster = new JButton("Master");
		btnMaster.setBorderPainted(false);
		btnMaster.setForeground(GS.colors.text);
		btnMaster.setOpaque(true);
		btnMaster.setBackground(GS.colors.button);
		btnMaster.setBounds(6, 6, 135, 29);
		add(btnMaster);

	}
}
