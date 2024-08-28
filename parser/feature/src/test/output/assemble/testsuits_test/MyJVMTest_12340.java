public class MyJVMTest_12340 {

    static String val = "Aa^(6y+`<.";

    int checkFailure(String val) {
        int n = 0;
        try {
            n = Integer.parseInt(val);
            System.err.println("parseInt(" + val + ") incorrectly returned " + n);
            throw new RuntimeException();
        } catch (NumberFormatException nfe) {
            ;
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12340().checkFailure(val);
    }
}
