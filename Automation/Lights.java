
public class Lights {
	public static void setlights(long percentage) {
		int[] rate = Math.rate(percentage);
		System.out.println(rate[1]+"\n-----\n"+rate[0]);
		for(int i = 0; i < 1; i++) {
				
			for(int ie = 0; ie < rate[1]; ie++) {
				System.out.println("LED is set to: HIGH");
			}
			for(int ie = 0; ie < rate[0]-rate[1]; ie++) {
				System.out.println("LED is set to: LOW");
			}
			
		}
	}

}
