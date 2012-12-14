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
		this.end = intArray.length - 1;
	}

	protected void compute() {
		if (end - start < 4000) {
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

			if (start < right) {
				Sorter forker = new Sorter(intArray, start, right);
				forker.fork();
				if (left < end) {
					Sorter computer = new Sorter(intArray, left, end);
					computer.compute();
				}
				forker.join();
			}
			else if (left < end) {
				Sorter computer = new Sorter(intArray, left, end);
				computer.compute();
			}

			// Sorter forker = new Sorter(intArray, left, end);
			// if (left < end) {
			// forker.fork();

			// }
			// Sorter computer = new Sorter(intArray, start, right);
			// if (start < right) {
			// computer.compute();

			// }
			// forker.join();

		}
	}

	static final ForkJoinPool fjPool = new ForkJoinPool();

	public static void main(String[] args) {
		int med = 0;
		int t = 0;
		// for (int y = 0; y < 50; y++) {
		for (int x = 110000; x > 50; x = x - 200) {
			int[] intArray2 = Quicksort.createArray(x);
			int[] intArray3 = Quicksort.createArray(x);

			// int x = 0;

			// Quicksort.sQsort(intArray2);
			// while (x < intArray2.length) {
			// System.out.println(intArray2[x]);
			// x++;
			// }
			// System.out.print(Quicksort.isCorrect(intArray2));
			long timesQsort = System.nanoTime();
			Quicksort.sQsort(intArray2);
			long timesQsort2 = System.nanoTime();
			long total = timesQsort2 - timesQsort;
			// System.out.println(total+" Nanosekunder     sQsort");

			long time = System.nanoTime();
			fjPool.invoke(new Sorter(intArray3));
			long time2 = System.nanoTime();
			long total2 = time2 - time;
			// System.out.println(total2+" Nanosekunder     insertionsort");
			System.out.println(Quicksort.isCorrect(intArray2));
			System.out.println(Quicksort.isCorrect(intArray3));
			if (total < total2 && x<100000) {
				
				System.out.println(x);
				med += x;
				t++;
			}
		}
		// }
		System.out.println(med / t);
	}
}