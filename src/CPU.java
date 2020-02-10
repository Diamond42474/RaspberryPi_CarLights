import java.io.IOException;

import com.pi4j.system.SystemInfo;

public class CPU {
	public static void initiate() {
		Thread CPU_Monitoring = new Thread() {
			public void run(){
				while(true) {
				try {
					Panel_Main.CPU_Label.setText(Float.toString(SystemInfo.getCpuTemperature()));
				} catch (NumberFormatException | UnsupportedOperationException | IOException | InterruptedException e1) {
					e1.printStackTrace();
				}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		CPU_Monitoring.start();
	}
}
