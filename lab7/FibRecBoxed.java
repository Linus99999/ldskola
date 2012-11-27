public class FibRecBoxed {
    public static long fibR(long n) {
	if (n==0) {
	    return 0;
	}
	else if (n==1) {
	    return 1; 
	} else {
	    return fibR(n-1) + fibR(n-2);
	}
    }
    public static void main(String[] args) {
	System.out.println(fibR(50));
    }
}