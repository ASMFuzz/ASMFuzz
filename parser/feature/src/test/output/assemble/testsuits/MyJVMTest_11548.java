import java.util.Arrays;

public class MyJVMTest_11548 {

    static int[] arr = { 0, 0, 0, 8, 8, 1679214370, 0, 0, 5, 1053700349 };

    static int[] array = new int[5];

    int[] m(int[] arr) {
        int i = 0;
        for (; i < 2; i++) {
        }
        if (i == 2) {
            arr = array;
        }
        return arr.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_11548().m(arr)));
    }
}
