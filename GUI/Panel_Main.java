import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Panel_Main extends JPanel {
	private GUI_Settings GS = new GUI_Settings();
	/**
	 * Create the panel.
	 */
	public Panel_Main() {
		setBackground(GS.colors.backround);
		setLayout(null);
		
		JSlider slider = new JSlider();
		slider.setMaximum(100);
		slider.setMinimum(0);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Lights.setfront(slider.getValue());
			}
		});
		slider.setBounds(6, 43, 623, 29);
		add(slider);
		
		JLabel lblFromtLights = new JLabel("Master");
		lblFromtLights.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFromtLights.setBounds(20, 6, 114, 25);
		lblFromtLights.setForeground(GS.colors.text);
		add(lblFromtLights);

	}
}
