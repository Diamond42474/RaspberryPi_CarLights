import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

public class Frame extends JFrame {

	private JPanel contentPane;
	public static JPanel Panel_Main = new Panel_Main();
	public static JPanel Panel_Menu = new Panel_Menu();
	private GUI_Settings GS = new GUI_Settings();

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
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
	public Frame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 480);
		contentPane = new JPanel();
		contentPane.setBackground(GS.colors.backround2);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JPanel panel = Panel_Main;
		panel.setBounds(159, 6, 635, 474);
		contentPane.add(panel);
		
		JPanel panel_1 = Panel_Menu;
		panel_1.setBounds(6, 6, 147, 474);
		contentPane.add(panel_1);
	}
}
