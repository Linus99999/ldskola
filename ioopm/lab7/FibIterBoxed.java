import java.lang.*;
public class FibIterBoxed {
	public static Long fibi(Long n) {
		Long temp = new Long(0);
		Long temp2 = new Long(1);
		Long answer = new Long(0);
		if (n==0 || n==1) return n;

		for (int i = 2; i <= n; ++i) {
			answer = temp + temp2;
			temp = temp2;
			temp2 = answer;
		}
		return answer;
	}
	public static void main(String[] args) {
		Long l = new Long(50);
		System.out.print(fibi(l));
	}
}

