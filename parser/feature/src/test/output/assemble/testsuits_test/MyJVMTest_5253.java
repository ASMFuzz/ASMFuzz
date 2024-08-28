import java.util.Arrays;

public class MyJVMTest_5253 {

    static int ARR_SIZE = 10;

    static int x = 9;

    static String s = "#&^w=)J2VB";

    CharSequence[] getCharSequenceArray() {
        x++;
        return new String[ARR_SIZE];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5253().getCharSequenceArray()));
    }
}
