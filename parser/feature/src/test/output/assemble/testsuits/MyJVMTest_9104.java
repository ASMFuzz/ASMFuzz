import java.lang.invoke.*;
import java.util.Arrays;

public class MyJVMTest_9104 {

    static String[] arr = { "]4`F2Q'M)Z", "EEvD^nipK1", "IjoMdw8Z@r", "HbS;<){jgv", "z-Z$8%\\J*h", "^`Vj!QoKAu", ">.IAY\\rOvA", "`;[m>d]a\\l", "G9~8UfN{`$", "4]IE?=,Lc\\" };

    String[] testCloneObjectArrayCopy(String[] arr) {
        String[] arr2 = new String[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        return arr2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_9104().testCloneObjectArrayCopy(arr)));
    }
}
