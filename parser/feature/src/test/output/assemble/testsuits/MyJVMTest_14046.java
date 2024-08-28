public class MyJVMTest_14046 {

    static String a = "=pz0F{qd~Z";

    static String b = "{3yops^il*";

    String assertEqual(String a, String b) {
        if (!a.equals(b)) {
            throw new RuntimeException(a + " is not equal to " + b);
        } else {
            System.out.println("Expected: " + a + ", got: " + b);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14046().assertEqual(a, b);
    }
}
