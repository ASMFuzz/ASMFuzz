import java.util.Arrays;

public class MyJVMTest_13244 {

    static int ARR_SIZE = 10;

    static int x = 0;

    static String s = "-o\\{9lf<l4";

    Object[] getObjArray() {
        x++;
        return new Object[ARR_SIZE];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13244().getObjArray()));
    }
}
