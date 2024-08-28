import java.util.Arrays;

public class MyJVMTest_14673 {

    static int ARR_SIZE = 10;

    static int x = 8;

    static String s = "oC4v`9dnfs";

    CharSequence[] getCharSequenceArray() {
        x++;
        return new String[ARR_SIZE];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_14673().getCharSequenceArray()));
    }
}
