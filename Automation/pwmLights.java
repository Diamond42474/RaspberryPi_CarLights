import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;

public class pwmLights {
	private static class Lights{
		public static class Front{
			public static final int r = 8;
			public static final int g = 4;
			public static final int b = 5;
		}
		public static class Middle{
			public static final int r = 15;
			public static final int g = 16;
			public static final int b = 1;
		}
		public static class Back{
			public static final int r = 0;
			public static final int g = 2;
			public static final int b = 3;
		}
	}
	public static void initiate() {
		System.out.println("Initiating...");
		
		Gpio.wiringPiSetup();
		
		SoftPwm.softPwmCreate(Lights.Front.r, 0, 100);
		SoftPwm.softPwmCreate(Lights.Front.g, 0, 100);
		SoftPwm.softPwmCreate(Lights.Front.b, 0, 100);
		
		SoftPwm.softPwmCreate(Lights.Middle.r, 0, 100);
		SoftPwm.softPwmCreate(Lights.Middle.g, 0, 100);
		SoftPwm.softPwmCreate(Lights.Middle.b, 0, 100);
		
		SoftPwm.softPwmCreate(Lights.Back.r, 0, 100);
		SoftPwm.softPwmCreate(Lights.Back.g, 0, 100);
		SoftPwm.softPwmCreate(Lights.Back.b, 0, 100);
		System.out.println("Initiated!!!");
	}
	public static void setColor(Row row, int r, int g, int b) {
		switch(row) {
			case FRONT:
				System.out.println("Setting "+row+" to "+r+" "+g+" "+b);
				SoftPwm.softPwmWrite(Lights.Front.r, r);
				SoftPwm.softPwmWrite(Lights.Front.g, g);
				SoftPwm.softPwmWrite(Lights.Front.b, b);
				break;
			case MIDDLE:
				System.out.println("Setting "+row+" to "+r+" "+g+" "+b);
				SoftPwm.softPwmWrite(Lights.Middle.r, r);
				SoftPwm.softPwmWrite(Lights.Middle.g, g);
				SoftPwm.softPwmWrite(Lights.Middle.b, b);
				break;
			case BACK:
				System.out.println("Setting "+row+" to "+r+" "+g+" "+b);
				SoftPwm.softPwmWrite(Lights.Back.r, r);
				SoftPwm.softPwmWrite(Lights.Back.g, g);
				SoftPwm.softPwmWrite(Lights.Back.b, b);
				break;
		}
	}
}
