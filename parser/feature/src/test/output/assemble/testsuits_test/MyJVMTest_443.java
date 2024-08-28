import java.io.File;

public class MyJVMTest_443 {

    static Object update = -1592078175;

    static Object state = 9;

    static String contents = " `71ww*!)1";

    Object applyUpdate(Object update, Object state) throws Exception {
        ((LogAlignmentTest) state).basicUpdate((String) update);
        return (state);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_443().applyUpdate(update, state));
    }
}
