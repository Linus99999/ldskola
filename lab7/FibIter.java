public class FibIter {
    public static long fibi(long n) {
	long temp = 0;
	long temp2 = 1;
	long answer = 0;
	if (n==0 || n==1) return n;
	
	for (int i = 2; i <= n; ++i) {
	    answer = temp + temp2;
	    temp = temp2;
	    temp2 = answer;
	}
	return answer;
    }
    public static void main(String[] args) {
	System.out.print(fibi(30));
    }
}