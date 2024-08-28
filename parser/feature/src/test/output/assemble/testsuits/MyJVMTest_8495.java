import java.lang.invoke.*;
import java.util.Arrays;

public class MyJVMTest_8495 {

    static int[] arr = { 959345424, 4, 3, -1811854305, 0, 4, 1, 1843968266, 6, -614515884 };

    int[] testClonePrimitiveArray(int[] arr) {
        return arr.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8495().testClonePrimitiveArray(arr)));
    }
}
