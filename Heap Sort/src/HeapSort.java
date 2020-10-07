import java.util.Scanner;

public class HeapSort {
	
	public static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int n = sc.nextInt();
		System.out.print("Enter an exclusive lower bound: ");
		int a = sc.nextInt();
		System.out.print("Enter an exclusive upper bound: ");
		int b = sc.nextInt();
		
		int[] arr = createArray(n, a, b);
		newline();
		System.out.println("Unsorted Array");
		printArray(arr);

		heapSort(arr);
		newline(2);
		System.out.println("Heap Sort");
		printArray(arr);
		
		sc.close();
	}

	public static void heapSort(int arr[]) {
		buildHeap(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			swap(arr, 0, i);
			heapify(arr, 0, i);
		}
	}

	public static void buildHeap(int[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			heapify(arr, i, arr.length);
		}
	}

	public static void heapify(int arr[], int i, int heapSize) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if (left < heapSize && arr[left] > arr[largest]) {
			largest = left;
		}
		if (right < heapSize && arr[right] > arr[largest]) {
			largest = right;
		}
		if (largest != i) {
			swap(arr, i, largest);
			heapify(arr, largest, heapSize);
		}
	}

	public static void printArray(int[] arr) {
		int n = arr.length;
		if (n == 1) {
			System.out.print(arr[0]);
		} else {
			for (int i = 0; i < n; i++) {
				if (i < n - 1) {
					System.out.print(arr[i] + ", ");
					if ((i + 1) % 25 == 0) {
						System.out.println();
					}
				} else {
					System.out.print(arr[i]);
				}
			}
		}
	}

	public static int[] createArray(int size, int a, int b) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = random(a, b);
		}
		return arr;
	}

	public static int random(int a, int b) {
		return (int) ((b - a + 1) * Math.random() + a);
	}

	public static void newline() {
		System.out.println();
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void newline(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println();
		}
	}
}
