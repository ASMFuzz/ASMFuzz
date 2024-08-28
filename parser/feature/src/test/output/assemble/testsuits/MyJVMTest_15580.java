public class MyJVMTest_15580 {

    static String s = "o@N.*o>Qu_";

    String failed(String s) {
        throw new RuntimeException("Failed: " + s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15580().failed(s);
    }
}
