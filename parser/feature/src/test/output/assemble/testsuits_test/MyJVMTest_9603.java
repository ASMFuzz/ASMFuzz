import java.io.File;

public class MyJVMTest_9603 {

    static Object update = -182513867;

    static Object state = 5;

    static String contents = "3p `M{&R.g";

    Object applyUpdate(Object update, Object state) throws Exception {
        ((LogAlignmentTest) state).basicUpdate((String) update);
        return (state);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9603().applyUpdate(update, state));
    }
}
