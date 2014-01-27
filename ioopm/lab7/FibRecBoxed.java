import java.lang.*;
public class FibRecBoxed {
    public static Long fibR(Long n) {
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
    	Long l = new Long(50);
	System.out.println(fibR(l));
    }
}