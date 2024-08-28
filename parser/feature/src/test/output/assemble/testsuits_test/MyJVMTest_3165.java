import java.util.Arrays;

public class MyJVMTest_3165 {

    static int ARR_SIZE = 10;

    static int x = 0;

    static String s = "g\"8vDd|_:O";

    String[] getStringArray() {
        x++;
        return new String[ARR_SIZE];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3165().getStringArray()));
    }
}
