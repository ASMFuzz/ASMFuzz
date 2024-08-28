public class MyJVMTest_4655 {

    static String a = "M\"UmzqPX!y";

    static String b = "}&VIz|4VQ4";

    String assertEqual(String a, String b) {
        if (!a.equals(b)) {
            throw new RuntimeException(a + " is not equal to " + b);
        } else {
            System.out.println("Expected: " + a + ", got: " + b);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4655().assertEqual(a, b);
    }
}
