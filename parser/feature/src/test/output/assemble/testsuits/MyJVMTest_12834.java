public class MyJVMTest_12834 {

    void test() {
        String text = "abcdefg";
        char returned = text.charAt(6);
        if (returned != 'g') {
            throw new RuntimeException("failed: charAt(6) returned '" + returned + "' instead of 'g'");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12834().test();
    }
}
