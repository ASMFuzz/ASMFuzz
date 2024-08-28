import java.lang.invoke.*;
import java.util.Arrays;

public class MyJVMTest_8816 {

    static int[] arr = { 0, 1, 3, 0, 0, 2, 3, -1528655497, 1, 8 };

    int[] testClonePrimitiveArray(int[] arr) {
        return arr.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8816().testClonePrimitiveArray(arr)));
    }
}
