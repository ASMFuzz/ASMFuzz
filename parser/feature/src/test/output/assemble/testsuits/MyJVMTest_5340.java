public class MyJVMTest_5340 {

    static Object x = 1;

    static String w = "xp#[%_gA87";

    String inspect(final Object x, final String w) {
        return w + ": object";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5340().inspect(x, w));
    }
}
