import java.util.Arrays;

public class MyJVMTest_12481 {

    static int ARR_SIZE = 10;

    static int x = 7;

    static String s = "(GS5k@}lQo";

    String[] getStringArray() {
        x++;
        return new String[ARR_SIZE];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12481().getStringArray()));
    }
}
