public class MyJVMTest_2551 {

    static byte b = -128;

    String getString(byte b) {
        return String.valueOf(b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2551().getString(b));
    }
}
