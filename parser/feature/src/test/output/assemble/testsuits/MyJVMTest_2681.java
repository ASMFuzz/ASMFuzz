import java.lang.ref.*;
import java.util.Arrays;

public class MyJVMTest_2681 {

    Object[] fillHeap() {
        Object[] first = null, last = null;
        int size = 1 << 20;
        while (size > 0) {
            try {
                Object[] array = new Object[size];
                if (first == null) {
                    first = array;
                } else {
                    last[0] = array;
                }
                last = array;
            } catch (OutOfMemoryError oome) {
                size = size >>> 1;
            }
        }
        return first;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2681().fillHeap()));
    }
}
