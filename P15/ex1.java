public class ex1 {

    static void heapSort(int[] array) {
        int size = array.length;
        for (int i = size / 2 - 1; i >= 0; i--) siftDown(array, size, i);
        for (int i = size - 1; i > 0; i--) {
            swap(array, 0, i);
            siftDown(array, i, 0);
        }
    }

    static void siftDown(int[] array, int size, int root) {
        while (true) {
            int left = 2 * root + 1;
            int right = 2 * root + 2;
            int largest = root;
            if (left < size && array[left] > array[largest]) largest = left;
            if (right < size && array[right] > array[largest]) largest = right;
            if (largest == root) return;
            swap(array, root, largest);
            root = largest;
        }
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) return false;
        }
        return true;
    }

    static String format(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    static void test(String label, int[] array) {
        System.out.println(label);
        System.out.println("    before: " + format(array));
        heapSort(array);
        System.out.println("    after:  " + format(array));
        System.out.println("    sorted: " + isSorted(array));
    }

    public static void main(String[] args) {
        test("empty array", new int[]{});
        test("single element", new int[]{7});
        test("random values", new int[]{5, 2, 9, 1, 5, 6});
        test("already sorted", new int[]{1, 2, 3, 4, 5});
        test("reverse sorted", new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1});
        test("repeated values", new int[]{4, 4, 4, 4});
        test("negative values", new int[]{-3, 12, 0, -7, 5});
        test("class example", new int[]{3, 7, 8, 9, 10, 5});
    }
}
