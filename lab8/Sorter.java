import java.util.concurrent.RecursiveAction;


public class Sorter extends RecursiveAction {

		protected int[] intArray;
		protected int start = 0;
		protected int end = 0;

		public Sorter(int[] intArray, int start, int end) {
			this.intArray = intArray;
			this.start = start;
			this.end = end;
		}
		public Sorter(int[] intArray) {
			this.intArray = intArray;
			this.start = 0;
			this.end = intArray.length-1;
		}

		protected void compute(){
			if (end - start < 1000000) {
			 sQsort(res[i]);
			} else {
				int mid = (hi+lo)/2;
				Sorter left = new Sorter(lo, mid, res, arr1, arr2);
				Sorter right= new Sorter(mid, hi, res, arr1, arr2);
				left.fork();
				right.compute();
				left.join();
			}
		}
	
public static void main(String[] args) {
	
}
}


