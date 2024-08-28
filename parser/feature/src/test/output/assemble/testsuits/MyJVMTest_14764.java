public class MyJVMTest_14764 {

    static Object x = -583900008;

    static String w = "Y~@LqvZN\\Q";

    String inspect(final Object x, final String w) {
        return w + ": object";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14764().inspect(x, w));
    }
}
