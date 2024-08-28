public class MyJVMTest_3034 {

    static String val = "|SHC'X*wnk";

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
        new MyJVMTest_3034().checkFailure(val);
    }
}
