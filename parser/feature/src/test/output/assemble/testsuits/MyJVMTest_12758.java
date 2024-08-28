public class MyJVMTest_12758 {

    static byte[] buffer = { -81, -101, 68, 19, -52, -45, 65, 95, 102, -39 };

    static int index = 4;

    byte getByte(byte[] buffer, int index) {
        return buffer[index];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12758().getByte(buffer, index));
    }
}
