import javax.swing.JLabel;

public class Run {
	public static JLabel cp = Panel_Main.CPU_Label; 
	public static void main(String[] args) throws InterruptedException{
		pwmLights.initiate();
		Frame.main();
		rgb();
	}
	public static void rgbFlash() throws InterruptedException {
		int wait = 100;
		int rounds = 5;
		for(int i=0;i<rounds;i++) {
			pwmLights.setColor(Row.FRONT, 100, 0, 0);
			Thread.sleep(wait);
			pwmLights.setColor(Row.FRONT, 0, 0, 0);
			Thread.sleep(wait);
		}
		for(int i=0;i<rounds;i++) {
			pwmLights.setColor(Row.FRONT, 0, 100, 0);
			Thread.sleep(wait);
			pwmLights.setColor(Row.FRONT, 0, 0, 0);
			Thread.sleep(wait);
		}
		for(int i=0;i<rounds;i++) {
			pwmLights.setColor(Row.FRONT, 0, 0, 100);
			Thread.sleep(wait);
			pwmLights.setColor(Row.FRONT, 0, 0, 0);
			Thread.sleep(wait);
		}
	}
	public static void rgb() {
		int rVal = 55;
		int gVal = 99;
		int bVal = 1;
		
		int rDir = -1;
		int gDir = 1;
		int bDir = -1;
		try {
			rgbFlash();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true) {
			pwmLights.setColor(Row.FRONT, rVal, gVal, bVal);
			rVal = rVal + rDir;
			gVal = gVal + gDir;
			bVal = bVal + bDir;
			
			if(rVal>=100 || rVal<=0) {
				rDir = rDir * -1;
			}
			if(gVal>=100 || gVal<=0) {
				gDir = gDir * -1;
			}
			if(bVal>=100 || bVal<=0) {
				bDir = bDir * -1;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
