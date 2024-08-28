public class MyJVMTest_8030 {

    static byte v = 0;

    static byte value = 0;

    Byte valueOf(byte v) {
        return new Byte(v);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8030().valueOf(v));
    }
}
