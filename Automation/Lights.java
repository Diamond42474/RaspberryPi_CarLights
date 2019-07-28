import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Lights {
	
	private static int[] front_rate = Math.rate(0);
	private static int[] middle_rate = Math.rate(0);
	private static int[] back_rate = Math.rate(0);
	private static int[] fan_rate = Math.rate(0);
	
	private final static GpioController gpio = GpioFactory.getInstance();
	private static GpioPinDigitalOutput front = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "Front_LEDs", PinState.LOW);
	private static GpioPinDigitalOutput middle = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "Middle_LEDs", PinState.LOW);
	private static GpioPinDigitalOutput back = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Back_LEDs", PinState.LOW);
	private static GpioPinDigitalOutput fan = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "Fan", PinState.LOW);
	
	public static void setfront(int percentage) {
		front_rate = Math.rate(percentage);
	}
	public static void setmiddle(int percentage) {
		middle_rate = Math.rate(percentage);
	}
	public static void setback(int percentage) {
		back_rate = Math.rate(percentage);
	}
	public static void setfan(int percentage) {
		back_rate = Math.rate(percentage);
	}
	
	public static void startup() {
		Thread front_LED = new Thread() {
			public void run() {
				while(true) {
					for(int ie = 0; ie < front_rate[1]; ie++) {
						front.high();
					}
					for(int ie = 0; ie < front_rate[0]-front_rate[1]; ie++) {
						front.low();
					}
				}
			}
		};
		Thread middle_LED = new Thread() {
			public void run() {
				while(true) {
					for(int ie = 0; ie < middle_rate[1]; ie++) {
						middle.high();
					}
					for(int ie = 0; ie < middle_rate[0]-middle_rate[1]; ie++) {
						middle.low();
					}
				}
			}
		};
		Thread back_LED = new Thread() {
			public void run() {
				while(true) {
					for(int ie = 0; ie < back_rate[1]; ie++) {
						back.high();
					}
					for(int ie = 0; ie < back_rate[0]-back_rate[1]; ie++) {
						back.low();
					}
				}
			}
		};
		Thread fan_LED = new Thread() {
			public void run() {
				while(true) {
					for(int ie = 0; ie < fan_rate[1]; ie++) {
						fan.high();
					}
					for(int ie = 0; ie < fan_rate[0]-fan_rate[1]; ie++) {
						fan.low();
					}
				}
			}
		};
		front_LED.start();
		middle_LED.start();
		back_LED.start();
		fan_LED.start();
	}

}
