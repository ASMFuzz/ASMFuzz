public class MyJVMTest_11827 {

    static byte b = 0;

    String getString(byte b) {
        return String.valueOf(b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11827().getString(b));
    }
}
