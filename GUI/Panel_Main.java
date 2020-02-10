import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel_Main extends JPanel {
	private GUI_Settings GS = new GUI_Settings();
	public static JLabel CPU_Label;
	/**
	 * Create the panel.
	 */
	public Panel_Main() {
		setBackground(GS.colors.backround);
		setLayout(null);
		
		JSlider Master_Slider = new JSlider();
		Master_Slider.setOpaque(true);
		Master_Slider.setBackground(GS.colors.backround);
		Master_Slider.setMaximum(100);
		Master_Slider.setMinimum(0);
		/*
		Master_Slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 JSlider sourceSlider=(JSlider)e.getSource();
			       BasicSliderUI ui = (BasicSliderUI)sourceSlider.getUI();
			       int value = ui.valueForXPosition( e.getX() );
			       Master_Slider.setValue(value);
			}
		});
		*/
		Master_Slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				/*
				Lights.setfront(Master_Slider.getValue());
				Lights.setmiddle(Master_Slider.getValue());
				Lights.setback(Master_Slider.getValue());
				*/
				pwmLights.setColor(Row.FRONT, Master_Slider.getValue(), Master_Slider.getValue(), Master_Slider.getValue());
				pwmLights.setColor(Row.MIDDLE, Master_Slider.getValue(), Master_Slider.getValue(), Master_Slider.getValue());
				pwmLights.setColor(Row.BACK, Master_Slider.getValue(), Master_Slider.getValue(), Master_Slider.getValue());
			}
		});
		Master_Slider.setBounds(6, 43, 623, 50);
		add(Master_Slider);
		
		JLabel lblFromtLights = new JLabel("Master Control Unit");
		lblFromtLights.setHorizontalAlignment(SwingConstants.CENTER);
		lblFromtLights.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFromtLights.setBounds(6, 6, 623, 25);
		lblFromtLights.setForeground(GS.colors.text);
		add(lblFromtLights);
		
		JPanel panel = new JPanel();
		panel.setBackground(GS.colors.menu_backround);
		panel.setBounds(6, 95, 200, 200);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCpuTemperature = new JLabel("CPU Temperature");
		lblCpuTemperature.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblCpuTemperature.setForeground(GS.colors.text);
		lblCpuTemperature.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCpuTemperature, BorderLayout.NORTH);
		
		CPU_Label = new JLabel("0.0");
		CPU_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		CPU_Label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(CPU_Label, BorderLayout.CENTER);
		CPU_Label.setForeground(GS.colors.text);
		CPU.initiate();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(GS.colors.menu_backround);
		panel_1.setBounds(216, 95, 200, 200);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(GS.colors.menu_backround);
		panel_2.setBounds(428, 95, 200, 200);
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

	}
}
