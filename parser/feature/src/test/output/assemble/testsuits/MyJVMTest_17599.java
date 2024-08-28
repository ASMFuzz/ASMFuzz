public class MyJVMTest_17599 {

    static byte v = -128;

    static byte value = 127;

    Byte valueOf(byte v) {
        return new Byte(v);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17599().valueOf(v));
    }
}
