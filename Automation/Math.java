
public class Math {
	static long clock = 100;
	private static double gcm(long a, long b) {
		return b == 0 ? a : gcm(b, a % b);
	}
	public static int[] rate(long percentage) {
		if(percentage>100) {
			percentage = 100;
		}
		if(percentage<0) {
			percentage = 0;
		}
	    double gcm = gcm(percentage,clock);
	    int[] out = {(int) (clock / gcm),(int) (percentage / gcm)};
		return out;
	}
}
