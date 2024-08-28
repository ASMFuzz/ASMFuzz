import java.util.*;

public class MyJVMTest_14424 {

    static int[] c1 = { 329207104, 0, 9, 3, 0, 0, 9, 1012699096, 2, 0 };

    static int[] c2 = { 0, 5, 1465465442, 0, 2, 0, 2, 0, -1887107303, 8 };

    void foo1() {
        Comparator<int[]> c = new Comparator<int[]>() {

            public int compare(int[] c1, int[] c2) {
                return 0;
            }
        };
        int[][] arr = { { 1 } };
        int[] elem = arr[0];
        Arrays.sort(arr, c);
        Arrays.binarySearch(arr, elem, c);
        Arrays.<int[]>binarySearch(arr, elem, c);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14424().compare(c1, c2));
    }
}
