import java.lang.invoke.*;
import java.util.Arrays;

public class MyJVMTest_18085 {

    static int[] arr = { 6, 3, -1632448007, 312786244, 8, 1066651856, 9, 0, 3, 1 };

    int[] testClonePrimitiveArray(int[] arr) {
        return arr.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_18085().testClonePrimitiveArray(arr)));
    }
}
