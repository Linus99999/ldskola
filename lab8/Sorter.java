import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Sorter extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		this.end = intArray.length;
	}

	protected void compute() {
		if (end - start < 100) {
			Quicksort.sQsort(intArray, start, end);
		} else {
			int left = start;
			int right = end + 1;
			final int pivot = intArray[start];
			int tmp;

			do {

				do {
					left++;
				} while (left <= end && intArray[left] < pivot);
				do {
					right--;
				} while (intArray[right] > pivot);

				if (left < right) {
					tmp = intArray[left];
					intArray[left] = intArray[right];
					intArray[right] = tmp;
				}
			} while (left <= right);
			tmp = intArray[start];
			intArray[start] = intArray[right];
			intArray[right] = tmp;

			
			Sorter forker = new Sorter(intArray, pivot, end);
			Sorter computer = new Sorter(intArray, start, pivot-1);
			forker.fork();
			computer.compute();
			forker.join();
		}
	}

	static final ForkJoinPool fjPool = new ForkJoinPool();

	public static void main(String[] args) {
		int[] intArray2 = Quicksort.createArray(10000);
		fjPool.invoke(new Sorter(intArray2));
		 int x = 0;
		
				Quicksort.sQsort(intArray2);
		while (x < intArray2.length) {
		System.out.println(intArray2[x]);
		x++;
		}
		System.out.print(Quicksort.isCorrect(intArray2));
	}
}
