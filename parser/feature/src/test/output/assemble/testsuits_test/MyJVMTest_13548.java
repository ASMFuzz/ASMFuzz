import java.util.*;

public class MyJVMTest_13548 {

    static Integer[] c1 = { 8, 2, 2, 4, 8, 9, 0, 6, 5, -1414949475 };

    static Integer[] c2 = { 0, 513711812, 8, 2, -1273084388, 1, 9, 9, -104707774, 0 };

    void foo2() {
        Comparator<Integer[]> c = new Comparator<Integer[]>() {

            public int compare(Integer[] c1, Integer[] c2) {
                return 0;
            }
        };
        Integer[][] arr = { { 1 } };
        Integer[] elem = arr[0];
        Arrays.sort(arr, c);
        Arrays.binarySearch(arr, elem, c);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13548().compare(c1, c2));
    }
}
